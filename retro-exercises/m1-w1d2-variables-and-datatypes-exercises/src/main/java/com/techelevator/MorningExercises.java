package com.techelevator;

public class MorningExercises {

	public static void main(String[] args) {
		
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises;
		numberOfExercises = 26;
		
		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		
		double half = 0.5;

		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		
		String name = "TechElevator";

		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		
		int seasonsOfFirefly = 1;

		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		
		String myFavoriteLanguage;
		myFavoriteLanguage = "Java";

		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		
		double pi = 3.1416;

		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		
		String myName;
		myName = "Joe";

		System.out.println(myName);
		
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		
		int numberOfButtons = 5;
		System.out.println(numberOfButtons);
		
		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		
		double batteryPercentage;
		batteryPercentage = 2 / (3 * 100.0);
		
		String batteryPercentageString = batteryPercentage + "%";
		
		System.out.println(batteryPercentage + "%");
		

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		
		int diff = 121 - 27;

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		
		double sum = 12.3 + 32.1;
		System.out.println(sum);

		/*
		12. Create a String that holds your full name.
		*/
		
		String myFullName = myName + " " + "Erickson";
		System.out.println(myFullName);

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		
		String greeting = "Hello, " + myFullName;
		System.out.println(greeting);

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		
		myFullName += " Esquire";
		System.out.println(myFullName);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		
		String badMovie = "Saw" + 2;
		System.out.println(badMovie);

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/
		
		badMovie = 0 + badMovie;
		System.out.println(badMovie);

		/*
		18. What is 4.4 divided by 2.2?
		*/
		
		System.out.println(4.4 / 2.2);

		/*
		19. What is 5.4 divided by 2?
		*/
		System.out.println(5.4 / 2);


		/*
		20. What is 5 divided by 2?
		*/
		
		int roundedNumber = (int) Math.round(5.0 / 2.0);
		
		System.out.println(roundedNumber);
		
		int zero = '0';
		System.out.println(zero);


		/*
		21. What is 5.0 divided by 2?
		*/

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		
		System . out . println(66.6 / 100);

		/*
		23. What is the String "2" added to the number 10?
		*/

		/*
		24. What is 1,000,000,000 * 3?
		*/
		
		int billion = 1000000000 * 3;
		System.out.println(billion);
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		
		boolean doneWithExercises = false;

		/*
		26. Now set doneWithExercise to true.
		*/
		
		doneWithExercises = true;
		
	}

}
