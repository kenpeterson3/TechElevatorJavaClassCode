package com.techelevator;

import java.util.Scanner;

/*
Write a command line program which prompts the user for a series of decimal integer values  
and displays each decimal value as itself and its binary equivalent

$ DecimalToBinary 

Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321

460 in binary is 111001100
8218 in binary is 10000000011010
1 in binary is 1
31313 in binary is 111101001010001
987654321 in binary is 111010110111100110100010110001
*/
public class DecimalToBinary {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		
		String decimalValuesEntered = input.nextLine();
		String[] decimalValuesSeperated = decimalValuesEntered.split(" ");
		
		for  ( int i = 0; i < decimalValuesSeperated.length; i++){
			
		int number = Integer.parseInt(decimalValuesSeperated[i]);{
			
			String binNum = " ";
			
			
			while (number>0);
			binNum = (number % 2) + binNum;
			number = number / 2;
			System.out.println(number);
		}
		}
		

	}
	
}
