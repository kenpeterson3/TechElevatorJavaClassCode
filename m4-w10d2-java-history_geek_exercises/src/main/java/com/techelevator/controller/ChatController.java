package com.techelevator.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.ChatHistoryDAO;
import com.techelevator.model.ChatMessage;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
public class ChatController {
	
	@Autowired
	private ChatHistoryDAO chatRepository;
	
	@Autowired
	private UserDAO userRepository;
	
	@RequestMapping(value="/chat", method=RequestMethod.GET)
	public String index(Model model) {
		List<ChatMessage> messages = chatRepository.getChatMessages(20);
		
		model.addAttribute("messages", messages);
		return "chat/index";
	}
	
	@MessageMapping("/chat")
	//@PreAuthorize("isAuthorized()")
	public ChatMessage handleMessage(ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		if(chatMessage != null && ! chatMessage.getMessage().isEmpty()) {
			
			 // Get the user who sent in the request
            User user = userRepository.getUser((String)headerAccessor.getSessionAttributes().get("email"));
            
            if(user != null) {
            	chatMessage.setUserID(user.getID());
            	chatMessage.setUserName(user.getEmail());
            }
            chatMessage.setSentDate(LocalDateTime.now());

            // Save the chat message
            chatRepository.saveChatMessage(chatMessage);

            return chatMessage;
        }
		
		return null;
	}

	public ChatHistoryDAO getChatRepository() {
		return chatRepository;
	}

	public void setChatRepository(ChatHistoryDAO chatRepository) {
		this.chatRepository = chatRepository;
	}

	public UserDAO getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserDAO userRepository) {
		this.userRepository = userRepository;
	}
}
