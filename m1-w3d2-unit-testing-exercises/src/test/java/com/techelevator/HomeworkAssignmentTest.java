package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HomeworkAssignmentTest {
	HomeworkAssignment sut;
	@Before
	public void setUp() throws Exception {
		//arrange
	sut = new HomeworkAssignment(100);
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLetterGradeAHigh() {
		//arrange
		sut.setTotalMarks(100);
		//act
		String grade = sut.getLetterGrade();
		//assert
		assertEquals("A", grade );		
	}
	@Test
	public void testLetterGradeALow() {
		//arrange
		sut.setTotalMarks(90);
		//act
		String grade = sut.getLetterGrade();
		//assert
		assertEquals("A", grade );	
	}
	@Test
	public void testLetterGradeBHigh() {
		//arrange
		sut.setTotalMarks(89);
		//act
		String grade = sut.getLetterGrade();
		//assert
		assertEquals("B", grade );		
	}
	@Test
	public void testLetterGradeBLow() {
		//arrange
		sut.setTotalMarks(80);
		//act
		String grade = sut.getLetterGrade();
		//assert
		assertEquals("B", grade );		
	}
	@Test
	public void testLetterGradeCHigh() {
		//arrange
		sut.setTotalMarks(79);
		//act
		String grade = sut.getLetterGrade();
		//assert
		assertEquals("C", grade );		
	}
	@Test
	public void testLetterGradeCLow() {
		//arrange
		sut.setTotalMarks(70);
		//act
		String grade = sut.getLetterGrade();
		//assert
		assertEquals("C", grade );		
	}
	@Test
	public void testLetterGradeDHigh() {
		//arrange
		sut.setTotalMarks(69);
		//act
		String grade = sut.getLetterGrade();
		//assert
		assertEquals("D", grade );		
	}
	@Test
	public void testLetterGradeDLow() {
		//arrange
		sut.setTotalMarks(60);
		//act
		String grade = sut.getLetterGrade();
		//assert
		assertEquals("D", grade );		
	}
	@Test
	public void testLetterGradeFHigh() {
		//arrange
		sut.setTotalMarks(59);
		//act
		String grade = sut.getLetterGrade();
		//assert
		assertEquals("F", grade );		
	}
	@Test
	public void testLetterGradeFLow() {
		//arrange
		sut.setTotalMarks(0);
		//act
		String grade = sut.getLetterGrade();
		//assert
		assertEquals("F", grade );		
	}
}
