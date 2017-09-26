package com.techelevator;

public class Exercises {

	/*
	 Given an array of ints, return the number of 9's in the array.
	 arrayCount9([1, 2, 9]) → 1
	 arrayCount9([1, 9, 9]) → 2
	 arrayCount9([1, 9, 9, 3, 9]) → 3
	 */
	public int arrayCount9(int[] nums) {
		return 0;
	}

	/*
	 Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.
	 arrayFront9([1, 2, 9, 3, 4]) → true
	 arrayFront9([1, 2, 3, 4, 9]) → false
	 arrayFront9([1, 2, 3, 4, 5]) → false
	 */
	public boolean arrayFront9(int[] nums) {
		return false;
	}

	/*
	 Given an array of ints, return true if .. 1, 2, 3, .. appears in the array somewhere.
	 array123([1, 1, 2, 3, 1]) → true
	 array123([1, 1, 2, 4, 1]) → false
	 array123([1, 1, 2, 1, 2, 3]) → true
	 */
	public boolean array123(int[] nums) {
		return false;
	}
	
	/*
	 Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array. 
	 Return true if the array does not contain any triples.
	 noTriples([1, 1, 2, 2, 1]) → true
	 noTriples([1, 1, 2, 2, 2, 1]) → false
	 noTriples([1, 1, 1, 2, 2, 2, 1]) → false
	 */
	public boolean noTriples(int[] nums) {
		return false;
	}

	/*
	 Given an array of ints, return a new array length 2 containing the first and last elements from the 
	 original array. The original array will be length 1 or more.
	 makeEnds([1, 2, 3]) → [1, 3]
	 makeEnds([1, 2, 3, 4]) → [1, 4]
	 makeEnds([7, 4, 6, 2]) → [7, 2]
	 */
	public int[] makeEnds(int[] nums) {
		return new int[]{};
	}

	/*
	 Given an int array length 2, return true if it contains a 2 or a 3.
	 has23([2, 5]) → true
	 has23([4, 3]) → true
	 has23([4, 5]) → false
	 */
	public boolean has23(int[] nums) {
		return false;
	}

	/*
	 Given an int array length 2, return true if it does not contain a 2 or 3.
	 no23([4, 5]) → true
	 no23([4, 2]) → false
	 no23([3, 5]) → false
	 */
	public boolean no23(int[] nums) {
		return false;
	}

	/*
	 Given an int array, return a new array with double the length where its last element is the same as the 
	 original array, and all the other elements are 0. The original array will be length 1 or more. Note: by 
	 default, a new int array contains all 0's.
	 makeLast([4, 5, 6]) → [0, 0, 0, 0, 0, 6]
	 makeLast([1, 2]) → [0, 0, 0, 2]
	 makeLast([3]) → [0, 3]
	 */
	public int[] makeLast(int[] nums) {
		return new int[]{};
	}

	/*
	 Given an int array, return true if the array contains 2 twice, or 3 twice. The array will be length 0, 1, or 2.
	 double23([2, 2]) → true
	 double23([3, 3]) → true
	 double23([2, 3]) → false
	 */
	public boolean double23(int[] nums) {
		return false;
	}

	/*
	 Given an int array length 3, if there is a 2 in the array immediately followed by a 3, set the 3 element to 0. 
	 Return the changed array.
	 fix23([1, 2, 3]) → [1, 2, 0]
	 fix23([2, 3, 5]) → [2, 0, 5]
	 fix23([1, 2, 1]) → [1, 2, 1]
	 */
	public int[] fix23(int[] nums) {
		return new int[]{};
	}

	/*
	 Start with 2 int arrays, a and b, of any length. Return how many of the arrays have 1 as their first element.
	 start1([1, 2, 3], [1, 3]) → 2
	 start1([7, 2, 3], [1]) → 1
	 start1([1, 2], []) → 1
	 */
	public int start1(int[] a, int[] b) {
		return 0;
	}

	/*
	 Start with 2 int arrays, a and b, each length 2. Consider the sum of the values in each array. Return the 
	 array which has the largest sum. In event of a tie, return a.
	 biggerTwo([1, 2], [3, 4]) → [3, 4]
	 biggerTwo([3, 4], [1, 2]) → [3, 4]
	 biggerTwo([1, 1], [1, 2]) → [1, 2]
	 */
	public int[] biggerTwo(int[] a, int[] b) {
		return new int[]{};
	}
	
	/*
	 Given an array of ints of even length, return a new array length 2 containing the middle two elements from 
	 the original array. The original array will be length 2 or more.
	 makeMiddle([1, 2, 3, 4]) → [2, 3]
	 makeMiddle([7, 1, 2, 3, 4, 9]) → [2, 3]
	 makeMiddle([1, 2]) → [1, 2]
	 */
	public int[] makeMiddle(int[] nums) {
		return new int[]{};
	}

