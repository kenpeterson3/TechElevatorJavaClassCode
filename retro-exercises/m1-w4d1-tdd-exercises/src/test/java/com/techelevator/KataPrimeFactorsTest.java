package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;

public class KataPrimeFactorsTest {
	KataPrimeFactors sut;
	
	@Before
	public void setUp() {
		sut = new KataPrimeFactors();
	}
	
	@Test
	public void testTwo() {
		int[] result = sut.primeFinder(2);
		assertArrayEquals(new int[] {2}, result);
	}
	
	@Test
	public void testSix() {
		int[] result = sut.primeFinder(6);
		Arrays.sort(result);
		assertArrayEquals(new int[] {2, 3}, result);
	}
	
	@Test
	public void testNinetySix() {
		int[] result = sut.primeFinder(96);
		Arrays.sort(result);
		assertArrayEquals(new int[] {2, 2, 2, 2, 2, 3}, result);
	}
	
	@Test
	public void testLargeNumber() {
		int[] result = sut.primeFinder(1475143);
		Arrays.sort(result);
		assertArrayEquals(new int[] {29, 50867}, result);
	}
}
