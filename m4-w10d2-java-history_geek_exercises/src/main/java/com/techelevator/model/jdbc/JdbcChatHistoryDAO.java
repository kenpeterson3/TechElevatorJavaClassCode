package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.ChatHistoryDAO;
import com.techelevator.model.ChatMessage;

@Component
public class JdbcChatHistoryDAO implements ChatHistoryDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcChatHistoryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<ChatMessage> getChatMessages(int limit) {
		List<ChatMessage> chatMessages = new ArrayList<>();
		String sqlSelectChatHistoryWithLimit = "SELECT chat_history.id, userId, message, sentDate, users.email AS username FROM chat_history INNER JOIN users ON chat_history.userId = users.id ORDER BY sentDate LIMIT ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectChatHistoryWithLimit, limit);
		while(results.next()) {
			chatMessages.add(mapRowToChatHistory(results));
		}
		return chatMessages;
    }

	@Override
	public void saveChatMessage(ChatMessage message) {
		String sqlInsertProduct = "INSERT INTO chat_history(id, userid, message, sentdate) VALUES(?, ?, ?, ?)";
		Long id = getNextId();
		jdbcTemplate.update(sqlInsertProduct, id, message.getUserID(), message.getMessage(), message.getSentDate());
		message.setID(id);
	}
	
	private ChatMessage mapRowToChatHistory(SqlRowSet row) {
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setID(row.getLong("id"));
		chatMessage.setUserID(row.getLong("userId"));
		chatMessage.setMessage(row.getString("message"));
		chatMessage.setSentDate(row.getTimestamp("sentDate").toLocalDateTime());
		chatMessage.setUserName(row.getString("username"));
		return chatMessage;
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_chat_history_id')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if(result.next()) {
			return result.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next chat history id");
		}
	}
}
