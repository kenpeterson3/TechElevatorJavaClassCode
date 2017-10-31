package com.techelevator.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.model.jdbc.JdbcChatHistoryDAO;
import com.techelevator.model.jdbc.JdbcUserDAO;

public class JdbcChatHistoryDaoIntegrationTest extends DAOIntegrationTest  {

	private static ChatHistoryDAO dao;
	
	@Before
	public void setup() {
		dao = new JdbcChatHistoryDAO(getDataSource());
	}
	
	@Before
	public void clearChatHistoryTable() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update("DELETE FROM chat_history");
	}
	
	@Test
	public void saves_and_reads_one_message() {
		UserDAO userDAO = new JdbcUserDAO(getDataSource());
		User user = new User();
		user.setEmail("larrye@oracle.com");
		user.setPassword("ImFantastic");
		userDAO.saveUser(user);
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setUserID(user.getID());
		chatMessage.setMessage("Testing...1.2.3...testing");
		chatMessage.setSentDate(LocalDateTime.now());
		chatMessage.setUserName(user.getEmail());
		dao.saveChatMessage(chatMessage);
		List<ChatMessage> result = dao.getChatMessages(10);
		
		assertNotNull(result);
		assertEquals(1, result.size());
		assertThat(chatMessage, equalTo(result.get(0)));
	}
	
	private Matcher<ChatMessage> equalTo(final ChatMessage expected) {
		return new TypeSafeMatcher<ChatMessage>() {

			public void describeTo(Description description) {
			}

			protected boolean matchesSafely(ChatMessage chatMessage) {
				return nullOrEqual(expected.getID(), chatMessage.getID()) &&
						nullOrEqual(expected.getUserID(), chatMessage.getUserID()) &&
						nullOrEqual(expected.getMessage(), chatMessage.getMessage()) &&
						nullOrEqual(expected.getSentDate(), chatMessage.getSentDate());
			}
			
			private boolean nullOrEqual(Object left, Object right) {
				return left != null ? left.equals(right) : right == null;
			}
		};
	}
}
