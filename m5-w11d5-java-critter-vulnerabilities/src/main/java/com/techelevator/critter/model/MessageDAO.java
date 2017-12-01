package com.techelevator.critter.model;

import java.util.List;

public interface MessageDAO {

	public List<Message> getPublicMessages(int limit);

	public void saveMessage(Message message);

	public List<Message> searchByUsername(String userName);

	public List<Message> getMessagesSentByUser(String userName);

	public List<Conversation> getConversationsForUser(String userName);

	public Conversation getConversation(String forUserName, String withUserName);

}
