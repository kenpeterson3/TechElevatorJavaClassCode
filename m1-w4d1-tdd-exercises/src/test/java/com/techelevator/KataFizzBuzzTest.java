package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {
	
	KataFizzBuzz sut;
	
	@Before
	public void setup() {
		
		sut  = new KataFizzBuzz();
		
	}
	
	@Test
	public void testZero() {
		
		assertEquals("",sut.FizzBuzzResult(0));
		
	}
	
	@Test
	public void testOneOOne() {
		
		assertEquals("",sut.FizzBuzzResult(101));
		
	}

	@Test
	public void testThree() {
		
		assertEquals("Fizz",sut.FizzBuzzResult(3));
		
	}

	@Test
	public void testThreeMultipleOfTwelve() {
		
		assertEquals("Fizz",sut.FizzBuzzResult(12));
		
	}

	@Test
	public void testThreeMultipleOfNinetyNine() {
		
		assertEquals("Fizz",sut.FizzBuzzResult(99));
		
	}

	@Test
	public void testFive() {
		
		assertEquals("Buzz",sut.FizzBuzzResult(5));
		
	}

	@Test
	public void testFiveMultipleOfTwentyFive() {
		
		assertEquals("Buzz",sut.FizzBuzzResult(25));
		
	}
	
	@Test
	public void testFiveMultipleOfSeventy() {
		
		assertEquals("Buzz",sut.FizzBuzzResult(70));
		
	}
	
	@Test
	public void testFifteen() {
		
		assertEquals("FizzBuzz",sut.FizzBuzzResult(15));
		
	}
	
	@Test
	public void testThirty() {
		
		assertEquals("FizzBuzz",sut.FizzBuzzResult(30));
		
	}

	@Test
	public void testNonMulitpleThree() {
		
		assertEquals("Fizz",sut.FizzBuzzResult(43));
		
	}

	@Test
	public void testNonMulitpleFive() {
		
		assertEquals("Buzz",sut.FizzBuzzResult(52));
		
	}

	@Test
	public void testNonMulitpleThreeAndFive() {
		
		assertEquals("FizzBuzz",sut.FizzBuzzResult(53));
		
	}
	
	
}
