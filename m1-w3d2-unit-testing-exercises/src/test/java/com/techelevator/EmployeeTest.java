package com.techelevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
Employee sut;
	@Before
	public void setUp() throws Exception {
		sut = new Employee(1, "Luke", "Skywalker", 500.00);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		
		assertEquals(1,sut.getEmployeeId());
		assertEquals("Luke", sut.getFirstName());
		assertEquals("Skywalker", sut.getLastName());
		assertEquals(500.00,sut.getAnnualSalary(), 0.001);//delta 0D
	}	
	@Test
	public void testAnnualSalaryLow() {
		sut.raiseSalary(1);
		
		double raise = sut.getAnnualSalary();
		
		assertEquals(505, raise, 0.001);
		
	}
	@Test
	public void testAnnualSalaryNegative() {
		sut.raiseSalary(-1);
		
		double raise = sut.getAnnualSalary();
		
		assertEquals(500, raise, 0.001);
		
	}
	
	@Test
	public void testAnnualSalaryLarge() {
		sut.raiseSalary(50);
		
		double raise = sut.getAnnualSalary();
		
		assertEquals(750, raise, 0.001);
		
	}
	@Test
	public void testAnnualSalaryDecimal() {
		sut.raiseSalary(10.50);
		
		double raise = sut.getAnnualSalary();
		
		assertEquals(552.50, raise, 0.001);
		
	}
	@Test
	public void testAnnualSalaryZero() {
		sut.raiseSalary(0);
		
		double raise = sut.getAnnualSalary();
		
		assertEquals(500, raise, 0.001);
		
	}


}
