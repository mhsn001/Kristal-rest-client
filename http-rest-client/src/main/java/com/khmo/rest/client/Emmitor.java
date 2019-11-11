package com.khmo.rest.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emmitor implements Runnable{

	
	public static List<NumberEntity> numbers;
	public static boolean emitNumbers;
	
	public Emmitor(List<NumberEntity> numbers) {
		super();
		emitNumbers = true;
		this.numbers = numbers;
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		while(emitNumbers) {
			
			List<Integer> nums = new ArrayList<Integer>();
			for(int i=0; i<5; i++) {
				nums.add((int)(Math.random() * 10000) + 1);
			}
			NumberEntity numberHolder = new NumberEntity(nums,new Date().getTime());
			numbers.add(numberHolder);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Emission stopped");
		
		
	}
	
	
	
	public static List<NumberEntity> getCurrentNumbers(){
		System.out.println(numbers);
		return new ArrayList<NumberEntity>(numbers);
	}
	
	
	public void stopEmition() {
		emitNumbers = false;
	}
	
}
