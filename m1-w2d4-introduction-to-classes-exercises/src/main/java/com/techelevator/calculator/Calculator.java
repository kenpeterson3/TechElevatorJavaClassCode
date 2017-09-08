package com.techelevator.calculator;

public class Calculator {
//data members
	private int currentValue = 0;
//methods
	 public int add(int addend) {
		 return currentValue += addend;
	 }
	public int multiply(int multiplier) {
		return currentValue = currentValue * multiplier;
	}
	public int subtract(int subtrahend) {
		return currentValue -= subtrahend;
	}
	public int power(int exponent) {
		return (currentValue = (int) Math.pow(currentValue, exponent));
	}
	public void reset() {
		currentValue = 0;
	}
	
//getters only
	public int getCurrentValue() {
		return currentValue;
	}
	
}
