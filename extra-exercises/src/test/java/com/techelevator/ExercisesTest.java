package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExercisesTest {
	
	Exercises exercises = new Exercises();

    /*
    Given an integer array, return the array with all of the duplicate values removed.
    arrayDeduplication([8, 13, 13, 9, 11, 12]) → [8, 13, 9, 11, 12]
    arrayDeduplication([]) → []        
    arrayDeduplication([1, 1, 1]) → [1]
    */
	@Test
    public void arrayDeduplication() {
		assertArrayEquals("Input: {8, 13, 13, 9, 11, 12})", new int[]{8, 13, 9, 11, 12}, exercises.arrayDeduplication(new int[]{8, 13, 13, 9, 11, 12}));
		assertArrayEquals("Input: {})", new int[]{}, exercises.arrayDeduplication(new int[]{}));
		assertArrayEquals("Input: {1, 1, 1})", new int[]{1}, exercises.arrayDeduplication(new int[]{1, 1, 1}));
    }

	/*
    arrayIntersection([1, 3, 5], [1, 5, 7]) → [1, 5]
    arrayIntersection([1], [1, 5, 7]) → [1]
    arrayIntersection([1, 5, 7], [1]) → [1]
    arrayIntersection([1, 1, 1], [1, 5, 7]) → [1]
    arrayIntersection([], []) → []
    */
	@Test
    public void arrayIntersection() {
		assertArrayEquals("Input: {1, 3, 5}, {1, 5, 7})", new int[]{1, 5}, exercises.arrayIntersection(new int[]{1, 3, 5}, new int[]{1, 5, 7}));
		assertArrayEquals("Input: {1}, {1, 5, 7})", new int[]{1}, exercises.arrayIntersection(new int[]{1}, new int[]{1, 5, 7}));
		assertArrayEquals("Input: {1, 5, 7}, {1})", new int[]{1}, exercises.arrayIntersection(new int[]{1, 5, 7}, new int[]{1}));
		assertArrayEquals("Input: {1, 1, 1}, {1, 5, 7})", new int[]{1}, exercises.arrayIntersection(new int[]{1, 1, 1}, new int[]{1, 5, 7}));
		assertArrayEquals("Input: {}, {})", new int[]{}, exercises.arrayIntersection(new int[]{}, new int[]{}));
    }
	
    /*
    arraySort([8, 13, 9, 12]) → [8, 9, 12, 13]
    arraySort([]) → []
    arraySort([100]) → [100]
    arraySort([5, -3, 15]) → [-3, 5, 15]
    */
	@Test
    public void arraySort() {
		assertArrayEquals("Input: {8, 13, 9, 12})", new int[]{8, 9, 12, 13}, exercises.arraySort(new int[]{8, 13, 9, 12}));
		assertArrayEquals("Input: {8, 13, 9, 12})", new int[]{8, 9, 12, 13}, exercises.arraySort(new int[]{8, 13, 9, 12}));
		assertArrayEquals("Input: {8, 13, 9, 12})", new int[]{8, 9, 12, 13}, exercises.arraySort(new int[]{8, 13, 9, 12}));
    }

    /*
    blackjack(19, 21) → 21
    blackjack(21, 19) → 21
    blackjack(19, 22) → 19
    blackjack(22, 19) → 19
	blackjack(22, 50) → 0
	blackjack(22, 22) → 0
	blackjack(33, 1) → 1
	blackjack(1, 2) → 2
	blackjack(34, 33) → 0
	blackjack(17, 19) → 19
	blackjack(18, 17) → 18
	blackjack(16, 23) → 16
	blackjack(3, 4) → 4
	blackjack(3, 2) → 3
	blackjack(21, 20) → 21
    */
	@Test
    public void blackjack() {
		areEqual(21, exercises.blackjack(19, 21), "Input: 19, 21");
		areEqual(21, exercises.blackjack(21, 19), "Input: 21, 19");
		areEqual(19, exercises.blackjack(19, 22), "Input: 19, 22");
		areEqual(19, exercises.blackjack(22, 19), "Input: 22, 19");
		areEqual(0, exercises.blackjack(22, 50), "Input: 22, 50");
		areEqual(0, exercises.blackjack(22, 22), "Input: 22, 22");
		areEqual(1, exercises.blackjack(33, 1), "Input: 33, 1");
		areEqual(2, exercises.blackjack(1, 2), "Input: 1, 2");
		areEqual(0, exercises.blackjack(34, 33), "Input: 34, 33");
		areEqual(19, exercises.blackjack(17, 19), "Input: 17, 19");
		areEqual(18, exercises.blackjack(18, 17), "Input: 18, 17");
		areEqual(16, exercises.blackjack(16, 23), "Input: 16, 23");
		areEqual(4, exercises.blackjack(3, 4), "Input: 3, 4");
		areEqual(3, exercises.blackjack(3, 2), "Input: 3, 2");
		areEqual(21, exercises.blackjack(21, 20), "Input: 21, 20");
    }
    
    /*
    closeFar(1, 2, 10) → true
    closeFar(1, 2, 3) → false
    closeFar(4, 1, 3) → true
    closeFar(4, 5, 3) → false
	closeFar(4, 3, 5) → false
	closeFar(-1, 10, 0) → true
	closeFar(0, -1, 10) → true
	closeFar(10, 10, 8) → true
	closeFar(10, 8, 9) → false
	closeFar(8, 9, 10) → false
	closeFar(8, 9, 7) → false
	closeFar(8, 6, 9) → true
    */
	@Test
    public void closeFar() {
		areEqual(true, exercises.closeFar(1, 2, 10), "Input: 1, 2, 10");
		areEqual(false, exercises.closeFar(1, 2, 3), "Input: 1, 2, 3");
		areEqual(true, exercises.closeFar(4, 1, 3), "Input: 4, 1, 3");
		areEqual(false, exercises.closeFar(4, 5, 3), "Input: 4, 5, 3");
		areEqual(false, exercises.closeFar(4, 3, 5), "Input: 4, 3, 5");
		areEqual(true, exercises.closeFar(-1, 10, 0), "Input: -1, 10, 0");
		areEqual(true, exercises.closeFar(0, -1, 10), "Input: 0, -1, 10");
		areEqual(true, exercises.closeFar(10, 10, 8), "Input: 10, 10, 8");
		areEqual(false, exercises.closeFar(10, 8, 9), "Input: 10, 8, 9");
		areEqual(false, exercises.closeFar(8, 9, 10), "Input: 8, 9, 10");
		areEqual(false, exercises.closeFar(8, 9, 7), "Input: 8, 9, 7");
		areEqual(true, exercises.closeFar(8, 6, 9), "Input: 8, 6, 9");
    }

    /*
    countClumps([1, 2, 2, 3, 4, 4]) → 2
    countClumps([1, 1, 2, 1, 1]) → 2
    countClumps([1, 1, 1, 1, 1]) → 1
    countClumps([1, 2, 3]) → 0
	countClumps([2, 2, 1, 1, 1, 2, 1, 1, 2, 2]) → 4
	countClumps([0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2]) → 4
	countClumps([0, 0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2]) → 5
	countClumps([0, 0, 0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2]) → 5
	countClumps([]) → 0
    */
	@Test
    public void countClumps() {
		areEqual(2, exercises.countClumps(new int[] {1, 2, 2, 3, 4, 4}), "Input: {1, 2, 2, 3, 4, 4}");
		areEqual(2, exercises.countClumps(new int[] {1, 1, 2, 1, 1}), "Input: {1, 1, 2, 1, 1}");
		areEqual(1, exercises.countClumps(new int[] {1, 1, 1, 1, 1}), "Input: {1, 1, 1, 1, 1}");
		areEqual(0, exercises.countClumps(new int[] {1, 2, 3}), "Input: {1, 2, 3}");
		areEqual(4, exercises.countClumps(new int[] {2, 2, 1, 1, 1, 2, 1, 1, 2, 2}), "Input: {2, 2, 1, 1, 1, 2, 1, 1, 2, 2}");
		areEqual(4, exercises.countClumps(new int[] {0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2}), "Input: {0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2}");
		areEqual(5, exercises.countClumps(new int[] {0, 0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2}), "Input: {0, 0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2}");
		areEqual(5, exercises.countClumps(new int[] {0, 0, 0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2}), "Input: {0, 0, 0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2}");
		areEqual(0, exercises.countClumps(new int[] {}), "Input: {}");
    }

    /*
    findPermutations(null) → {}
    findPermutations("") → {}
    findPermutations("A") → {"A"}
    findPermutations("ABC") → {"ABC","ACB","BAC","BCA","CAB", "CBA"}
    findPermutations("ACB") → {"ABC","ACB","BAC","BCA","CAB", "CBA"}
    findPermutations("BCA") → {"ABC","ACB","BAC","BCA","CAB", "CBA"}
    */
	@Test
    public void findPermutations() {
		
		/*
		 * Purposely didn't test findPermutation(null) or findPermutation("") in order to avoid 
		 * generating misleading errors when students run the unit tests on their laptops.
		 * The two conditions are actually tested in the solutions version of the unit tests.
		 * 
		 * I mention it just in case you noticed the two conditions were not being tested.
		 */
		
		List<String> trialList = exercises.findPermutations("A");
		String failureMessage = compareArrayLists(new ArrayList<>(Arrays.asList("A")),	trialList);
		if (failureMessage != null) fail("Input: findPermutations(\"A\")" + failureMessage);	

		trialList = exercises.findPermutations("AB");
		failureMessage = compareArrayLists(new ArrayList<>(Arrays.asList("AB","BA")),	trialList);
		if (failureMessage != null) fail("Input: findPermutations(\"ABC\")" + failureMessage);	

		trialList = exercises.findPermutations("ABC");
		failureMessage = compareArrayLists(new ArrayList<>(Arrays.asList("ABC","ACB","BAC","BCA","CAB","CBA")),	trialList);
		if (failureMessage != null) fail("Input: findPermutations(\"ABC\")" + failureMessage);	

		trialList = exercises.findPermutations("ACB");
		failureMessage = compareArrayLists(new ArrayList<>(Arrays.asList("ABC","ACB","BAC","BCA","CAB","CBA")),	trialList);
		if (failureMessage != null) fail("Input: findPermutations(\"ABC\")" + failureMessage);	
		
		trialList = exercises.findPermutations("BCA");
		failureMessage = compareArrayLists(new ArrayList<>(Arrays.asList("ABC","ACB","BAC","BCA","CAB","CBA")),	trialList);
		if (failureMessage != null) fail("Input: findPermutations(\"ABC\")" + failureMessage);	
	}

    /*
    * has271([1, 2, 7, 1]) → true
    * has271([1, 2, 8, 1]) → false
    * has271([2, 7, 1]) → true     
	* has271([3, 8, 2]) → true
	* has271([2, 7, 3]) → true
	* has271([2, 7, 4]) → false
	* has271([2, 7, -1]) → true
	* has271([2, 7, -2]) → false
	* has271([4, 5, 3, 8, 0]) → true
	* has271([2, 7, 5, 10, 4]) → true
	* has271([2, 7, -2, 4, 9, 3]) → true
	* has271([2, 7, 5, 10, 1]) → false
	* has271([2, 7, -2, 4, 10, 2]) → false
	*/
	@Test
	public void has271() {
		areEqual(true, exercises.has271(new int[] {1, 2, 7, 1}), "Input: {1, 2, 7, 1}");
		areEqual(false, exercises.has271(new int[] {1, 2, 8, 1}), "Input: {1, 2, 8, 1}");
		areEqual(true, exercises.has271(new int[] {2, 7, 1}), "Input: {2, 7, 1}");
		areEqual(true, exercises.has271(new int[] {3, 8, 2}), "Input: {3, 8, 2}");
		areEqual(true, exercises.has271(new int[] {2, 7, 3}), "Input: {2, 7, 3}");
		areEqual(false, exercises.has271(new int[] {2, 7, 4}), "Input: {2, 7, 4}");
		areEqual(true, exercises.has271(new int[] {2, 7, -1}), "Input: {2, 7, -1}");
		areEqual(false, exercises.has271(new int[] {2, 7, -2}), "Input: {2, 7, -2}");
		areEqual(true, exercises.has271(new int[] {4, 5, 3, 8, 0}), "Input: {4, 5, 3, 8, 0}");
		areEqual(true, exercises.has271(new int[] {2, 7, 5, 10, 4}), "Input: {2, 7, 5, 10, 4}");
		areEqual(true, exercises.has271(new int[] {2, 7, -2, 4, 9, 3}), "Input: {2, 7, -2, 4, 9, 3}");
		areEqual(false, exercises.has271(new int[] {2, 7, 5, 10, 1}), "Input: {2, 7, 5, 10, 1}");
		areEqual(false, exercises.has271(new int[] {2, 7, -2, 4, 10, 2}), "Input: {2, 7, -2, 4, 10, 2}");
	}

    /*
    lastDigit(23, 19, 13) → true
    lastDigit(23, 19, 12) → false
    lastDigit(23, 19, 3) → true
    lastDigit(23, 19, 39) → true
	lastDigit(1, 2, 3) → false
	lastDigit(1, 1, 2) → true
	lastDigit(1, 2, 2) → true
	lastDigit(14, 25, 43) → false
	lastDigit(14, 25, 45) → true
	lastDigit(248, 106, 1002) → false
	lastDigit(248, 106, 1008) → true
	lastDigit(10, 11, 20) → true
	lastDigit(0, 11, 0) → true
    */
    @Test
    public void lastDigit() {
		areEqual(true, exercises.lastDigit(23, 19, 13), "Input: 23, 19, 13");
		areEqual(false, exercises.lastDigit(23, 19, 12), "Input: 23, 19, 12");
		areEqual(true, exercises.lastDigit(23, 19, 3), "Input: 23, 19, 3");
		areEqual(true, exercises.lastDigit(23, 19, 39), "Input: 23, 19, 39");
		areEqual(false, exercises.lastDigit(1, 2, 3), "Input: 1, 2, 3");
		areEqual(true, exercises.lastDigit(1, 1, 2), "Input: 1, 1, 2");
		areEqual(true, exercises.lastDigit(1, 2, 2), "Input: 1, 2, 2");
		areEqual(false, exercises.lastDigit(14, 25, 43), "Input: 14, 25, 43");
		areEqual(true, exercises.lastDigit(14, 25, 45), "Input: 14, 25, 45");
		areEqual(false, exercises.lastDigit(248, 106, 1002), "Input: 248, 106, 1002");
		areEqual(true, exercises.lastDigit(248, 106, 1008), "Input: 248, 106, 1008");
		areEqual(true, exercises.lastDigit(10, 11, 20), "Input: 10, 11, 20");
		areEqual(true, exercises.lastDigit(0, 11, 0), "Input: 0, 11, 0");
    }

    /*
    makeBricks(3, 1, 8) → true
    makeBricks(3, 1, 9) → false
    makeBricks(3, 2, 10) → true
	makeBricks(3, 2, 8) → true
	makeBricks(3, 2, 9) → false
	makeBricks(6, 1, 11) → true
	makeBricks(6, 0, 11) → false
	makeBricks(1, 4, 11) → true
	makeBricks(0, 3, 10) → true
	makeBricks(1, 4, 12) → false
	makeBricks(3, 1, 7) → true
	makeBricks(1, 1, 7) → false
	makeBricks(2, 1, 7) → true
	makeBricks(7, 1, 11) → true
	makeBricks(7, 1, 8) → true
	makeBricks(7, 1, 13) → false
	makeBricks(43, 1, 46) → true
	makeBricks(40, 1, 46) → false
	makeBricks(40, 2, 47) → true
	makeBricks(40, 2, 50) → true
	makeBricks(40, 2, 52) → false
	makeBricks(22, 2, 33) → false
	makeBricks(0, 2, 10) → true
	makeBricks(1000000, 1000, 1000100) → true
	makeBricks(2, 1000000, 100003) → false
	makeBricks(20, 0, 19) → true
	makeBricks(20, 0, 21) → false
	makeBricks(20, 4, 51) → false
	makeBricks(20, 4, 39) → true
    */
	@Test
    public void makeBricks() {
		areEqual(true, exercises.makeBricks(3, 1, 8), "Input: 3, 1, 8");
		areEqual(false, exercises.makeBricks(3, 1, 9), "Input: 3, 1, 9");
		areEqual(true, exercises.makeBricks(3, 2, 10), "Input: 3, 2, 10");
		areEqual(true, exercises.makeBricks(3, 2, 8), "Input: 3, 2, 8");
		areEqual(false, exercises.makeBricks(3, 2, 9), "Input: 3, 2, 9");
		areEqual(true, exercises.makeBricks(6, 1, 11), "Input: 6, 1, 11");
		areEqual(false, exercises.makeBricks(6, 0, 11), "Input: 6, 0, 11");
		areEqual(true, exercises.makeBricks(1, 4, 11), "Input: 1, 4, 11");
		areEqual(true, exercises.makeBricks(0, 3, 10), "Input: 0, 3, 10");
		areEqual(false, exercises.makeBricks(1, 4, 12), "Input: 1, 4, 12");
		areEqual(true, exercises.makeBricks(3, 1, 7), "Input: 3, 1, 7");
		areEqual(false, exercises.makeBricks(1, 1, 7), "Input: 1, 1, 7");
		areEqual(true, exercises.makeBricks(2, 1, 7), "Input: 2, 1, 7");
		areEqual(true, exercises.makeBricks(7, 1, 11), "Input: 7, 1, 11");
		areEqual(true, exercises.makeBricks(7, 1, 8), "Input: 7, 1, 8");
		areEqual(false, exercises.makeBricks(7, 1, 13), "Input: 7, 1, 13");
		areEqual(true, exercises.makeBricks(43, 1, 46), "Input: 43, 1, 46");
		areEqual(false, exercises.makeBricks(40, 1, 46), "Input: 40, 1, 46");
		areEqual(true, exercises.makeBricks(40, 2, 47), "Input: 40, 2, 47");
		areEqual(true, exercises.makeBricks(40, 2, 50), "Input: 40, 2, 50");
		areEqual(false, exercises.makeBricks(40, 2, 52), "Input: 40, 2, 52");
		areEqual(false, exercises.makeBricks(22, 2, 33), "Input: 22, 2, 33");
		areEqual(true, exercises.makeBricks(0, 2, 10), "Input: 0, 2, 10");
		areEqual(true, exercises.makeBricks(1000000, 1000, 1000100), "Input: 1000000, 1000, 1000100");
		areEqual(false, exercises.makeBricks(2, 1000000, 100003), "Input: 2, 1000000, 100003");
		areEqual(true, exercises.makeBricks(20, 0, 19), "Input: 20, 0, 19");
		areEqual(false, exercises.makeBricks(20, 0, 21), "Input: 20, 0, 21");
		areEqual(false, exercises.makeBricks(20, 4, 51), "Input: 20, 4, 51");
		areEqual(true, exercises.makeBricks(20, 4, 39), "Input: 20, 4, 39");
}

    /*
    maxBlock("hoopla") → 2
    maxBlock("abbCCCddBBBxx") → 3
    maxBlock("") → 0
    maxBlock("xyz") → 1
	maxBlock("xxyz") → 2
	maxBlock("xyzz") → 2
	maxBlock("abbbcbbbxbbbx") → 3
	maxBlock("XXBBBbbxx") → 3
	maxBlock("XXBBBBbbxx") → 4
	maxBlock("XXBBBbbxxXXXX") → 4
	maxBlock("XX2222BBBbbXX2222") → 4
    */
    @Test
    public void maxBlock() {
		areEqual(2, exercises.maxBlock("hoopla"), "Input: \"hoopla\"");
		areEqual(3, exercises.maxBlock("abbCCCddBBBxx"), "Input: \"abbCCCddBBBxx\"");
		areEqual(0, exercises.maxBlock(""), "Input: \"\"");
		areEqual(1, exercises.maxBlock("xyz"), "Input: \"xyz\"");
		areEqual(2, exercises.maxBlock("xxyz"), "Input: \"xxyz\"");
		areEqual(2, exercises.maxBlock("xyzz"), "Input: \"xyzz\"");
		areEqual(3, exercises.maxBlock("abbbcbbbxbbbx"), "Input: \"abbbcbbbxbbbx\"");
		areEqual(3, exercises.maxBlock("XXBBBbbxx"), "Input: \"XXBBBbbxx\"");
		areEqual(4, exercises.maxBlock("XXBBBBbbxx"), "Input: \"XXBBBBbbxx\"");
		areEqual(4, exercises.maxBlock("XXBBBbbxxXXXX"), "Input: \"XXBBBbbxxXXXX\"");
		areEqual(4, exercises.maxBlock("XX2222BBBbbXX2222"), "Input: \"XX2222BBBbbXX2222\"");
    }

    /*
    CHALLENGE: Consider the leftmost and righmost appearances of some value in an array.
    We'll say that the "span" is the number of elements between the two inclusive. 
    A single value has a span of 1. 
    Returns the largest span found in the given array. (Efficiency is not a priority.)
    maxSpan([1, 2, 1, 1, 3]) → 4
    maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
    maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
    maxSpan([3, 3, 3]) → 3
	maxSpan([3, 9, 3]) → 3
	maxSpan([3, 9, 9]) → 2
	maxSpan([3, 9]) → 1
	maxSpan([3, 3]) → 2
	maxSpan([]) → 0
	maxSpan([1]) → 1
    */
	@Test
    public void maxSpan() {
		areEqual(4, exercises.maxSpan(new int[] {1, 2, 1, 1, 3}), "Input: {1, 2, 1, 1, 3}");
		areEqual(6, exercises.maxSpan(new int[] {1, 4, 2, 1, 4, 1, 4}), "Input: {1, 4, 2, 1, 4, 1, 4}");
		areEqual(6, exercises.maxSpan(new int[] {1, 4, 2, 1, 4, 4, 4}), "Input: {1, 4, 2, 1, 4, 4, 4}");
		areEqual(3, exercises.maxSpan(new int[] {3, 3, 3}), "Input: {3, 3, 3}");
		areEqual(3, exercises.maxSpan(new int[] {3, 9, 3}), "Input: {3, 9, 3}");
		areEqual(2, exercises.maxSpan(new int[] {3, 9, 9}), "Input: {3, 9, 9}");
		areEqual(1, exercises.maxSpan(new int[] {3, 9}), "Input: {3, 9}");
		areEqual(2, exercises.maxSpan(new int[] {3, 3}), "Input: {3, 3}");
		areEqual(0, exercises.maxSpan(new int[] {}), "Input: {}");
		areEqual(1, exercises.maxSpan(new int[] {1}), "Input: {1}");
	}

    /*
    * mixStart("mix snacks") → true
    * mixStart("pix snacks") → true
    * mixStart("piz snacks") → false
    * mixStart("nix") → true
	* mixStart("ni") → false
	* mixStart("n") → false
	* mixStart("") → false
	*/
	@Test
    public void mixStart() {
		areEqual(true, exercises.mixStart("mix snacks"), "Input: \"mix snacks\"");
		areEqual(true, exercises.mixStart("pix snacks"), "Input: \"pix snacks\"");
		areEqual(false, exercises.mixStart("piz snack"), "Input: \"piz snack\"");
		areEqual(true, exercises.mixStart("nix"), "Input: \"nix\"");
		areEqual(false, exercises.mixStart("ni"), "Input: \"ni\"");
		areEqual(false, exercises.mixStart("n"), "Input: \"n\"");
		areEqual(false, exercises.mixStart(""), "Input: \"\"");
    }

    /*
    more14([1, 4, 1]) → true
    more14([1, 4, 1, 4]) → false
    more14([1, 1]) → true
    more14([1, 6, 6]) → true
	more14([1]) → true
	more14([1, 4]) → false
	more14([6, 1, 1]) → true
	more14([1, 6, 4]) → false
	more14([1, 1, 4, 4, 1]) → true
	more14([1, 1, 6, 4, 4, 1]) → true
	more14([]) → false
	more14([4, 1, 4, 6]) → false
	more14([4, 1, 4, 6, 1]) → false
	more14([1, 4, 1, 4, 1, 6]) → true
    */
	@Test
    public void more14() {
		areEqual(true, exercises.more14(new int[] {1, 4, 1}), "Input: {1, 4, 1}");
		areEqual(false, exercises.more14(new int[] {1, 4, 1, 4}), "Input: {1, 4, 1, 4}");
		areEqual(true, exercises.more14(new int[] {1, 1}), "Input: {1, 1}");
		areEqual(true, exercises.more14(new int[] {1, 6, 6}), "Input: {1, 6, 6}");
		areEqual(true, exercises.more14(new int[] {1}), "Input: {1}");
		areEqual(false, exercises.more14(new int[] {1, 4}), "Input: {1, 4}");
		areEqual(true, exercises.more14(new int[] {6, 1, 1}), "Input: {6, 1, 1}");
		areEqual(false, exercises.more14(new int[] {1, 6, 4}), "Input: {1, 6, 4}");
		areEqual(true, exercises.more14(new int[] {1, 1, 4, 4, 1}), "Input: {1, 1, 4, 4, 1}");
		areEqual(true, exercises.more14(new int[] {1, 1, 6, 4, 4, 1}), "Input: {1, 1, 6, 4, 4, 1}");
		areEqual(false, exercises.more14(new int[] {}), "Input: {}");
		areEqual(false, exercises.more14(new int[] {4, 1, 4, 6}), "Input: {4, 1, 4, 6}");
		areEqual(false, exercises.more14(new int[] {4, 1, 4, 6, 1}), "Input: {4, 1, 4, 6, 1}");
		areEqual(true, exercises.more14(new int[] {1, 4, 1, 4, 1, 6}), "Input: {1, 4, 1, 4, 1, 6}");
    }
	
    /*
    * noTriples([1, 1, 2, 2, 1]) → true
    * noTriples([1, 1, 2, 2, 2, 1]) → false
    * noTriples([1, 1, 1, 2, 2, 2, 1]) → false
    * noTriples([1, 1, 2, 2, 1, 2, 1]) → true
	* noTriples([1, 2, 1]) → true
	* noTriples([1, 1, 1]) → false
	* noTriples([1, 1]) → true
	* noTriples([1]) → true
	* noTriples([]) → true
    */
	@Test
    public void noTriples() {
		areEqual(true, exercises.noTriples(new int[] {1, 1, 2, 2, 1}), "Input: {1, 1, 2, 2, 1}");
		areEqual(false, exercises.noTriples(new int[] {1, 1, 2, 2, 2, 1}), "Input: {1, 1, 2, 2, 2, 1}");
		areEqual(false, exercises.noTriples(new int[] {1, 1, 1, 2, 2, 2, 1}), "Input: {1, 1, 1, 2, 2, 2, 1}");
		areEqual(true, exercises.noTriples(new int[] {1, 1, 2, 2, 1, 2, 1}), "Input: {1, 1, 2, 2, 1, 2, 1}");
		areEqual(true, exercises.noTriples(new int[] {1, 2, 1}), "Input: {1, 2, 1}");
		areEqual(false, exercises.noTriples(new int[] {1, 1, 1}), "Input: {1, 1, 1}");
		areEqual(true, exercises.noTriples(new int[] {1, 1}), "Input: {1, 1}");
		areEqual(true, exercises.noTriples(new int[] {1}), "Input: {1}");
		areEqual(true, exercises.noTriples(new int[] {}), "Input: {}");
    }
	
    /*
    * oneTwo("abc") → "bca"
    * oneTwo("tca") → "cat"
    * oneTwo("tcagdo") → "catdog"
    * oneTwo("chocolate") → "hocolctea"
	* oneTwo("1234567890") → "231564897"
	* oneTwo("xabxabxabxabxabxabxab") → "abxabxabxabxabxabxabx"
	* oneTwo("abcdefx") → "bcaefd"
	* oneTwo("abcdefxy") → "bcaefd"
	* oneTwo("abcdefxyz") → "bcaefdyzx"
	* oneTwo("") → ""
	* oneTwo("x") → ""
	* oneTwo("xy") → ""
	* oneTwo("xyz") → "yzx"
	* oneTwo("abcdefghijklkmnopqrstuvwxyz1234567890") → "bcaefdhigkljmnkpqostrvwuyzx231564897"
	* oneTwo("abcdefghijklkmnopqrstuvwxyz123456789") → "bcaefdhigkljmnkpqostrvwuyzx231564897"
	* oneTwo("abcdefghijklkmnopqrstuvwxyz12345678") → "bcaefdhigkljmnkpqostrvwuyzx231564"
    */
	@Test
    public void oneTwo() {
		areEqual("bca", exercises.oneTwo("abc"), "Input: \"abc\"");
		areEqual("cat", exercises.oneTwo("tca"), "Input: \"tca\"");
		areEqual("catdog", exercises.oneTwo("tcagdo"), "Input: \"tcagdo\"");
		areEqual("hocolctea", exercises.oneTwo("chocolate"), "Input: \"chocolate\"");
		areEqual("231564897", exercises.oneTwo("1234567890"), "Input: \"1234567890\"");
		areEqual("abxabxabxabxabxabxabx", exercises.oneTwo("xabxabxabxabxabxabxab"), "Input: \"xabxabxabxabxabxabxab\"");
		areEqual("bcaefd", exercises.oneTwo("abcdefx"), "Input: \"abcdefx\"");
		areEqual("bcaefd", exercises.oneTwo("abcdefxy"), "Input: \"abcdefxy\"");
		areEqual("bcaefdyzx", exercises.oneTwo("abcdefxyz"), "Input: \"abcdefxyz\"");
		areEqual("", exercises.oneTwo(""), "Input: \"\"");
		areEqual("", exercises.oneTwo("x"), "Input: \"x\"");
		areEqual("", exercises.oneTwo("xy"), "Input: \"xy\"");
		areEqual("yzx", exercises.oneTwo("xyz"), "Input: \"xyz\"");
		areEqual("bcaefdhigkljmnkpqostrvwuyzx231564897", exercises.oneTwo("abcdefghijklkmnopqrstuvwxyz1234567890"), "Input: \"abcdefghijklkmnopqrstuvwxyz1234567890\"");
		areEqual("bcaefdhigkljmnkpqostrvwuyzx231564897", exercises.oneTwo("abcdefghijklkmnopqrstuvwxyz123456789"), "Input: \"abcdefghijklkmnopqrstuvwxyz123456789\"");
		areEqual("bcaefdhigkljmnkpqostrvwuyzx231564", exercises.oneTwo("abcdefghijklkmnopqrstuvwxyz12345678"), "Input: \"abcdefghijklkmnopqrstuvwxyz12345678\"");
	}

	/*
    * repeatSeparator("Word", "X", 3) → "WordXWordXWord"
    * repeatSeparator("This", "And", 2) → "ThisAndThis"
    * repeatSeparator("This", "And", 1) → "This"
    * repeatSeparator("Hi", "-n-", 2) → "Hi-n-Hi"
    * repeatSeparator("AAA", "", 1) → "AAA
    * repeatSeparator("AAA", "", 0) → ""
    * repeatSeparator("A", "B", 5) → "ABABABABA"
    * repeatSeparator("abc", "XX", 3) → "abcXXabcXXabc"
    * repeatSeparator("abc", "XX", 2) → "abcXXabc"
    * repeatSeparator("abc", "XX", 1) → "abc"
    * repeatSeparator("XYZ", "a", 2) → "XYZaXYZ"
    */
	@Test
    public void repeatSeparator() {
		areEqual("WordXWordXWord", exercises.repeatSeparator("Word", "X", 3), "Input: \"Word\", \"X\", 3");
		areEqual("ThisAndThis", exercises.repeatSeparator("This", "And", 2), "Input: \"This\", \"And\", 2");
		areEqual("This", exercises.repeatSeparator("This", "And", 1), "Input: \"This\", \"And\", 1");
		areEqual("Hi-n-Hi", exercises.repeatSeparator("Hi", "-n-", 2), "Input: \"Hi\", \"-n-\", 2");
		areEqual("AAA", exercises.repeatSeparator("AAA", "", 1), "Input: \"AAA\", \"\", 1");
		areEqual("", exercises.repeatSeparator("AAA", "", 0), "Input: \"AAA\", \"\", 0");
		areEqual("ABABABABA", exercises.repeatSeparator("A", "B", 5), "Input: \"A\", \"B\", 5");
		areEqual("abcXXabcXXabc", exercises.repeatSeparator("abc", "XX", 3), "Input: \"abc\", \"XX\", 3");
		areEqual("abcXXabc", exercises.repeatSeparator("abc", "XX", 2), "Input: \"abc\", \"XX\", 2");
		areEqual("abc", exercises.repeatSeparator("abc", "XX", 1), "Input: \"abc\", \"XX\", 1");
		areEqual("XYZaXYZ", exercises.repeatSeparator("XYZ", "a", 2), "Input: \"XYZ\", \"a\", 2");
	}

    /*
    * ("Hello") → true
    * ("Heelle") → true
    * ("Heelle") → false
    * stringE("Hll") → false
	* stringE("e") → true
	* stringE("") → false
    */
	@Test
    public void stringE() {
		areEqual(true, exercises.stringE("Hello"), "Input: \"Hello\"");
		areEqual(true, exercises.stringE("Heelle"), "Input: \"Hello\"");
		areEqual(true, exercises.stringE("Heelle"), "Input: \"Hello\"");
		areEqual(false, exercises.stringE("Hll"), "Input: \"Hll\"");
		areEqual(true, exercises.stringE("e"), "Input: \"e\"");
		areEqual(false, exercises.stringE(""), "Input: \"\"");
    }
    
    /*
    * stringMatch("xxcaazz", "xxbaaz") → 3
    * stringMatch("abc", "abc") → 2
    * stringMatch("abc", "axc") → 0
    * string_match('hello', 'hello') → 1	
    * string_match('he', 'hello') → 1
    * string_match('h', 'hello') → 0
    * string_match('', 'hello') → 0
    * string_match('aabbccdd', 'abbbxxd') → 1
    * string_match('aaxxaaxx', 'iaxxai') → 3
    * string_match('iaxxai', 'aaxxaaxx') → 3	
    */
	@Test
    public void stringMatch() {
		areEqual(3, exercises.stringMatch("xxcaazz", "xxbaaz"), "Input: \"xxcaazz\", \"xxbaaz\"");
		areEqual(2, exercises.stringMatch("abc", "abc"), "Input: \"abc\", \"abc\"");
		areEqual(0, exercises.stringMatch("abc", "axc"), "Input: \"abc\", \"axc\"");
		areEqual(4, exercises.stringMatch("hello", "hello"), "Input: \"hello\", \"hello\"");
		areEqual(1, exercises.stringMatch("he", "hello"), "Input: \"he\", \"hello\"");
		areEqual(0, exercises.stringMatch("h", "hello"), "Input: \"h\", \"hello\"");
		areEqual(0, exercises.stringMatch("", "hello"), "\"\", \"hello\"");
		areEqual(1, exercises.stringMatch("aabbccdd", "abbbxxd"), "Input: \"aabbccdd\", \"abbbxxd\"");
		areEqual(3, exercises.stringMatch("aaxxaaxx", "iaxxai"), "Input: \"aaxxaaxx\", \"iaxxai\"");
		areEqual(3, exercises.stringMatch("iaxxai", "aaxxaaxx"), "Input: \"iaxxai\", \"aaxxaaxx\"");
    }

    /*
    * tripleUp([1, 4, 5, 6, 2]) → true
    * tripleUp([1, 2, 3]) → true
    * tripleUp([1, 2, 4]) → false
	* tripleUp([1, 2, 4, 5, 7, 6, 5, 6, 7, 6]) → true
	* tripleUp([1, 2, 4, 5, 7, 6, 5, 7, 7, 6]) → false
	* tripleUp([1, 2]) → false
	* tripleUp([1]) → false
	* tripleUp([]) → false
	* tripleUp([10, 9, 8, -100, -99, -98, 100]) → true
	* tripleUp([10, 9, 8, -100, -99, 99, 100]) → false
	* tripleUp([-100, -99, -99, 100, 101, 102]) → true
	* tripleUp([2, 3, 5, 6, 8, 9, 2, 3]) → false	false
	*/
	@Test
    public void tripleUp() {
		areEqual(true, exercises.tripleUp(new int[] {1, 4, 5, 6, 2}), "Input: {1, 4, 5, 6, 2}");
		areEqual(true, exercises.tripleUp(new int[] {1, 2, 3}), "Input: {1, 4, 5, 6, 2}");
		areEqual(false, exercises.tripleUp(new int[] {1, 2, 4}), "Input: {1, 4, 5, 6, 2}");
		areEqual(true, exercises.tripleUp(new int[] {1, 2, 4, 5, 7, 6, 5, 6, 7, 6}), "Input: {1, 2, 4, 5, 7, 6, 5, 6, 7, 6}");
		areEqual(false, exercises.tripleUp(new int[] {1, 2, 4, 5, 7, 6, 5, 7, 7, 6}), "Input: {1, 2, 4, 5, 7, 6, 5, 7, 7, 6");
		areEqual(false, exercises.tripleUp(new int[] {1, 2}), "Input: {1, 2}");
		areEqual(false, exercises.tripleUp(new int[] {1}), "Input: {1}");
		areEqual(false, exercises.tripleUp(new int[] {}), "Input: {}");
		areEqual(true, exercises.tripleUp(new int[] {10, 9, 8, -100, -99, -98, 100}), "Input: {10, 9, 8, -100, -99, -98, 100}");
		areEqual(false, exercises.tripleUp(new int[] {10, 9, 8, -100, -99, 99, 100}), "Input: {110, 9, 8, -100, -99, 99, 100}");
		areEqual(true, exercises.tripleUp(new int[] {-100, -99, -99, 100, 101, 102}), "Input: -100, -99, -99, 100, 101, 102");
		areEqual(false, exercises.tripleUp(new int[] {2, 3, 5, 6, 8, 9, 2, 3}), "Input: {2, 3, 5, 6, 8, 9, 2, 3}");
    }

    /*
    * zipZap("zipXzap") → "zpXzp"
    * zipZap("zopzop") → "zpzp"
    * zipZap("zzzopzop") → "zzzpzp"
    * zipZap("zibzap") → "zibzp"
	* zipZap("zip") → "zp"
	* zipZap("zi") → "zi"
	* zipZap("z") → "z"
	* zipZap("") → ""
	* zipZap("zzp") → "zp"
	* zipZap("abcppp") → "abcppp"
	* zipZap("azbcppp") → "azbcppp"
	* zipZap("azbcpzpp") → "azbcpzp"
    */
	@Test
    public void zipZap() {
		areEqual("zpXzp", exercises.zipZap("zipXzap"), "Input: zipXzap");
		areEqual("zpzp", exercises.zipZap("zopzop"), "Input: zopzop");
		areEqual("zzzpzp", exercises.zipZap("zzzopzop"), "Input: zzzopzop");
		areEqual("zibzp", exercises.zipZap("zibzap"), "Input: zibzap");
		areEqual("zp", exercises.zipZap("zip"), "Input: zip");
		areEqual("zi", exercises.zipZap("zi"), "Input: zi");
		areEqual("z", exercises.zipZap("z"), "Input: z");
		areEqual("", exercises.zipZap(""), "Input: ");
		areEqual("zp", exercises.zipZap("zzp"), "Input: zzp");
		areEqual("abcppp", exercises.zipZap("abcppp"), "Input: abcppp");
		areEqual("azbcppp", exercises.zipZap("azbcppp"), "Input: azbcppp");
		areEqual("azbcpzp", exercises.zipZap("azbcpzpp"), "Input: azbcpzpp");
    }

	private void areEqual(String expected, String actual, String message) {
		assertEquals(message, expected, actual);
	}

	private void areEqual(int expected, int actual, String message) {
		assertEquals(message, expected, actual);
	}
	
	private void areEqual(boolean expected, boolean actual, String message) {
		assertEquals(message, expected, actual);
	}
	
	private void areEqual(int[] expected, int[] actual, String message) {
		assertArrayEquals(message, expected, actual);
	}

	/*
	 * Compares two ArrayLists, and returns a null failure message if the lists are equal.
	 * Otherwise, if the lists are not equal, returns a failure message explaining why.
	 * Note, method returns with failure message on the first problem. 
	 * 
	 * Comparisons:
	 * 		Neither String ArrayList may be null.
	 * 		Both String ArrayLists must be the same length, 
	 * 			and the strings must be in the same order.
	 */
	private String compareArrayLists(List<?> expectedList, List<?> actualList) {
		String failureMessage = null;
		if ((expectedList == null) || (actualList == null)) {
			failureMessage = expectedList == null? "expectedList is null " : "";
			failureMessage = actualList == null? "actualList is null" : "";
			return failureMessage.trim();
		}
		if (expectedList.size() != actualList.size()) {
			failureMessage = "array lengths differed, expected.length=" + expectedList.size() + " actual.length=" + actualList.size();
			return failureMessage;
		}
		int i = 0;
		for (Object expectedString : expectedList) {
			if ( ! expectedString.equals(actualList.get(i))) {
				failureMessage = "array elements at index " + i + " differ, expected:<" + expectedString + "> but was:<" + actualList.get(i) + ">";
				return failureMessage;
			}
			i++;
		}
		return failureMessage;
	}

}
