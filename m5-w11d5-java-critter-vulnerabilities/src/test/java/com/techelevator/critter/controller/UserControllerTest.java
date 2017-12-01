package com.techelevator.critter.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.techelevator.critter.model.MessageDAO;
import com.techelevator.critter.model.UserDAO;

public class UserControllerTest {

	private UserController controller;
	private UserDAO userDAO;
	private MessageDAO messageDAO;
	
	@Before
	public void setup() {
		userDAO = mock(UserDAO.class);
		messageDAO = mock(MessageDAO.class);
		controller = new UserController(userDAO, messageDAO);
	}
	
	@Test
	public void redirects_to_login_page_after_user_creation() {
		String viewName = controller.createUser("mr_rogers", "hello there!");
		assertThat(viewName, equalTo("redirect:/login"));
	}

	@Test
	public void creates_user() {
		String userName = "batman";
		String password = "gotham123";
		controller.createUser(userName, password);
		verify(userDAO).saveUser(userName, password);
	}

}
