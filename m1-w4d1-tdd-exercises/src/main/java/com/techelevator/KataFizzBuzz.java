package com.techelevator;

public class KataFizzBuzz {
	
	public static String FizzBuzzResult(int number) {
		
		if (number < 1 || number > 100){
			return "";
		
		} else if (number % 15 == 0 ) {
			return "FizzBuzz";
		} else if (number % 5 == 0 ) {
			return "Buzz";
		} else if (number % 3 == 0 ) {
			return "Fizz";
		} else if ((Integer.toString(number).contains("3")) && (Integer.toString(number).contains("5"))){
			return "FizzBuzz";
		} else if (Integer.toString(number).contains("3")) {
			return "Fizz";
		} else if (Integer.toString(number).contains("5")) {
			return "Buzz";	
		} else {
			return Integer.toString(number);
		}
	}

}
