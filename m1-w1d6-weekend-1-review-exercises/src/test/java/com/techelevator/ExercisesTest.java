package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class ExercisesTest {
	
	Exercises exercises = new Exercises();
	
	/*
    arrayCount9([1, 2, 9]) → 1
    arrayCount9([1, 9, 9]) → 2
    arrayCount9([1, 9, 9, 3, 9]) → 3
    */
   @Test
   public void arrayCount9()
   {
       areEqual(1, exercises.arrayCount9(new int[] { 1, 2, 9 }), "Input {1, 2, 9}");
       areEqual(2, exercises.arrayCount9(new int[] { 1, 9, 9 }), "Input {1, 9, 9}");
       areEqual(3, exercises.arrayCount9(new int[] { 1, 9, 9, 3, 9 }), "Input {1, 9, 9, 3, 9}");
       areEqual(0, exercises.arrayCount9(new int[] { 1, 2, 3 }), "Input {1, 2, 3}");
       areEqual(0, exercises.arrayCount9(new int[] { }), "Input { }");
       areEqual(0, exercises.arrayCount9(new int[] { 4, 2, 4, 3, 1 }), "Input { 4, 2, 4, 3, 1 }");
       areEqual(1, exercises.arrayCount9(new int[] { 9, 2, 4, 3, 1 }), "Input { 9, 2, 4, 3, 1 }");
   }



   /*
    arrayFront9([1, 2, 9, 3, 4]) → true
    arrayFront9([1, 2, 3, 4, 9]) → false
    arrayFront9([1, 2, 3, 4, 5]) → false
    */
   @Test
   public void arrayFront9()
   {
       areEqual(true, exercises.arrayFront9(new int[] { 1, 2, 9, 3, 4 }), "Input: {1, 2, 9, 3, 4} ");
       areEqual(false, exercises.arrayFront9(new int[] { 1, 2, 3, 4, 9 }), "Input: {1, 2, 3, 4, 9} ");
       areEqual(false, exercises.arrayFront9(new int[] { 1, 2, 3, 4, 5 }), "Input: {1, 2, 3, 4, 5} ");
       areEqual(true, exercises.arrayFront9(new int[] { 9, 2, 3 }), "Input: {9, 2, 3} ");
       areEqual(true, exercises.arrayFront9(new int[] { 1, 9, 9 }), "Input: {1, 9, 9} ");
       areEqual(false, exercises.arrayFront9(new int[] { 1, 2, 3 }), "Input: {1, 2, 3} ");
       areEqual(true, exercises.arrayFront9(new int[] { 1, 9 }), "Input: {1, 9} ");
       areEqual(false, exercises.arrayFront9(new int[] { 5, 5 }), "Input: {5, 5 } ");
       areEqual(false, exercises.arrayFront9(new int[] { 2 }), "Input: { 2 } ");
       areEqual(true, exercises.arrayFront9(new int[] { 9 }), "Input: { 9 } ");
       areEqual(false, exercises.arrayFront9(new int[] { }), "Input: { } ");
       areEqual(true, exercises.arrayFront9(new int[] { 3, 9, 2, 3, 3 }), "Input: { 3, 9, 2, 3, 3 } ");

   }

   /*
    array123([1, 1, 2, 3, 1]) → true
    array123([1, 1, 2, 4, 1]) → false
    array123([1, 1, 2, 1, 2, 3]) → true
    */
   @Test
   public void array123()
   {
       assertEquals(true, exercises.array123(new int[] { 1, 1, 2, 3, 1 }));
       assertEquals(false, exercises.array123(new int[] { 1, 1, 2, 4, 1 }));
       assertEquals(true, exercises.array123(new int[] { 1, 1, 2, 1, 2, 3 }));
       assertEquals(false, exercises.array123(new int[] { 1, 1, 2, 1, 2, 1 }));
       assertEquals(true, exercises.array123(new int[] { 1, 2, 3, 1, 2, 3 }));
       assertEquals(true, exercises.array123(new int[] { 1, 2, 3 }));
       assertEquals(false, exercises.array123(new int[] { 1, 1, 1 }));
       assertEquals(false, exercises.array123(new int[] { 1, 2 }));
       assertEquals(false, exercises.array123(new int[] { 1 }));
       assertEquals(false, exercises.array123(new int[] { }));

   }

   /*
    noTriples([1, 1, 2, 2, 1]) → true
    noTriples([1, 1, 2, 2, 2, 1]) → false
    noTriples([1, 1, 1, 2, 2, 2, 1]) → false
    */
   @Test
   public void noTriples()
   {
       assertEquals(true, exercises.noTriples(new int[] { 1, 1, 2, 2, 1 }));
       assertEquals(false, exercises.noTriples(new int[] { 1, 1, 2, 2, 2, 1 }));
       assertEquals(false, exercises.noTriples(new int[] { 1, 1, 1, 2, 2, 2, 1 }));
       assertEquals(true, exercises.noTriples(new int[] { 1, 1, 2, 2, 1, 2, 1 }));
       assertEquals(true, exercises.noTriples(new int[] { 1, 2, 1 }));
       assertEquals(false, exercises.noTriples(new int[] { 1, 1, 1 }));
       assertEquals(true, exercises.noTriples(new int[] { 1, 1 }));
       assertEquals(true, exercises.noTriples(new int[] { 1 }));
       assertEquals(true, exercises.noTriples(new int[] { }));
   }

   /*
    makeEnds([1, 2, 3]) → [1, 3]
    makeEnds([1, 2, 3, 4]) → [1, 4]
    makeEnds([7, 4, 6, 2]) → [7, 2]
    */
   @Test
   public void makeEnds()
   {
       assertArrayEquals(new int[] { 1, 3 }, exercises.makeEnds(new int[] { 1, 2, 3 }));
       assertArrayEquals(new int[] { 1, 4 }, exercises.makeEnds(new int[] { 1, 2, 3, 4 }));
       assertArrayEquals(new int[] { 7, 2 }, exercises.makeEnds(new int[] { 7, 4, 6, 2 }));

       assertArrayEquals(new int[] { 1, 3 }, exercises.makeEnds(new int[] { 1, 2, 2, 2, 2, 2, 2, 3 }));
       assertArrayEquals(new int[] { 7, 4 }, exercises.makeEnds(new int[] { 7, 4 }));
       assertArrayEquals(new int[] { 7, 7 }, exercises.makeEnds(new int[] { 7 }));
       assertArrayEquals(new int[] { 5, 9 }, exercises.makeEnds(new int[] { 5, 2, 9 }));
       assertArrayEquals(new int[] { 2, 1 }, exercises.makeEnds(new int[] { 2, 3, 4, 1 }));

   }

   /*
    has23([2, 5]) → true
    has23([4, 3]) → true
    has23([4, 5]) → false
    */
   @Test
   public void has23()
   {
       assertEquals(true, exercises.has23(new int[] { 2, 5 }));
       assertEquals(true, exercises.has23(new int[] { 4, 3 }));
       assertEquals(false, exercises.has23(new int[] { 4, 5 }));

       assertEquals(true, exercises.has23(new int[] { 2, 2 }));
       assertEquals(true, exercises.has23(new int[] { 3, 2 }));
       assertEquals(true, exercises.has23(new int[] { 3, 3 }));
       assertEquals(false, exercises.has23(new int[] { 7, 7 }));
       assertEquals(true, exercises.has23(new int[] { 3, 9 }));
       assertEquals(false, exercises.has23(new int[] { 9, 5 }));



   }

   /*
    no23([4, 5]) → true
    no23([4, 2]) → false
    no23([3, 5]) → false
    */
   @Test
   public void no23()
   {
       assertEquals(true, exercises.no23(new int[] { 4, 5 }));
       assertEquals(false, exercises.no23(new int[] { 4, 2 }));
       assertEquals(false, exercises.no23(new int[] { 3, 5 }));

       assertEquals(true, exercises.no23(new int[] { 1, 9 }));
       assertEquals(false, exercises.no23(new int[] { 2, 9 }));
       assertEquals(false, exercises.no23(new int[] { 1, 3 }));
       assertEquals(true, exercises.no23(new int[] { 1, 1 }));
       assertEquals(false, exercises.no23(new int[] { 2, 2 }));
       assertEquals(false, exercises.no23(new int[] { 3, 3 }));
       assertEquals(true, exercises.no23(new int[] { 7, 8 }));
       assertEquals(true, exercises.no23(new int[] { 8, 7 }));


   }

   /*
    makeLast([4, 5, 6]) → [0, 0, 0, 0, 0, 6]
    makeLast([1, 2]) → [0, 0, 0, 2]
    makeLast([3]) → [0, 3]
    */
   @Test
   public void makeLast()
   {
       assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 6 }, exercises.makeLast(new int[] { 4, 5, 6 }));
       assertArrayEquals(new int[] { 0, 0, 0, 2 }, exercises.makeLast(new int[] { 1, 2 }));
       assertArrayEquals(new int[] { 0, 3 }, exercises.makeLast(new int[] { 3 }));


       assertArrayEquals(new int[] { 0, 0 }, exercises.makeLast(new int[] { 0 }));
       assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 7 }, exercises.makeLast(new int[] { 7, 7, 7 }));
       assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 4 }, exercises.makeLast(new int[] { 3, 1, 4 }));
       assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0, 4 }, exercises.makeLast(new int[] { 1, 2, 3, 4 }));
       assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0, 0 }, exercises.makeLast(new int[] { 1, 2, 3, 0 }));
       assertArrayEquals(new int[] { 0, 0, 0, 4 }, exercises.makeLast(new int[] { 2, 4 }));

   }

   /*
    double23([2, 2]) → true
    double23([3, 3]) → true
    double23([2, 3]) → false
    */
   @Test
   public void double23()
   {
       assertEquals(true, exercises.double23(new int[] { 2, 2 }));
       assertEquals(true, exercises.double23(new int[] { 3, 3 }));
       assertEquals(false, exercises.double23(new int[] { 2, 3 }));

       assertEquals(false, exercises.double23(new int[] { 3, 2 }));
       assertEquals(false, exercises.double23(new int[] { 4, 5 }));
       assertEquals(false, exercises.double23(new int[] { 2 }));
       assertEquals(false, exercises.double23(new int[] { 3 }));
       assertEquals(false, exercises.double23(new int[] { }));
       assertEquals(false, exercises.double23(new int[] { 3, 4 }));


   }

   /*
    fix23([1, 2, 3]) → [1, 2, 0]
    fix23([2, 3, 5]) → [2, 0, 5]
    fix23([1, 2, 1]) → [1, 2, 1]
    */
   @Test
   public void fix23()
   {
       assertArrayEquals(new int[] { 1, 2, 0 }, exercises.fix23(new int[] { 1, 2, 3 }));
       assertArrayEquals(new int[] { 2, 0, 5 }, exercises.fix23(new int[] { 2, 3, 5 }));
       assertArrayEquals(new int[] { 1, 2, 1 }, exercises.fix23(new int[] { 1, 2, 1 }));

       assertArrayEquals(new int[] { 3, 2, 1 }, exercises.fix23(new int[] { 3, 2, 1 }));
       assertArrayEquals(new int[] { 2, 2, 0 }, exercises.fix23(new int[] { 2, 2, 3 }));
       assertArrayEquals(new int[] { 2, 0, 3 }, exercises.fix23(new int[] { 2, 3, 3 }));

   }

   /*
    start1([1, 2, 3], [1, 3]) → 2
    start1([7, 2, 3], [1]) → 1
    start1([1, 2], []) → 1
    */
   @Test
   public void start1()
   {
       assertEquals(2, exercises.start1(new int[] { 1, 2, 3 }, new int[] { 1, 3 }));
       assertEquals(1, exercises.start1(new int[] { 7, 2, 3 }, new int[] { 1 }));
       assertEquals(1, exercises.start1(new int[] { 1, 2 }, new int[] { }));

       assertEquals(1, exercises.start1(new int[] { }, new int[] { 1, 2 }));
       assertEquals(0, exercises.start1(new int[] { 7 }, new int[] { }));
       assertEquals(1, exercises.start1(new int[] { 7 }, new int[] { 1 }));
       assertEquals(2, exercises.start1(new int[] { 1 }, new int[] { 1 }));
       assertEquals(0, exercises.start1(new int[] { 7 }, new int[] { 8 }));
       assertEquals(0, exercises.start1(new int[] { }, new int[] { }));
       assertEquals(2, exercises.start1(new int[] { 1, 3 }, new int[] { 1 }));
   }

   /*
    biggerTwo([1, 2], [3, 4]) → [3, 4]
    biggerTwo([3, 4], [1, 2]) → [3, 4]
    biggerTwo([1, 1], [1, 2]) → [1, 2]
    */
   @Test
   public void biggerTwo()
   {
       assertArrayEquals(new int[] { 3, 4 }, exercises.biggerTwo(new int[] { 1, 2 }, new int[] { 3, 4 }));
       assertArrayEquals(new int[] { 3, 4 }, exercises.biggerTwo(new int[] { 3, 4 }, new int[] { 1, 2 }));
       assertArrayEquals(new int[] { 1, 2 }, exercises.biggerTwo(new int[] { 1, 1 }, new int[] { 1, 2 }));

       assertArrayEquals(new int[] { 2, 1 }, exercises.biggerTwo(new int[] { 2, 1 }, new int[] { 1, 1 }));
       assertArrayEquals(new int[] { 2, 2 }, exercises.biggerTwo(new int[] { 2, 2 }, new int[] { 1, 3 }));
       assertArrayEquals(new int[] { 1, 3 }, exercises.biggerTwo(new int[] { 1, 3 }, new int[] { 2, 2 }));
       assertArrayEquals(new int[] { 6, 7 }, exercises.biggerTwo(new int[] { 6, 7 }, new int[] { 3, 1 }));

   }

   /*
    makeMiddle([1, 2, 3, 4]) → [2, 3]
    makeMiddle([7, 1, 2, 3, 4, 9]) → [2, 3]
    makeMiddle([1, 2]) → [1, 2]
    */
   @Test
   public void makeMiddle()
   {
       assertArrayEquals(new int[] { 2, 3 }, exercises.makeMiddle(new int[] { 1, 2, 3, 4 }));
       assertArrayEquals(new int[] { 2, 3 }, exercises.makeMiddle(new int[] { 7, 1, 2, 3, 4, 9 }));
       assertArrayEquals(new int[] { 1, 2 }, exercises.makeMiddle(new int[] { 1, 2 }));

       assertArrayEquals(new int[] { 2, 4 }, exercises.makeMiddle(new int[] { 5, 2, 4, 7 }));
       assertArrayEquals(new int[] { 4, 3 }, exercises.makeMiddle(new int[] { 9, 0, 4, 3, 9, 1 }));

   }

   /*
    plusTwo([1, 2], [3, 4]) → [1, 2, 3, 4]
    plusTwo([4, 4], [2, 2]) → [4, 4, 2, 2]
    plusTwo([9, 2], [3, 4]) → [9, 2, 3, 4]
    */
   @Test
   public void plusTwo()
   {
       assertArrayEquals(new int[] { 1, 2, 3, 4 }, exercises.plusTwo(new int[] { 1, 2 }, new int[] { 3, 4 }));
       assertArrayEquals(new int[] { 4, 4, 2, 2 }, exercises.plusTwo(new int[] { 4, 4 }, new int[] { 2, 2 }));
       assertArrayEquals(new int[] { 9, 2, 3, 4 }, exercises.plusTwo(new int[] { 9, 2 }, new int[] { 3, 4 }));
   }

   /*
    swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
    swapEnds([1, 2, 3]) → [3, 2, 1]
    swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
    */
   @Test
   public void swapEnds()
   {
       assertArrayEquals(new int[] { 4, 2, 3, 1 }, exercises.swapEnds(new int[] { 1, 2, 3, 4 }));
       assertArrayEquals(new int[] { 3, 2, 1 }, exercises.swapEnds(new int[] { 1, 2, 3 }));
       assertArrayEquals(new int[] { 5, 6, 7, 9, 8 }, exercises.swapEnds(new int[] { 8, 6, 7, 9, 5 }));

       assertArrayEquals(new int[] { 9, 1, 4, 1, 5, 3 }, exercises.swapEnds(new int[] { 3, 1, 4, 1, 5, 9 }));
       assertArrayEquals(new int[] { 1, 2 }, exercises.swapEnds(new int[] { 2, 1 }));
       assertArrayEquals(new int[] { 1 }, exercises.swapEnds(new int[] { 1 }));

   }

   /*
    more14([1, 4, 1]) → true
    more14([1, 4, 1, 4]) → false
    more14([1, 1]) → true
    */
   @Test
   public void more14()
   {
       assertEquals(true, exercises.more14(new int[] { 1, 4, 1 }));
       assertEquals(false, exercises.more14(new int[] { 1, 4, 1, 4 }));
       assertEquals(true, exercises.more14(new int[] { 1, 1 }));

       assertEquals(true, exercises.more14(new int[] { 1, 6, 6 }));
       assertEquals(true, exercises.more14(new int[] { 1 }));
       assertEquals(false, exercises.more14(new int[] { 1, 4 }));
       assertEquals(true, exercises.more14(new int[] { 6, 1, 1 }));
       assertEquals(false, exercises.more14(new int[] { 1, 6, 4 }));
       assertEquals(true, exercises.more14(new int[] { 1, 1, 4, 4, 1 }));
       assertEquals(true, exercises.more14(new int[] { 1, 1, 6, 4, 4, 1 }));
       assertEquals(false, exercises.more14(new int[] { }));
       assertEquals(false, exercises.more14(new int[] { 4, 1, 4, 6 }));
       assertEquals(false, exercises.more14(new int[] { 4, 1, 4, 6, 1 }));
       assertEquals(true, exercises.more14(new int[] { 1, 4, 1, 4, 1, 6 }));



   }

   /*
    fizzArray(4) → [0, 1, 2, 3]
    fizzArray(1) → [0]
    fizzArray(10) → [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    */
   @Test
   public void fizzArray()
   {
       assertArrayEquals(new int[] { 0, 1, 2, 3 }, exercises.fizzArray(4));
       assertArrayEquals(new int[] { 0 }, exercises.fizzArray(1));
       assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, exercises.fizzArray(10));

       assertArrayEquals(new int[] { }, exercises.fizzArray(0));
       assertArrayEquals(new int[] { 0, 1 }, exercises.fizzArray(2));
       assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6 }, exercises.fizzArray(7));

   }

   /*
    only14([1, 4, 1, 4]) → true
    only14([1, 4, 2, 4]) → false
    only14([1, 1]) → true
    */
   @Test
   public void only14()
   {
       assertEquals(true, exercises.only14(new int[] { 1, 4, 1, 4 }));
       assertEquals(false, exercises.only14(new int[] { 1, 4, 2, 4 }));
       assertEquals(true, exercises.only14(new int[] { 1, 1 }));

       assertEquals(true, exercises.only14(new int[] { 4, 1 }));
       assertEquals(false, exercises.only14(new int[] { 2 }));
       assertEquals(true, exercises.only14(new int[] { }));
       assertEquals(false, exercises.only14(new int[] { 1, 4, 1, 3 }));
       assertEquals(false, exercises.only14(new int[] { 3, 1, 3 }));
       assertEquals(true, exercises.only14(new int[] { 1 }));
       assertEquals(true, exercises.only14(new int[] { 4 }));
       assertEquals(false, exercises.only14(new int[] { 3, 4 }));
       assertEquals(false, exercises.only14(new int[] { 1, 3, 4 }));
       assertEquals(true, exercises.only14(new int[] { 1, 1, 1 }));
       assertEquals(false, exercises.only14(new int[] { 1, 1, 1, 5 }));
       assertEquals(true, exercises.only14(new int[] { 4, 1, 4, 1 }));

   }
	
	/*
	 no14([1, 2, 3]) → true
	 no14([1, 2, 3, 4]) → false
	 no14([2, 3, 4]) → true
	 */
	@Test
	public void no14() {
		areEqual(true, exercises.no14(new int[]{1, 2, 3}), "no14(new int[]{1, 2, 3})");
		areEqual(false, exercises.no14(new int[]{1, 2, 3, 4}), "no14(new int[]{1, 2, 3, 4})");
		areEqual(true, exercises.no14(new int[]{2, 3, 4}), "no14(new int[]{2, 3, 4})");
	}

	/*
	 has12([1, 3, 2]) → true
	 has12([3, 1, 2]) → true
	 has12([3, 1, 4, 5, 2]) → true
	 */
	@Test
	public void has12() {
		areEqual(true, exercises.has12(new int[]{1, 3, 2}), "has12(new int[]{1, 3, 2})");
		areEqual(true, exercises.has12(new int[]{3, 1, 2}), "has12(new int[]{3, 1, 2})");
		areEqual(true, exercises.has12(new int[]{3, 1, 4, 5, 2}), "has12(new int[]{3, 1, 4, 5, 2})");
		areEqual(false, exercises.has12(new int[]{3, 2, 1}), "has12(new int[]{3, 2, 1})");
		areEqual(false, exercises.has12(new int[]{3, 1, 4}), "has12(new int[]{3, 1, 4})");
		areEqual(false, exercises.has12(new int[]{3, 5, 2}), "has12(new int[]{3, 5, 2})");
		areEqual(false, exercises.has12(new int[]{5, 5, 5}), "has12(new int[]{5, 5, 5})");
		areEqual(true, exercises.has12(new int[]{2, 1, 2}), "has12(new int[]{2, 1, 2})");
	}

	/*
	 fizzArray3(5, 10) → [5, 6, 7, 8, 9]
	 fizzArray3(11, 18) → [11, 12, 13, 14, 15, 16, 17]
	 fizzArray3(1, 3) → [1, 2]
	 */
	@Test
	public void fizzArray3() {
		
		areEqual(new int[]{5, 6, 7, 8, 9}, exercises.fizzArray3(5, 10), "fizzArray3(5, 10)");
		areEqual(new int[]{11, 12, 13, 14, 15, 16, 17}, exercises.fizzArray3(11, 18), "fizzArray3(11, 18)");
		areEqual(new int[]{1, 2}, exercises.fizzArray3(1, 3), "fizzArray3(1, 3)");
		areEqual(new int[]{ }, exercises.fizzArray3(3, 3), "fizzArray3(3, 3)");
		
	}

	/*
	 lessBy10(1, 7, 11) → true
	 lessBy10(1, 7, 10) → false
	 lessBy10(11, 1, 7) → true
	 */
	@Test
	public void lessBy10() {
		areEqual(true, exercises.lessBy10(1, 7, 11), "lessBy10(1, 7, 11)");
		areEqual(false, exercises.lessBy10(1, 7, 10), "lessBy10(1, 7, 10)");
		areEqual(true, exercises.lessBy10(11, 1, 7), "lessBy10(11, 1, 7)");
		areEqual(true, exercises.lessBy10(1, 11, 7), "lessBy10(1, 11, 7)");
		areEqual(true, exercises.lessBy10(7, 1, 11), "lessBy10(7, 1, 11)");
		areEqual(true, exercises.lessBy10(15, 2, 30), "lessBy10(15, 2, 30)");
	}

	/*
	 greenTicket(1, 2, 3) → 0
	 greenTicket(2, 2, 2) → 20
	 greenTicket(1, 1, 2) → 10
	 */
	@Test
	public void greenTicket() {
		areEqual(0, exercises.greenTicket(1, 2, 3), "greenTicket(1, 2, 3)");
		areEqual(20, exercises.greenTicket(2, 2, 2), "greenTicket(2, 2, 2)");
		areEqual(10, exercises.greenTicket(1, 1, 2), "greenTicket(1, 1, 2)");
		areEqual(10, exercises.greenTicket(2, 1, 1), "greenTicket(2, 1, 1)");
		areEqual(10, exercises.greenTicket(1, 2, 1), "greenTicket(1, 2, 1)");
	}
	
	/*
	 blackjack(19, 21) → 21
	 blackjack(21, 19) → 21
	 blackjack(19, 22) → 19
	 */
	@Test
	public void blackjack() {
		areEqual(21, exercises.blackjack(19, 21), "blackjack(19, 21)");
		areEqual(21, exercises.blackjack(21, 19), "blackjack(21, 19)");
		areEqual(19, exercises.blackjack(19, 22), "blackjack(19, 22)");
		areEqual(19, exercises.blackjack(22, 19), "blackjack(22, 19)");
		areEqual(0, exercises.blackjack(23, 22), "blackjack(23, 22)");
		areEqual(0, exercises.blackjack(23, 22), "blackjack(10, 12)");
		areEqual(21, exercises.blackjack(21, 21), "blackjack(21, 21)");
		areEqual(17, exercises.blackjack(17, 17), "blackjack(17, 17)");
	}

	/*
	 evenlySpaced(2, 4, 6) → true
	 evenlySpaced(4, 6, 2) → true
	 evenlySpaced(4, 6, 3) → false
	 */
	@Test
	public void evenlySpaced() {
		areEqual(true, exercises.evenlySpaced(2, 4, 6), "evenlySpaced(2, 4, 6)");
		areEqual(true, exercises.evenlySpaced(4, 6, 2), "evenlySpaced(4, 6, 2)");
		areEqual(false, exercises.evenlySpaced(4, 6, 3), "evenlySpaced(4, 6, 3)");
		areEqual(true, exercises.evenlySpaced(6, 2, 4), "evenlySpaced(6, 2, 4)");
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
}
