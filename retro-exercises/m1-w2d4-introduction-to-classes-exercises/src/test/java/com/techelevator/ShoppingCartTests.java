package com.techelevator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.shoppingcart.ShoppingCart;

public class ShoppingCartTests {
	
	private Class<ShoppingCart> klass = null;
	private Constructor<ShoppingCart> constructor = null;
	private Method getTotalNumberOfItems = null;
	private Method getTotalAmountOwed = null;
	private Method addItems = null;
	private Method getAveragePricePerItem = null;
	private Method empty = null;
	
	@Before
    public void shoppingCartRequiredMembers() {
        klass = ShoppingCart.class;

        constructor = SafeReflection.getConstructor(klass);
    	assertTrue("You do not have the required default ShoppingCart() constructor", constructor != null);
        		
    	getTotalNumberOfItems = SafeReflection.getMethod(klass, "getTotalNumberOfItems");
        assertTrue("ShoppingCart class needs the getTotalNumberOfItems() method. Check the method's spelling, parameter type(s), and access modifier.",  getTotalNumberOfItems != null);
        assertTrue("getTotalNumberOfItems() method needs to return type: int", getTotalNumberOfItems.getReturnType() == Integer.TYPE);
        
        getTotalAmountOwed = SafeReflection.getMethod(klass, "getTotalAmountOwed");
        assertTrue("ShoppingCart class needs the getTotalAmountOwed() method. Check the method's spelling, parameter type(s), and access modifier.",  getTotalAmountOwed != null);
        assertTrue("getTotalAmountOwed() method needs to return type: double", getTotalAmountOwed.getReturnType() == Double.TYPE);
		
        addItems = SafeReflection.getMethod(klass, "addItems", Integer.TYPE, Double.TYPE);
	    assertTrue("ShoppingCart class needs the addItems(int, double) method. Check the method's spelling, parameter type(s), and access modifier.",  addItems != null);
	    assertTrue("addItems(int, double) method needs to return type: void", addItems.getReturnType() == void.class);
	    
	    getAveragePricePerItem = SafeReflection.getMethod(klass, "getAveragePricePerItem");
	    assertTrue("ShoppingCart class needs the getAveragePricePerItem() method. Check the method's spelling, parameter type(s), and access modifier.",  getAveragePricePerItem != null);
	    assertTrue("getAveragePricePerItem() method needs to return type: double", getAveragePricePerItem.getReturnType() == Double.TYPE);
		
	    empty = SafeReflection.getMethod(klass, "empty");
	    assertTrue("ShoppingCart class needs the empty() method. Check the method's spelling, parameter type(s), and access modifier.",  empty != null);
	    assertTrue("empty() method needs to return type: void", empty.getReturnType() == void.class);
    }

    @Test
    public void shoppingCartConstructorTest() {
    	try {
    		ShoppingCart shoppingCart = constructor.newInstance();
	        assertTrue("Initial total number of items should 0", 0 == (int)getTotalNumberOfItems.invoke(shoppingCart));
	        assertTrue("Initial total amount owed should 0.0", 0.0 == (double)getTotalAmountOwed.invoke(shoppingCart));
		} catch (Exception e) {
			fail("Faild to instantiate ShoppingCart");
		}
    }

    @Test
    public void shoppingCartGetAveragericePerItem() {
    	try {
			ShoppingCart shoppingCart = constructor.newInstance();
	        assertTrue("Initial average price per item should 0.0", 0.0 == (double)getAveragePricePerItem.invoke(shoppingCart));
	        addItems.invoke(shoppingCart, new Object[] { 2, 5.0d});
	        assertTrue("Total number of items should be 2", 2 == (int)getTotalNumberOfItems.invoke(shoppingCart));
	        assertTrue("Total amount owed should 10.0", 10.0 == (double)getTotalAmountOwed.invoke(shoppingCart));
	        assertTrue("The average price per item should be 5.0", 5.0 == (double)getAveragePricePerItem.invoke(shoppingCart));// < 0.1d ? true : false);
		} catch (Exception e) {
			fail("Faild to instantiate ShoppingCart");
		}
    }

    @Test
    public void shoppingCartAddItemTest() {
    	try {
			ShoppingCart shoppingCart = constructor.newInstance();
	        assertTrue("Initial total number of items should 0", 0 == (int)getTotalNumberOfItems.invoke(shoppingCart));
	        assertTrue("Initial total amount owed should 0.0", 0.0 == (double)getTotalAmountOwed.invoke(shoppingCart));
	        addItems.invoke(shoppingCart, new Object[] { 2, 5.0d});
	        assertTrue("Total number of items should be 2", 2 == (int)getTotalNumberOfItems.invoke(shoppingCart));
	        assertTrue("Total amount owed should 10.0", 10.0 == (double)getTotalAmountOwed.invoke(shoppingCart));
	        addItems.invoke(shoppingCart, new Object[] { 5, 2.50d});
	        assertTrue("Total number of items should be 7", 7 == (int)getTotalNumberOfItems.invoke(shoppingCart));
	        assertTrue("Total amount owed should 22.5", 22.5 == (double)getTotalAmountOwed.invoke(shoppingCart));
	        assertTrue("The average price per item should be 3.21", Math.abs(3.21d - (double)getAveragePricePerItem.invoke(shoppingCart)) < 0.01d ? true : false);
		} catch (Exception e) {
			fail("Faild to instantiate ShoppingCart");
		}
    }

    @Test
    public void shoppingCartEmptyTest() {
    	try {
			ShoppingCart shoppingCart = constructor.newInstance();
	        assertTrue("Initial total number of items should 0", 0 == (int)getTotalNumberOfItems.invoke(shoppingCart));
	        assertTrue("Initial total amount owed should 0.0", 0.0 == (double)getTotalAmountOwed.invoke(shoppingCart));
	        addItems.invoke(shoppingCart, new Object[] { 2, 5.0d});
	        assertTrue("Total number of items should be 2", 2 == (int)getTotalNumberOfItems.invoke(shoppingCart));
	        assertTrue("Total amount owed should 10.0", 10.0 == (double)getTotalAmountOwed.invoke(shoppingCart));
	        empty.invoke(shoppingCart);
	        assertTrue("Total number of items should be 0", 0 == (int)getTotalNumberOfItems.invoke(shoppingCart));
	        assertTrue("Total amount owed should 0.0", 0.0 == (double)getTotalAmountOwed.invoke(shoppingCart));
		} catch (Exception e) {
			fail("Faild to instantiate ShoppingCart");
		}
    }

}
