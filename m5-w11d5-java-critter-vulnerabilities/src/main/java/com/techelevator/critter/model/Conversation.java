package com.techelevator.critter.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conversation {
	
	private String forUser;
	private String withUser;
	private List<Message> messages;
	
	public Conversation() {
		messages = new ArrayList<>();
	}
	
	public String getForUser() {
		return forUser;
	}
	public void setForUser(String forUser) {
		this.forUser = forUser;
	}
	public String getWithUser() {
		return withUser;
	}
	public void setWithUser(String withUser) {
		this.withUser = withUser;
	}
	public List<Message> getMessages() {
		return Collections.unmodifiableList(messages);
	}
	public Message getLatestMessage() {
		return messages.get(0);
	}
	public void addMessage(Message message) {
		messages.add(message);
	}
}
