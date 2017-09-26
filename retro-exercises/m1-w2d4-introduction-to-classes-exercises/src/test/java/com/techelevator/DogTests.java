package com.techelevator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.dog.Dog;

public class DogTests {
	
	private Class<Dog> klass = null;
	private Constructor<Dog> constructor = null;
	private Method isSleeping = null;
	private Method makeSound = null;
	private Method sleep = null;
	private Method wakeUp = null;

	@Before
	public void dogRequiredMemberTests() {
		if (klass == null) {
	        klass = Dog.class;

	        constructor = SafeReflection.getConstructor(klass);
	    	assertTrue("You do not have the required default Dog() constructor", constructor != null);
		    		
	    	isSleeping = SafeReflection.getMethod(klass, "isSleeping");
		    assertTrue("Dog class needs the isSleeping() method. Check the method's spelling, parameter type(s), and access modifier.",  isSleeping != null);
		    assertTrue("isSleeping() method needs to return type: boolean", isSleeping.getReturnType() == Boolean.TYPE);
	        		
	    	makeSound = SafeReflection.getMethod(klass, "makeSound");
	        assertTrue("Dog class needs the makeSound() method. Check the method's spelling, parameter type(s), and access modifier.",  makeSound != null);
	        assertTrue("makeSound() method needs to return type: String", makeSound.getReturnType() == String.class);
    		
	        sleep = SafeReflection.getMethod(klass, "sleep");
		    assertTrue("Dog class needs the sleep() method. Check the method's spelling, parameter type(s), and access modifier.",  sleep != null);
		    assertTrue("sleep() method needs to return type: void", sleep.getReturnType() == void.class);
	        
		    wakeUp = SafeReflection.getMethod(klass, "wakeUp");
	        assertTrue("Dog class needs the wakeUp() method. Check the method's spelling, parameter type(s), and access modifier.",  wakeUp != null);
	        assertTrue("wakeUp() method needs to return type: void", wakeUp.getReturnType() == void.class);
		}
    }

	@Test
	public void dogConstructorTest() {
    	try {
			Dog dog = constructor.newInstance();
			assertTrue("New Dog should be awake.", false == (boolean)isSleeping.invoke(dog));
		} catch (Exception e) {
			fail("Faild to instantiate Dog");
		}
    }

	@Test
	public void dogMakeSoundTest() {
    	try {
			Dog dog = constructor.newInstance();
			sleep.invoke(dog);
			assertTrue("Dog should say \"Zzzzz...\".", "Zzzzz...".equals((String)makeSound.invoke(dog)));
			wakeUp.invoke(dog);
			assertTrue("Dog should say \"Woof!\".", "Woof!".equals((String)makeSound.invoke(dog)));
		} catch (Exception e) {
			fail("Faild to instantiate Dog");
		}
    }

	@Test
	public void dogSleepTest() {
    	try {
			Dog dog = constructor.newInstance();
			sleep.invoke(dog);
			assertTrue("Dog should be asleep", (boolean)isSleeping.invoke(dog));
		} catch (Exception e) {
			fail("Faild to instantiate Dog");
		}
    }

	@Test
    public void dogWakeUpTest() {
    	try {
			Dog dog = constructor.newInstance();
			sleep.invoke(dog);
			wakeUp.invoke(dog);
			assertTrue("Dog should be awake", false == (boolean)isSleeping.invoke(dog));
		} catch (Exception e) {
			fail("Faild to instantiate Dog");
		}
    }

}
