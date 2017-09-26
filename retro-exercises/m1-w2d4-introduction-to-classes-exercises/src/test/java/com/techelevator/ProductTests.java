package com.techelevator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.product.Product;

public class ProductTests {
	
	private Class<Product> klass = null;
	private Constructor<Product> constructor = null;
	private Method getName = null;
	private Method setName = null;
	private Method getPrice = null;
	private Method setPrice = null;
	private Method getWeightInOunces = null;
	private Method setWeightInOunces = null;
	
	@Before
    public void productRequiredMembers() {
        klass = Product.class;

        constructor = SafeReflection.getConstructor(klass);
    	assertTrue("You do not have the required default Product() constructor", constructor != null);
        		
    	getName = SafeReflection.getMethod(klass, "getName");
        assertTrue("Product class needs the getName() method. Check the method's spelling, parameter type(s), and access modifier.",  getName != null);
        assertTrue("getName() method needs to return type: String", getName.getReturnType() == String.class);
        
        setName = SafeReflection.getMethod(klass, "setName", String.class);
        assertTrue("Product class needs the setName(String) method. Check the method's spelling, parameter type(s), and access modifier.",  setName != null);
        assertTrue("setName(String) method needs to return type: void", setName.getReturnType() == void.class);
		
        getPrice = SafeReflection.getMethod(klass, "getPrice");
	    assertTrue("Product class needs the getPrice() method. Check the method's spelling, parameter type(s), and access modifier.",  getPrice != null);
	    assertTrue("getPrice() method needs to return type: double", getPrice.getReturnType() == Double.TYPE);
	    
	    setPrice = SafeReflection.getMethod(klass, "setPrice", Double.TYPE);
	    assertTrue("Product class needs the setPrice(double) method. Check the method's spelling, parameter type(s), and access modifier.",  setPrice != null);
	    assertTrue("setPrice(double) method needs to return type: void", setPrice.getReturnType() == void.class);
		
	    getWeightInOunces = SafeReflection.getMethod(klass, "getWeightInOunces");
	    assertTrue("Product class needs the getWeightInOunces() method. Check the method's spelling, parameter type(s), and access modifier.",  getWeightInOunces != null);
	    assertTrue("getWeightInOunces() method needs to return type: double", getWeightInOunces.getReturnType() == Double.TYPE);
	    
	    setWeightInOunces = SafeReflection.getMethod(klass, "setWeightInOunces", Double.TYPE);
	    assertTrue("Product class needs the setWeightInOunces(double) method. Check the method's spelling, parameter type(s), and access modifier.",  setWeightInOunces != null);
	    assertTrue("setWeightInOunces(double) method needs to return type: void", setWeightInOunces.getReturnType() == void.class);
	}
	
	@Test
	public void productGettersSettersTest() {
    	try {
			Product product = constructor.newInstance();
			setName.invoke(product, new Object[] { "THE Product" });
	        assertTrue("getName should return \"THE Product\"", "THE Product".equals((String)getName.invoke(product)));
	        setPrice.invoke(product, new Object[] { 1.23d });
	        assertTrue("getPrice should return 1.23", 1.23 == (double)getPrice.invoke(product));
	        setWeightInOunces.invoke(product, new Object[] { 32.1d });
	        assertTrue("getWeightInOunces should return 3.21", 32.1d == (double)getWeightInOunces.invoke(product));
		} catch (Exception e) {
			fail("Faild to instantiate Product");
		}
	}

}
