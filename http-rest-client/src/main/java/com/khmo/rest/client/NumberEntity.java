package com.khmo.rest.client;

import java.util.Arrays;
import java.util.List;

public class NumberEntity implements Cloneable{

	List<Integer> numbers;
	long dateTime;
		
	public NumberEntity() {
		// TODO Auto-generated constructor stub
	}
		
	public NumberEntity(List<Integer> numbers, long dateTime) {
		super();
		this.numbers = numbers;
		this.dateTime = dateTime;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (dateTime ^ (dateTime >>> 32));
		result = prime * result + ((numbers == null) ? 0 : numbers.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumberEntity other = (NumberEntity) obj;
		if (dateTime != other.dateTime)
			return false;
		if (numbers == null) {
			if (other.numbers != null)
				return false;
		} else if (!numbers.equals(other.numbers))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "NumberEntity [numbers=" + numbers + ", dateTime=" + dateTime + "]";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}
