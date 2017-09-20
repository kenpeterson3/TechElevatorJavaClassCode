package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) {

		File fizzBuzz = new File("FizzBuzz");
		String output = 0;

		try (PrintWriter writer = new PrintWriter(fizzBuzz)) {
			for (int i = 1; i < 301; i++) {
				if (i % 15 == 0) {
					output = "FizzBuzz";
				} else if (i % 5 == 0) {
					output = "Buzz";
				} else if (i % 3 == 0) {
					output = "Fizz";
				} else if ((Integer.toString(i).contains("3")) && (Integer.toString(i).contains("5"))) {
					output = "FizzBuzz";
				} else if (Integer.toString(i).contains("3")) {
					output = "Fizz";
				} else if (Integer.toString(i).contains("5")) {
					output = "Buzz";
				} else {
					output = Integer.toString(i);
				}
				writer.println(output);

			}

		} catch (FileNotFoundException e) {
			System.out.println("");
			System.exit(1);
		}

	}

}
