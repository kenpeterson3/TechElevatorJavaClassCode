package com.techelevator.critter.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.techelevator.critter.model.Message;
import com.techelevator.critter.model.MessageDAO;

public class HomeControllerTest {

	private HomeController controller;
	private MessageDAO messageDAO;
	private Map<String, Object> model;
	
	@Before
	public void setup() {
		messageDAO = mock(MessageDAO.class);
		controller = new HomeController(messageDAO);
		model = new HashMap<>();
	}
	
	@Test
	public void returns_home_page_view() {
		assertThat(controller.showHomePage(model), equalTo("home"));
	}

	@Test
	public void adds_recent_messages_to_model() {
		List<Message> messages = new ArrayList<>();
		when(messageDAO.getPublicMessages(anyInt())).thenReturn(messages);
		controller.showHomePage(model);
		assertThat(model.get("messages"), equalTo(messages));
	}
	
	@Test
	public void displays_10_latest_messages_on_home_page() {
		controller.showHomePage(model);
		verify(messageDAO).getPublicMessages(10);
	}
}
