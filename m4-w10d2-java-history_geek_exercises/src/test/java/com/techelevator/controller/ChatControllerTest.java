package com.techelevator.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyCollectionOf;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.ui.Model;

import com.techelevator.model.ChatHistoryDAO;
import com.techelevator.model.ChatMessage;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

public class ChatControllerTest {
	@Test
	public void index_calls_get_messages() {
		ChatHistoryDAO chatRepo = mock(ChatHistoryDAO.class);
		Model model = mock(Model.class);
		
		ChatController cont = new ChatController();
		cont.setChatRepository(chatRepo);
		
		cont.index(model);
		
		verify(chatRepo).getChatMessages(20);
		verify(model).addAttribute(eq("messages"), anyCollectionOf(ChatMessage.class));
	}
	
	@Test
	public void handle_message_saves_messages_and_returns_them() {
		UserDAO userRepo = mock(UserDAO.class);
		ChatHistoryDAO chatRepo = mock(ChatHistoryDAO.class);
		SimpMessageHeaderAccessor accessor = mock(SimpMessageHeaderAccessor.class);
		
		String testMessage = "Test Message";
		String testEmail = "test@test.com";
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setMessage(testMessage);
		
		User user = new User();
		user.setEmail(testEmail);
		
		Map<String, Object> session = new HashMap<String, Object>();
		session.put("email", testEmail);
		
		when(accessor.getSessionAttributes()).thenReturn(session);
		when(userRepo.getUser(testEmail)).thenReturn(user);
		
		ChatController cont = new ChatController();
		cont.setChatRepository(chatRepo);
		cont.setUserRepository(userRepo);
		
		ChatMessage returnedMessage = cont.handleMessage(chatMessage, accessor);
		
		verify(userRepo).getUser(testEmail);
		verify(chatRepo).saveChatMessage(returnedMessage);
		
		assertEquals(testEmail, returnedMessage.getUserName());
		assertEquals(testMessage, returnedMessage.getMessage());
	}
	
	@Test
	public void handle_null_message_and_do_nothing() {
		UserDAO userRepo = mock(UserDAO.class);
		ChatHistoryDAO chatRepo = mock(ChatHistoryDAO.class);
		SimpMessageHeaderAccessor accessor = mock(SimpMessageHeaderAccessor.class);
		
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setMessage("");
		
		ChatController cont = new ChatController();
		cont.setChatRepository(chatRepo);
		cont.setUserRepository(userRepo);
		
		ChatMessage returnedMessage = cont.handleMessage(chatMessage, accessor);
		
		verify(userRepo, never()).getUser(any());
		verify(chatRepo, never()).saveChatMessage(any());
		
		assertEquals(null, returnedMessage);
	}
}
