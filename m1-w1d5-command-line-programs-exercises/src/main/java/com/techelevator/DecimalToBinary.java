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
		
		
		for(int i = 0;  i < decimalValuesSeperated.length ; i++) {
		int inputNumber = Integer.parseInt(decimalValuesSeperated[i]);
		System.out.print(inputNumber + " in binary is ");
		
		decimalToBinary(inputNumber);
		System.out.println(" ");
		}				     										
	}	
	public static void decimalToBinary(int inputNumber){
		
		int binaryNumber[] = new int[40];
		int index = 0;
		
		while (inputNumber >0){
			
			binaryNumber[index ++] = inputNumber % 2 ;
			inputNumber = inputNumber / 2;						
		}
		for(int i = index-1;i >= 0;i--){
		       System.out.print(binaryNumber[i]);
	
	}		
	}
}
		
		

// int[] reverseOrder = new int[40]; 
//reverseOrder[reverseOrder.length -1] = binaryNumber;
// array attempt 1 fail
 //	for (int i=0; i<reverseOrder.length; i++){
	//	System.out.print(reverseOrder[i]);
	//}
	 //reverseOrder[arrayCounter] = binaryNumber;
	  // arrayCounter = arrayCounter ++;
	   // int[] reverseOrder = new int[40];
	    // 	int arrayCounter = 0;
	




		
		/*Scanner input = new Scanner(System.in);
		
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
		}*/

