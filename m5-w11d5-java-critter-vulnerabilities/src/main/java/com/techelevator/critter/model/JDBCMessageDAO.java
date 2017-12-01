package com.techelevator.critter.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCMessageDAO implements MessageDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCMessageDAO(DataSource dataSource) {
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Message> getPublicMessages(int limit) {
		String sqlSelectPublicMessages = "SELECT * "+
										 "FROM message "+
										 "WHERE private = FALSE "+
										 "ORDER BY create_date DESC "+
										 "LIMIT "+limit;
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectPublicMessages);
		return mapRowSetToMessages(results);
	}

	@Override
	public void saveMessage(Message message) {
		Long id = getNextMessageId();
		message.setId(id);
		jdbcTemplate.update("INSERT INTO message(message_id, sender_name, receiver_name, message_text, private, create_date) VALUES (?,?,?,?,?,?)",
							id, message.getFromUsername(), message.getToUsername(), message.getText(), message.isPrivate(), message.getCreateTime());
	}
	
	@Override
	public List<Message> searchByUsername(String userName) {
		String sqlSelectPublicMessagesByUser = "SELECT * "+
											   "FROM message "+
											   "WHERE private = FALSE "+
											   "AND sender_name = '"+userName+"' "+
											   "ORDER BY create_date DESC ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectPublicMessagesByUser);
		return mapRowSetToMessages(results);
	}
	
	@Override
	public List<Conversation> getConversationsForUser(String userName) {
		ArrayList<Conversation> conversationList = new ArrayList<>();
		
		String sqlSelectConversations =  "SELECT DISTINCT(receiver_name) "+
										 "FROM message "+
									     "WHERE sender_name = '"+userName+"' "+
										 "AND private = true "+
									     "UNION "+
										 "SELECT DISTINCT(sender_name) "+
									     "FROM message "+
										 "WHERE receiver_name = '"+userName+"' "+
									     "AND private = true";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectConversations);
		
		while (results.next())
		{
			Conversation c = new Conversation();
			c.setForUser(userName);
			c.setWithUser(results.getString(1));
			List<Message> messages = getConversationMessages(c.getForUser(), c.getWithUser());
			for(Message m : messages) {
				c.addMessage(m);
			}
			conversationList.add(c);
		}
		
		conversationList.sort((c1, c2) -> -1 * c1.getLatestMessage().getCreateTime().compareTo(c2.getLatestMessage().getCreateTime()));
		
		return conversationList;
	}
	
	@Override
	public Conversation getConversation(String forUserName, String withUserName) {
		Conversation c = new Conversation();
		c.setForUser(forUserName);
		c.setWithUser(withUserName);
		List<Message> messages = getConversationMessages(c.getForUser(), c.getWithUser());
		for(Message m : messages) {
			c.addMessage(m);
		}
		return c;
	}
	
	private List<Message> getConversationMessages(String forUser, String withUser) {
		String sqlSelectByConversation = "SELECT * FROM message "+
										 "WHERE (sender_name = '"+forUser+"' AND receiver_name = '"+withUser+"') "+
										 "OR (sender_name = '"+withUser+"' AND receiver_name = '"+forUser+"') "+
										 "ORDER BY create_date DESC";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectByConversation);
		return mapRowSetToMessages(results);
	}
	
	@Override
	public List<Message> getMessagesSentByUser(String userName) {
		String sqlSelectMessagesSentByUser = "SELECT * "+
										     "FROM message "+
										     "WHERE sender_name = '"+userName+"' "+
										     "ORDER BY create_date DESC ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectMessagesSentByUser);
		return mapRowSetToMessages(results);
	}

	private List<Message> mapRowSetToMessages(SqlRowSet results) {
		ArrayList<Message> messageList = new ArrayList<>();
		while(results.next()) {
			messageList.add(mapRowToMessage(results));
		}
		return messageList;
	}
	

	private Message mapRowToMessage(SqlRowSet results) {
		Message message = new Message();
		message.setId(results.getLong("message_id"));
		message.setFromUsername(results.getString("sender_name"));
		message.setToUsername(results.getString("receiver_name"));
		message.setText(results.getString("message_text"));
		message.setCreateTime(results.getTimestamp("create_date").toLocalDateTime());
		return message;
	}

	private Long getNextMessageId() {
		SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT nextval('message_message_id_seq')");
		result.next();
		Long id = result.getLong(1);
		return id;
	}

}
