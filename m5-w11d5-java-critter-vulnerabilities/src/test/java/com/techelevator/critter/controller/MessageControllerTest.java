package com.techelevator.critter.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.anyString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.techelevator.critter.model.Message;
import com.techelevator.critter.model.MessageDAO;

public class MessageControllerTest {

	private MessageController controller;
	private MessageDAO messageDAO;
	private Map<String, Object> model;
	
	@Before
	public void setup() {
		messageDAO = Mockito.mock(MessageDAO.class);
		controller = new MessageController(messageDAO);
		model = new HashMap<>();
	}
	
	@Test
	public void shows_messages_view() {
		String viewName = controller.messageSearch(model, "larry");
		assertThat(viewName, equalTo("messages"));
	}

	@Test
	public void searches_by_userName() {
		controller.messageSearch(model, "larry");
		verify(messageDAO).searchByUsername("larry");
	}
	
	@Test
	public void adds_search_results_to_model() {
		List<Message> messages = new ArrayList<>();
		when(messageDAO.searchByUsername(anyString())).thenReturn(messages);
		controller.messageSearch(model, "larry");
		assertThat(model.get("messages"), equalTo(messages));
	}
	
	@Test
	public void saves_public_message() {
		String userName = "the_current_user";
		String visibility = "public";
		String messageText = "Hello, World!";
		Message expectedMessage = new Message();
		expectedMessage.setFromUsername(userName);
		expectedMessage.setText(messageText);
		controller.createNewMessage(userName, visibility, null, messageText);
		verify(messageDAO).saveMessage(argThat(isEqualTo(expectedMessage)));
	}

	@Test
	public void redirects_to_sent_messages_after_sending_message() {
		String userName = "the_current_user";
		String visibility = "public";
		String messageText = "Hello, World!";
		String viewName = controller.createNewMessage(userName, visibility, null, messageText);
		assertThat(viewName, equalTo("redirect:/users/"+userName+"/messages"));
	}
	
	private Matcher<Message> isEqualTo(final Message expectedMessage) {
		return new TypeSafeMatcher<Message>() {

			@Override
			public void describeTo(Description description) {
				description.appendText("Message[from: "+expectedMessage.getFromUsername()+", to: "+expectedMessage.getToUsername()+", text: "+expectedMessage.getText());
			}

			@Override
			protected boolean matchesSafely(Message actualMessage) {
				return expectedMessage.getFromUsername().equals(actualMessage.getFromUsername()) &&
						expectedMessage.getText().equals(actualMessage.getText()) &&
						(expectedMessage.getToUsername() == null || 
						  expectedMessage.getToUsername().equals(actualMessage.getToUsername()));
			}
		};
	}

}
