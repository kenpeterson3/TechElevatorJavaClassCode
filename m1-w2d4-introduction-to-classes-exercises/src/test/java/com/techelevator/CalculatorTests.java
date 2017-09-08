package com.techelevator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.calculator.Calculator;

public class CalculatorTests {
	
	private Class<Calculator> klass = null;
	private Constructor<Calculator> constructor = null;
	private Method getCurrentValue = null;
	private Method add = null;
	private Method substract = null;
	private Method multiply = null;
	private Method power = null;
	private Method reset = null;
	
	@Before
	public void calculatorRequiredMembers() {
		if (klass == null) {
	        klass = Calculator.class;

	        constructor = SafeReflection.getConstructor(klass);
	    	assertTrue("You do not have the required default Calculator() constructor", constructor != null);
	        		
	        getCurrentValue = SafeReflection.getMethod(klass, "getCurrentValue");
	        assertTrue("Calculator class needs the getCurrentValue() method. Check the method's spelling, parameter type(s), and access modifier.",  getCurrentValue != null);
	        assertTrue("getCurrentValue() method needs to return type: int", getCurrentValue.getReturnType() == Integer.TYPE);
	        
	        add = SafeReflection.getMethod(klass, "add", Integer.TYPE);
	        assertTrue("Calculator class needs the add(int) method. Check the method's spelling, parameter type(s), and access modifier.",  add != null);
	        assertTrue("add(int) method needs to return type: int", add.getReturnType() == Integer.TYPE);
	        
	        substract = SafeReflection.getMethod(klass, "subtract", Integer.TYPE);
	        assertTrue("Calculator class needs the subtract(int) method. Check the method's spelling, parameter type(s), and access modifier.",  substract != null);
	        assertTrue("subtract(int) method needs to return type: int", substract.getReturnType() == Integer.TYPE);

	        multiply = SafeReflection.getMethod(klass, "multiply", Integer.TYPE);
	        assertTrue("Calculator class needs the multiple(int) method. Check the method's spelling, parameter type(s), and access modifier.",  multiply != null);
	        assertTrue("multiply(int) method needs to return type: int", multiply.getReturnType() == Integer.TYPE);

	        power = SafeReflection.getMethod(klass, "power", Integer.TYPE);
	        assertTrue("Calculator class needs the power(int) method. Check the method's spelling, parameter type(s), and access modifier.",  power != null);
	        assertTrue("power(int) method needs to return type: int", power.getReturnType() == Integer.TYPE);

	        reset = SafeReflection.getMethod(klass, "reset");
	        assertTrue("Calculator class needs the reset() method. Check the method's spelling, parameter type(s), and access modifier.",  reset != null);
	        assertTrue("reset() method needs to return type: void", reset.getReturnType() == void.class);
		}
        
    }

	@Test
	public void calculatorConstructorTest() {
    	try {
			Calculator calculator = constructor.newInstance();
			assertTrue("New Calculator should default to currentResult == 0", 0 == (int)getCurrentValue.invoke(calculator));
		} catch (Exception e) {
			fail("Faild to instantiate Calculator");
		}
    }

    @Test
    public void calculatorResetTest() {
    	try {
			Calculator calculator = constructor.newInstance();
	        assertTrue("add(5) should return 5", 5 == (int)add.invoke(calculator, new Object[] { 5 }));
	        assertTrue("The currentValuet sould be 5", 5 == (int)getCurrentValue.invoke(calculator));
	        reset.invoke(calculator);
	        assertTrue("reset() should set currentValuet to 0", 0 == (int)getCurrentValue.invoke(calculator));
		} catch (Exception e) {
			fail("Faild to instantiate Calculator");
		}
    }

    @Test
    public void calculatorAddTest() {
    	try {
			Calculator calculator = constructor.newInstance();
	        assertTrue("add(5) should return 5", 5 == (int)add.invoke(calculator, new Object[] { 5 }));
	        assertTrue("The currentValuet sould be 5", 5 == (int)getCurrentValue.invoke(calculator));
		} catch (Exception e) {
			fail("Faild to instantiate Calculator");
		}
    }

    @Test
    public void calculatorMultiplyTest()
    {
    	try {
			Calculator calculator = constructor.newInstance();
	        assertTrue("add(5) should return 5", 5 == (int)add.invoke(calculator, new Object[] { 5 }));
	        assertTrue("multiple(2) should return 10", 10 == (int)multiply.invoke(calculator, new Object[] { 2 }));
	        assertTrue("The currentValuet sould be 10", 10 == (int)getCurrentValue.invoke(calculator));
		} catch (Exception e) {
			fail("Faild to instantiate Calculator");
		}
    }

    @Test
    public void calculatorSubtractTest()
    {
    	try {
			Calculator calculator = constructor.newInstance();
	        assertTrue("subtract(5) should return -5", -5 == (int)substract.invoke(calculator, new Object[] { 5 }));
	        assertTrue("The currentValuet sould be -5", -5 == (int)getCurrentValue.invoke(calculator));
		} catch (Exception e) {
			fail("Faild to instantiate Calculator");
		}
    }

    @Test
    public void calculatorPowerTest()
    {
    	try {
			Calculator calculator = constructor.newInstance();
	        assertTrue("add(5) should return 5", 5 == (int)add.invoke(calculator, new Object[] { 5 }));
	        assertTrue("The currentValuet sould be 5", 5 == (int)getCurrentValue.invoke(calculator));
	        assertTrue("power(2) should return 25", 25 == (int)power.invoke(calculator, new Object[] { 2 }));
	        assertTrue("reset() should set currentValuet to 25", 25 == (int)getCurrentValue.invoke(calculator));
		} catch (Exception e) {
			fail("Faild to instantiate Calculator");
		}
    }

}
