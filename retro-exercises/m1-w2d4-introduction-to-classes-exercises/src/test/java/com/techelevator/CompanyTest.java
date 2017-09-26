package com.techelevator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.company.Company;

public class CompanyTest {
	
	private Class<Company> klass = null;
	private Constructor<Company> constructor = null;
	private Method getName = null;
	private Method setName = null;
	private Method getNumberOfEmployees = null;
	private Method setNumberOfEmployees = null;
	private Method getRevenue = null;
	private Method setRevenue = null;
	private Method getExpenses = null;
	private Method setExpenses = null;
	private Method getCompanySize = null;
	private Method getProfit = null;
	
	@Before
    public void companyRequiredMembers() {
		if (klass == null) {
	        klass = Company.class;

	        constructor = SafeReflection.getConstructor(klass);
	    	assertTrue("You do not have the required default Company() constructor", constructor != null);
	        		
	    	getName = SafeReflection.getMethod(klass, "getName");
	        assertTrue("Company class needs the getName() method. Check the method's spelling, parameter type(s), and access modifier.",  getName != null);
	        assertTrue("getName() method needs to return type: String", getName.getReturnType() == String.class);
	        
	        setName = SafeReflection.getMethod(klass, "setName", String.class);
	        assertTrue("Company class needs the setName(String) method. Check the method's spelling, parameter type(s), and access modifier.",  setName != null);
	        assertTrue("setName(String) method needs to return type: void", setName.getReturnType() == void.class);
    		
	        getNumberOfEmployees = SafeReflection.getMethod(klass, "getNumberOfEmployees");
		    assertTrue("Company class needs the getNumberOfEmployees() method. Check the method's spelling, parameter type(s), and access modifier.",  getNumberOfEmployees != null);
		    assertTrue("getNumberOfEmployees() method needs to return type: int", getNumberOfEmployees.getReturnType() == Integer.TYPE);
		    
		    setNumberOfEmployees = SafeReflection.getMethod(klass, "setNumberOfEmployees", Integer.TYPE);
		    assertTrue("Company class needs the setNumberOfEmployees(int) method. Check the method's spelling, parameter type(s), and access modifier.",  setNumberOfEmployees != null);
		    assertTrue("setNumberOfEmployees(int) method needs to return type: void", setNumberOfEmployees.getReturnType() == void.class);
    		
		    getRevenue = SafeReflection.getMethod(klass, "getRevenue");
		    assertTrue("Company class needs the getRevenue() method. Check the method's spelling, parameter type(s), and access modifier.",  getRevenue != null);
		    assertTrue("getRevenue() method needs to return type: double", getRevenue.getReturnType() == Double.TYPE);
		    
		    setRevenue = SafeReflection.getMethod(klass, "setRevenue", Double.TYPE);
		    assertTrue("Company class needs the setRevenue(double) method. Check the method's spelling, parameter type(s), and access modifier.",  setRevenue != null);
		    assertTrue("setRevenue(double) method needs to return type: void", setRevenue.getReturnType() == void.class);
    		
		    getExpenses = SafeReflection.getMethod(klass, "getExpenses");
		    assertTrue("Company class needs the getExpenses() method. Check the method's spelling, parameter type(s), and access modifier.",  getExpenses != null);
		    assertTrue("getExpenses() method needs to return type: double", getExpenses.getReturnType() == Double.TYPE);
		    
		    setExpenses = SafeReflection.getMethod(klass, "setExpenses", Double.TYPE);
		    assertTrue("Company class needs the setExpenses(int) method. Check the method's spelling, parameter type(s), and access modifier.",  setExpenses != null);
		    assertTrue("setExpenses(int) method needs to return type: void", setExpenses.getReturnType() == void.class);
		    
		    getCompanySize = SafeReflection.getMethod(klass, "getCompanySize");
	        assertTrue("Company class needs the getCompanySize() method. Check the method's spelling, parameter type(s), and access modifier.",  getCompanySize != null);
	        assertTrue("getCompanySize() method needs to return type: String", getCompanySize.getReturnType() == String.class);

	        getProfit = SafeReflection.getMethod(klass, "getProfit");
	        assertTrue("Company class needs the getProfit() method. Check the method's spelling, parameter type(s), and access modifier.",  getProfit != null);
	        assertTrue("getProfit() method needs to return type: double", getProfit.getReturnType() == Double.TYPE);
		}        
    }

	@Test
	public void companyConstructorTests() {
    	try {
			Company company = constructor.newInstance();

			setName.invoke(company, new Object[] { "My Company" });
	        assertTrue("getName should return \"My Company\"", "My Company".equals((String)getName.invoke(company)));
	        
	        setNumberOfEmployees.invoke(company, new Object[] { 37 });
	        assertTrue("getNumberOfEmployees should return 37", 37 == (int)getNumberOfEmployees.invoke(company));
	        
	        setRevenue.invoke(company, new Object[] { 6543.21d });
	        assertTrue("getRevenue should return 6543.21", 6543.21d == (double)getRevenue.invoke(company));
	        
	        setExpenses.invoke(company, new Object[] { 1234.56d });
	        assertTrue("getNumberOfEmployees should return 1234.56", 1234.56d == (double)getExpenses.invoke(company));
		} catch (Exception e) {
			fail("Faild to instantiate Company");
		}
    }

	@Test
	public void companyCompanySizeTests() {
    	try {
			Company company = constructor.newInstance();
	        setNumberOfEmployees.invoke(company, new Object[] { 49 });
	        assertTrue("Company Size should be 'small' when employees are 50 or less", "small".equals((String)getCompanySize.invoke(company)));
	        setNumberOfEmployees.invoke(company, new Object[] { 50 });
	        assertTrue("Company Size should be 'small' when employees are 50 or less", "small".equals((String)getCompanySize.invoke(company)));
	        setNumberOfEmployees.invoke(company, new Object[] { 51 });
	        assertTrue("Company Size should be 'medium' when employees are between 51 and 250 inclusive", "medium".equals((String)getCompanySize.invoke(company)));
	        setNumberOfEmployees.invoke(company, new Object[] { 250 });
	        assertTrue("Company Size should be 'medium' when employees are between 51 and 250 inclusive", "medium".equals((String)getCompanySize.invoke(company)));
	        setNumberOfEmployees.invoke(company, new Object[] { 251 });
	        assertTrue("Company Size should be 'large' when employees are over 250 inclusive", "large".equals((String)getCompanySize.invoke(company)));
		} catch (Exception e) {
			fail("Faild to instantiate Company");
		}
    }

	@Test
    public void companyProfitTests() {
    	try {
			Company company = constructor.newInstance();
	        setRevenue.invoke(company, new Object[] { 6543.21d });
	        setExpenses.invoke(company, new Object[] { 1234.56d });
	        assertTrue("Revenue:6543.21 - Expenses:1234.56 = Profit:5308.65", 5308.65 == (double)getProfit.invoke(company));
		} catch (Exception e) {
			fail("Faild to instantiate Company");
		}
    }

}
