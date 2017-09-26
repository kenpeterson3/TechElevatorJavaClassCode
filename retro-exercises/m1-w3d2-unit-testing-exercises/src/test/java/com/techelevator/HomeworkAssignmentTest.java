package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HomeworkAssignmentTest {

	HomeworkAssignment sut;
	
	@Before
	public void setUp() throws Exception {
		// Arrange for every test
		sut = new HomeworkAssignment(100);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLetterGradeAHigh() {
		// Arrange
		sut.setTotalMarks(100);
		
		// Act
		String grade = sut.getLetterGrade();
		
		// Assert
		assertEquals("A", grade);
	}
	
	@Test
	public void testLetterGradeALow() {
		// Arrange
		sut.setTotalMarks(90);
		
		// Act
		String grade = sut.getLetterGrade();
		
		// Assert
		assertEquals("A", grade);
	}
}
