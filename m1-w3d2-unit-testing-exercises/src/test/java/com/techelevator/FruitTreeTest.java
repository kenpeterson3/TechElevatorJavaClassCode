package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FruitTreeTest {
FruitTree sut;
	@Before
	public void setUp() throws Exception {
	sut = new FruitTree("apple", 25);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPickingFewer() {
		
		boolean result = sut.pickFruit(24);
		assertEquals(true, result);
		assertEquals(1, sut.getPiecesOfFruitLeft());
	}
	
	@Test
	public void testPickingEqual() {
			
		boolean result = sut.pickFruit(25);
		assertEquals(true, result);
		assertEquals(0, sut.getPiecesOfFruitLeft());	
	}
	
	@Test
	public void testPickingOne() {
			
		boolean result = sut.pickFruit(1);
		assertEquals(true, result);
		assertEquals(24, sut.getPiecesOfFruitLeft());	
	}
	
	@Test
	public void testPickingMoreThan() {
			
		boolean result = sut.pickFruit(26);
		assertEquals(false, result);
		assertEquals(25, sut.getPiecesOfFruitLeft());	
	}
	
	@Test
	public void testPickinZero() {
			
		boolean result = sut.pickFruit(0);
		assertEquals(true, result);
		assertEquals(25, sut.getPiecesOfFruitLeft());	
	}
	
	@Test
	public void testPickingDoublePickPositive() {
			
		boolean result = sut.pickFruit(20);
		assertEquals(true, result);
		assertEquals(5, sut.getPiecesOfFruitLeft());
		
		boolean result1 = sut.pickFruit(4);
		assertEquals(true, result1);
		assertEquals(1, sut.getPiecesOfFruitLeft());
	}
	
	@Test
	public void testPickingDoublePickNegative() {
			
		boolean result = sut.pickFruit(20);
		assertEquals(true, result);
		assertEquals(5, sut.getPiecesOfFruitLeft());
		
		boolean result1 = sut.pickFruit(6);
		assertEquals(false, result1);
		assertEquals(5, sut.getPiecesOfFruitLeft());
	}		
}


