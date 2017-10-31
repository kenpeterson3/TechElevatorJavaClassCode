package com.techelevator.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class ChatMessage {
	
	private Long id;
	private Long userID;
	private String message;
	private LocalDateTime sentDate;
	private String userName;
	
	public Long getID() {
		return id;
	}
	public void setID(Long id) {
		this.id = id;
	}
	// Required
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	// Required
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getSentDate() {
		return sentDate;
	}
	public Date getSentDateAsDate() {
		Instant instant = sentDate.toInstant(ZoneOffset.of("-5"));
		return Date.from(instant);
	}
	public void setSentDate(LocalDateTime sentDate) {
		this.sentDate = sentDate;
	}
	// userName property is retrieved by joining with the users table
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
