package com.techelevator;

public class MorningExercises {
    /*
    1. This method is named returnNotOne and it returns an int. Change
    it so that it returns something other than a 1.
    */
    public int returnNotOne() {
        return 9;
    }

    /*
    2. This method is named returnNotHalf and it returns a double. Change
    it so that it returns something other than a 0.5.
    */
    public double returnNotHalf() {
        return 5;
    }

    /*
    3. This method needs to return a String. Fix it to return a valid String.
    */
    public String returnName() {
        return "Joe";
    }

    /*
    4. This method currently returns an int. Change it so that it returns a double.
    */
    public double returnDoubleOfTwo() {
        return 2;
    }

    /*
    5. This method should return the language that you're learning. Change
    it so that it does that.
    */
    public String returnNameOfLanguage() {
        return "Java";
    }

    /*
    6. This method uses an if statement to define what to return. Have it
    return true if the if statement passes.
    */
    public boolean returnTrueFromIf() {
        if(true) {
            return true;
        }

        return false;
    }

    /*
    7. This method uses an if to check to make sure that one is equal
    to one. Make sure it returns true when one equals one.
    */
    public boolean returnTrueWhenOneEqualsOne() {
        if(1 == 1) {
            return true;
        }

        return false;
    }

    /*
    8. This method checks a parameter passed to the method to see if it's
    greater than 5 and returns true if it is.
    */
    public boolean returnTrueWhenGreaterThanFive(int number) {
        if(number > 5) {
        		return true;
        } else {
        		return false;
        }
    }

    /*
    9. If you think about it, we really don't need the if statement above.
    How can we rewrite exercise 8 to have only one line of code?
    */
    public boolean returnTrueWhenGreaterThanFiveInOneLine(int number) {
    		boolean result = (number > 5);
        return result; // What can we put here that returns a boolean that we want?
    }

    /*
    10. This method will take a number and do the following things to it:
    * If addThree is true, we'll add three to that number
    * If addFive is true, we'll add five to that number
    * We'll then return the result
    */
    public int returnNumberAfterAddThreeAndAddFive(int number, boolean addThree, boolean addFive) {
        if(addThree) {
            number = number + 3;
        } 

        // We can't use an else here. They could both be true, so we have to check each one.

    		if(addFive) {
    			number += 5;
    		}
    

        return number;
    }

    /*
    11. ++ and -- increments and decrements by 1. But we can put them at the
    beginning and at the end. What's the difference?
    Where can I add a ++ to make the result equal 5?
    */
    public int returnFiveUsingPlusPlus() {
        int number = 0;
        return ++number + number++ + ++number;
    }

    /*
    12. Where can I add a ++ to make the result equal 4?
    */
    public int returnFourUsingPlusPlus() {
        int number = 0;
        return number++ + number++ + ++number;
    }

    /*
    13. Where can I add a -- to make the result equal 0?
    */
    public int returnZeroUsingMinusMinus() {
        int number = 0;
        return number-- + number++ + ++number;
    }

    /*
    14. Where can I add a -- to make the result equal -1?
    */
    public int returnMinusOneUsingMinusMinus() {
        int number = 0;
        return --number + number++ + ++number;
    }

    // Confusing, right? We'll talk about why you never want to do that.

    /*
    15. Write an if statement that returns "Fizz" if the parameter is 3 and returns an empty String for anything else.
    */
    public String returnFizzIfThree(int number) {
    		if( ! (number == 3)) {
    			return "";
    		} else {
    			return "Fizz";
    		}
    }

    /*
    16. Now write the above using the Ternary operator ?:. If you're not sure what this is, you can Google it.
    */
    public String returnFizzIfThreeUsingTernary(int number) {
        return (number == 3) ? "Fizz" : "";
    }

    /*
    17. Write an if/else statement that returns "Fizz" if the parameter is 3, "Buzz" if the parameter is 5 and an empty String for anything else.
    */
    public String returnFizzOrBuzzOrNothing(int number) {
    		if(number == 3){
    			return "Fizz";
    		} else if(number == 5){
    			return "Buzz";
    		} else {
    			return "";
    		}
    }

    /*
    18. Write an if statement that checks if the parameter number is either equal to or greater than 18. Return "Adult" if it is or "Minor" if it's not.
    */
    public String returnAdultOrMinor(int number) {
        if(number >= 18) {
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    19. Now, do it again with a different boolean opeation.
    */
    public String returnAdultOrMinorAgain(int number) {
        if(number > 18 || number == 18) {
            return "Adult";
        } else {
            return "Minor";
        }
    }

    /*
    20. Now, do it again with a different boolean operation. This time, the values are reversed.
    */
    public String returnAdultOrMinorReversed(int number) {
        if( ! (number >= 18)) {
            return "Minor";
        } else {
            return "Adult";
        }
    }
}