	/*
	 Given 2 int arrays, each length 2, return a new array length 4 containing all their elements.
	 plusTwo([1, 2], [3, 4]) → [1, 2, 3, 4]
	 plusTwo([4, 4], [2, 2]) → [4, 4, 2, 2]
	 plusTwo([9, 2], [3, 4]) → [9, 2, 3, 4]
	 */
	public int[] plusTwo(int[] a, int[] b) {
		return new int[]{};
	}

	/*
	 Given an array of ints, swap the first and last elements in the array. Return the modified array. The array 
	 length will be at least 1.
	 swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
	 swapEnds([1, 2, 3]) → [3, 2, 1]
	 swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
	 */
	public int[] swapEnds(int[] nums) {
		return new int[]{};
	}

	/*
	 Given an array of ints, return true if the number of 1's is greater than the number of 4's
	 more14([1, 4, 1]) → true
	 more14([1, 4, 1, 4]) → false
	 more14([1, 1]) → true
	 */
	public boolean more14(int[] nums) {
		return false;
	}

	/*
	 Given a number n, create and return a new int array of length n, containing the numbers 0, 1, 2, ... n-1. 
	 The given n may be 0, in which case just return a length 0 array. You do not need a separate if-statement for 
	 the length-0 case; the for-loop should naturally execute 0 times in that case, so it just works. The syntax to 
	 make a new int array is: new int[desired_length]
	 fizzArray(4) → [0, 1, 2, 3]
	 fizzArray(1) → [0]
	 fizzArray(10) → [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
	 */
	public int[] fizzArray(int n) {
		return new int[]{};
	}

	/*
	 Given an array of ints, return true if every element is a 1 or a 4.
	 only14([1, 4, 1, 4]) → true
	 only14([1, 4, 2, 4]) → false
	 only14([1, 1]) → true
	 */
	public boolean only14(int[] nums) {
		return false;
	}
	
	/*
	 Given an array of ints, return true if it contains no 1's or it contains no 4's.
	 no14([1, 2, 3]) → true
	 no14([1, 2, 3, 4]) → false
	 no14([2, 3, 4]) → true
	 */
	public boolean no14(int[] nums) {
		return false;
	}

	/*
	 Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array.
	 has12([1, 3, 2]) → true
	 has12([3, 1, 2]) → true
	 has12([3, 1, 4, 5, 2]) → true
	 */
	public boolean has12(int[] nums) {
		return false;
	}

	/*
	 Given start and end numbers, return a new array containing the sequence of integers from start up to but 
	 not including end, so start=5 and end=10 yields {5, 6, 7, 8, 9}. The end number will be greater or equal 
	 to the start number. Note that a length-0 array is valid. (See also: FizzBuzz Code)
	 fizzArray3(5, 10) → [5, 6, 7, 8, 9]
	 fizzArray3(11, 18) → [11, 12, 13, 14, 15, 16, 17]
	 fizzArray3(1, 3) → [1, 2]
	 */
	public int[] fizzArray3(int start, int end) {
		return new int[]{};
	}

	/*
	 Given three ints, a b c, return true if one of them is 10 or more less than one of the others.
	 lessBy10(1, 7, 11) → true
	 lessBy10(1, 7, 10) → false
	 lessBy10(11, 1, 7) → true
	 */
	public boolean lessBy10(int a, int b, int c) {
		return false;
	}

	/*
	 You have a green lottery ticket, with ints a, b, and c on it. If the numbers are all different from each other, 
	 the result is 0. If all of the numbers are the same, the result is 20. If two of the numbers are the same, the 
	 result is 10.
	 greenTicket(1, 2, 3) → 0
	 greenTicket(2, 2, 2) → 20
	 greenTicket(1, 1, 2) → 10
	 */
	public int greenTicket(int a, int b, int c) {
		return 0;
	}
	
	/*
	 Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both 
	 go over.
	 blackjack(19, 21) → 21
	 blackjack(21, 19) → 21
	 blackjack(19, 22) → 19
	 */
	public int blackjack(int a, int b) {
		return 0;
	}

	/*
	 Given three ints, a b c, one of them is small, one is medium and one is large. Return true if the three values are evenly 
	 spaced, so the difference between small and medium is the same as the difference between medium and large.
	 evenlySpaced(2, 4, 6) → true
	 evenlySpaced(4, 6, 2) → true
	 evenlySpaced(4, 6, 3) → false
	 */
	public boolean evenlySpaced(int a, int b, int c) {
		return false;
	}

}
