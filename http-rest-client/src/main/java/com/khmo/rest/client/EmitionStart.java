package com.khmo.rest.client;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.khmo.rest.client.beans.Employee;

public class EmitionStart {

	public static List<NumberEntity> numbers;

	public static List<NumberEntity> getCurrentNumbers() {
		// System.out.println(numbers);
		return new ArrayList<NumberEntity>(numbers);
	}

	public static void main(String[] args) {

		numbers = new ArrayList<NumberEntity>();
		Thread t = new Thread(new Emmitor(numbers));
		t.start();

		Scanner sc = new Scanner(System.in);
		try {
			while (true) {

				System.out.println("\n###################################\n");

				System.out.println("Hit Y to get cumulative result");
				System.out.println("Hit N to stop emission");

				String s = sc.next();

				if (s.equalsIgnoreCase("Y")) {
					
					//Get Current data from the list
					List<NumberEntity> numbers1 = getCurrentNumbers();
					
					//reversing the list so that data will be in descending order.
					Collections.reverse(numbers1);

					// As we have to show data cumulation till 30 mins thats why sending data from last 1800 seconds
					if (numbers1.size() > 1800) {
						numbers1 = numbers1.subList(0, 1800);
					}

					//Jersy clint to make call
					Client client = ClientBuilder.newClient();
					client.register(JacksonJsonProvider.class);

					GenericEntity<List<NumberEntity>> entity = new GenericEntity<List<NumberEntity>>(numbers1) {};
					
					Map<String, List<Integer>> map = 
							client.target("http://localhost:8080/Kristal-ai/emission/numbers")
							.request(MediaType.APPLICATION_JSON).post(Entity.entity(entity, MediaType.APPLICATION_JSON))
							.readEntity(new GenericType<Map<String, List<Integer>>>() {});
					
					
					//Cumulative Result from spting api
					System.out.println("Result : " + map);

				} else if (s.equalsIgnoreCase("N")) {
					//stop Number Emission
					Emmitor.emitNumbers = false;
					break;
				}

			}
		} catch (Exception e) {
			System.err.println("Error : " + e.getMessage());
		} finally {
			Emmitor.emitNumbers = false;
			sc.close();
		}

	}

}
