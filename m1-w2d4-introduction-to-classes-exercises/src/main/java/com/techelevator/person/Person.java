package com.techelevator.person;

public class Person {
//data members
	private String firstName;
	private String lastName;
	private int age;
	//methods
	 public String getFullName(){
		 return (lastName + ", " + firstName);
		 
	 }
	 public boolean isAdult() {
		 return age >= 18;
	 }
	 //getters and setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
