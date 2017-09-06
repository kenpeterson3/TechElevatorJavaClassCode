package com.techelevator;

import java.time.LocalDate;

public class MorningLecture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] name = new char[] {'K' , 'e' , 'n'};
		char[] space = new char[] {' '};
		char[] lastName = new char[] {'P' , 'e' , 't' , 'e' , 'r' , 's' , 'o', 'n'};
		
		char[] fullName = new char [name.length + space.length + lastName.length];
		
		for (int i = 0; i < name.length; i++){
			fullName[ i ] = name[i];
		}
		
		for (int i = 0; i < space.length; i++){
			fullName[ i + name.length] = space[i];
		}
		
		for (int i = 0; i < lastName.length; i++){
			fullName[ i + name.length + space.length] = lastName[i];
		}
		System.out.println(fullName);
		
		String fullNameString = "Ken";
		
		String upperCaseName = fullNameString.toUpperCase();
		
		System.out.println(fullNameString.equalsIgnoreCase(upperCaseName));
		
		System.out.println(upperCaseName);		
		
		System.out.println("Starts with Ke " + fullNameString.startsWith("Ke"));
		
		String choppedString = fullNameString.substring(1, fullNameString.length()-1);
		
		System.out.println(choppedString);
		
		LocalDate today = LocalDate.now();
		
		LocalDate lastWeek = today.minusDays(7);
		
		System.out.println(lastWeek);
		
		long rounded = Math.round(9.6);
		
		System.out.println(rounded);
		
		Integer.
	}

}
