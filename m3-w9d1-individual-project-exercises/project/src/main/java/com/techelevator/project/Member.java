package com.techelevator.project;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class Member {

	private Long id;
	
	@NotBlank(message=" first name is required")
	private String firstName;
	
	@NotBlank(message=" last name is required")
	private String lastName;
	
	@Min(value=0, message="negative you must not") @Max(value=500, message="The Force is too strong") 
	private int wins;
	
	@Min(value=0, message="negative you must not") @Max(value=500, message="Strong in the force you are not") 
	private int losses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}
}
