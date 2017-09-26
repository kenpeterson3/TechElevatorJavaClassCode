package com.techelevator;

public class Employee {

	private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;

    /**
     * Creates a new employee 
     * @param employeeId
     * @param firstName
     * @param lastName
     * @param salary
     */
    public Employee(int employeeId, String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = salary;
    }

    /**
     * Employee Id
     * @return employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Employee first name
     * @return firstname
     */
    public String FirstName() {
        return firstName;
    }

    /**
     * Employee last name
     * @return lastName
     */
    public String LastName() {
        return lastName;        
    }

    /**
     * LastName, FirstName 
     * @return lastName, firstName
     */
    public String FullName() {
        return lastName + ", " + firstName;
    }

    /**
     * Department
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Department
     * @param department
     */
    public void setDepartment(String department) {
    	this.department = department;
    }
    
    /**
     * Annual Employee Salary 
     * @return
     */
    public double getAnnualSalary() {
        return annualSalary;        
    }

    /**
     * Provides the employee a percentage-based raise. Raise cannot be negative. 
     * @param percentage number-based percentage (where 1% = 1.0, 2% = 2.0)
     */
    public void RaiseSalary(double percentage) {
        double raiseAmount = annualSalary * percentage/100;
        annualSalary += raiseAmount;
    }

}
