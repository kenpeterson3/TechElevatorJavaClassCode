package com.techelevator.validation.controller;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class RegistrationSignUp {
	@NotBlank(message="First name is required") @Size(max=20, message="names cannot be longer thn 20 characters")
	private String firstName;
	
	@NotBlank(message="Last name is required") @Size(max=20, message="names cannot be longer thn 20 characters")
	private String lastName;
	
	@NotBlank(message="Email is required") @Email(message="Not a valid Email address")
	private String email;
	
	@NotBlank(message="Email is required") @Email(message="Email address does not match")
	private String confirmEmail;
	
	@Size(min=8, message="Password must be 8 characters long") @NotBlank(message="Password is required") 
	private String password;
	
	@Size(min=8, message="Password must be 8 characters long") @NotBlank(message="Password is required") 
	private String passwordCheck;
	
	@NotNull(message="Please enter a date")  @DateTimeFormat(pattern="mm/dd/yyyy") @Past
	private Date birthDate;
	
	@Min(value=1, message="you must buy 1 ticket") @Max(value=10, message="you cannot buy more than 10 tickets at one time") @NotNull(message="# of tickets must be between 1-10")
	private int ticket;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getTicket() {
		return ticket;
	}

	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}
}
