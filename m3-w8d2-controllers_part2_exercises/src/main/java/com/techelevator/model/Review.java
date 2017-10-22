package com.techelevator.model;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Review {
	private Long id;
	
	@NotBlank(message="Username is required")
	private String username;
	@Min(value=1, message="you must choose 1 star") @Max(value=5, message="you cannot choose more than 5 stars") @NotNull(message="Rating is requiredß")
	private int rating;
	@NotBlank(message="Title is required")
	private String title;
	@NotBlank(message="Text is required")
	private String text;
	private LocalDateTime dateSubmitted;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDateTime getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(LocalDateTime dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
}
