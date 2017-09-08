package com.techelevator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.person.Person;

public class PersonTest {
	
	private Class<Person> klass = null;
	private Constructor<Person> constructor = null;
	private Method getFirstName = null;
	private Method setFirstName = null;
	private Method getLastName = null;
	private Method setLastName = null;
	private Method getAge = null;
	private Method setAge = null;
	private Method getFullName = null;
	private Method isAdult = null;

	@Before
    public void personRequiredMembers() {
		if (klass == null) {
	        klass = Person.class;

	        constructor = SafeReflection.getConstructor(klass);
	    	assertTrue("You do not have the required default Person() constructor", constructor != null);
	        		
	    	getFirstName = SafeReflection.getMethod(klass, "getFirstName");
	        assertTrue("Person class needs the getFirstName() method. Check the method's spelling, parameter type(s), and access modifier.",  getFirstName != null);
	        assertTrue("getFirstName() method needs to return type: String", getFirstName.getReturnType() == String.class);
	        
	        setFirstName = SafeReflection.getMethod(klass, "setFirstName", String.class);
	        assertTrue("Person class needs the setFirstName(String) method. Check the method's spelling, parameter type(s), and access modifier.",  setFirstName != null);
	        assertTrue("setFirstName(String) method needs to return type: void", setFirstName.getReturnType() == void.class);
    		
	        getLastName = SafeReflection.getMethod(klass, "getLastName");
		    assertTrue("Person class needs the getLastName() method. Check the method's spelling, parameter type(s), and access modifier.",  getLastName != null);
		    assertTrue("getLastName() method needs to return type: String", getLastName.getReturnType() == String.class);
		    
		    setLastName = SafeReflection.getMethod(klass, "setLastName", String.class);
		    assertTrue("Person class needs the setLastName(String) method. Check the method's spelling, parameter type(s), and access modifier.",  setLastName != null);
		    assertTrue("setLastName(String) method needs to return type: void", setLastName.getReturnType() == void.class);
    		
		    getAge = SafeReflection.getMethod(klass, "getAge");
		    assertTrue("Person class needs the getAge() method. Check the method's spelling, parameter type(s), and access modifier.",  getAge != null);
		    assertTrue("getAge() method needs to return type: int", getAge.getReturnType() == Integer.TYPE);
		    
		    setAge = SafeReflection.getMethod(klass, "setAge", Integer.TYPE);
		    assertTrue("Person class needs the setAge(int) method. Check the method's spelling, parameter type(s), and access modifier.",  setAge != null);
		    assertTrue("setAge(int) method needs to return type: void", setAge.getReturnType() == void.class);
		    
		    getFullName = SafeReflection.getMethod(klass, "getFullName");
	        assertTrue("Person class needs the getFullName() method. Check the method's spelling, parameter type(s), and access modifier.",  getFullName != null);
	        assertTrue("getFullName() method needs to return type: String", getFullName.getReturnType() == String.class);

	        isAdult = SafeReflection.getMethod(klass, "isAdult");
	        assertTrue("Person class needs the isAdult() method. Check the method's spelling, parameter type(s), and access modifier.",  isAdult != null);
	        assertTrue("isAdult() method needs to return type: boolean", isAdult.getReturnType() == Boolean.TYPE);
		}        
	}

	@Test
    public void personNameTests() {
    	try {
			Person person = constructor.newInstance();

			setFirstName.invoke(person, new Object[] { "Fred" });
	        assertTrue("getFirstName should return \"Fred\"", "Fred".equals((String)getFirstName.invoke(person)));
	        setLastName.invoke(person, new Object[] { "Flintstone" });
	        assertTrue("getLastName should return \"Fred\"", "Flintstone".equals((String)getLastName.invoke(person)));
	        assertTrue("getFullName should return \"Flintstone, Fred\".", "Flintstone, Fred".equals((String)getFullName.invoke(person)));
		} catch (Exception e) {
			fail("Faild to instantiate Person");
		}
    }

	@Test
    public void personIsAdultTests() {
    	try {
			Person person = constructor.newInstance();
			setAge.invoke(person, new Object[] { 17 });
			assertTrue("Age should be 17.", 17 == (int)getAge.invoke(person));
	        assertTrue("isAdult should return false", false == (boolean)isAdult.invoke(person));
			setAge.invoke(person, new Object[] { 18 });
			assertTrue("Age should be 18.", 18 == (int)getAge.invoke(person));
	        assertTrue("isAdult should return true", (boolean)isAdult.invoke(person));
			setAge.invoke(person, new Object[] { 19 });
			assertTrue("Age should be 19.", 19 == (int)getAge.invoke(person));
	        assertTrue("isAdult should return true", (boolean)isAdult.invoke(person));
		} catch (Exception e) {
			fail("Faild to instantiate Person");
		}
    }
}
