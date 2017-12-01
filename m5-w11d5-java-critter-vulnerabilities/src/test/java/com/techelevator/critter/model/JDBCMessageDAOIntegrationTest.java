package com.techelevator.critter.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("/test-config.xml")
@Transactional
public class JDBCMessageDAOIntegrationTest {

	@Autowired private BasicDataSource dataSource;
	@Autowired private MessageDAO messageDAO;
	@Autowired private UserDAO userDAO;
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void returns_most_recent_public_messages() {
		createUser("larry");
		
		List<Message> savedMessages = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			Message message = saveMessage("larry", "Message "+i, LocalDateTime.now().plusMinutes(i));
			savedMessages.add(message);
		}
		
		List<Message> results = messageDAO.getPublicMessages(3);
		
		assertThat(results, notNullValue());
		assertThat(results.size(), equalTo(3));
		for(Message message : savedMessages) {
			assertThat(results, hasItem(messageWithId(message.getId())));
		}
	}

	@Test
	public void searches_by_userName() {
		createUser("larry");
		createUser("curly");
				
		Message message1 = saveMessage("larry", "Message 1", LocalDateTime.now().plusMinutes(1));
		saveMessage("curly", "Message 2", LocalDateTime.now().plusMinutes(2));
		Message message3 = saveMessage("larry", "Message 3", LocalDateTime.now().plusMinutes(3));
		
		List<Message> results = messageDAO.searchByUsername("larry");
		
		assertThat(results, notNullValue());
		assertThat(results.size(), equalTo(2));
		assertThat(results, hasItem(messageWithId(message1.getId())));
		assertThat(results, hasItem(messageWithId(message3.getId())));
	}

	private Message saveMessage(String userName, String text, LocalDateTime createTime) {
		Message message = new Message();
		message.setFromUsername(userName);
		message.setText(text);
		message.setCreateTime(createTime);
		messageDAO.saveMessage(message);
		return message;
	}
	
	private Matcher<Message> messageWithId(Long id) {
		return new TypeSafeMatcher<Message>() {

			public void describeTo(Description description) {
				description.appendText("Message with id: "+id);
			}

			protected boolean matchesSafely(Message message) {
				return id.equals(message.getId());
			}
		};
	}

	private void createUser(String userName) {
		userDAO.saveUser(userName, "some password");
	}
}
