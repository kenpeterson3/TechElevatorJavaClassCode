package com.techelevator.critter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.critter.model.MessageDAO;
import com.techelevator.critter.model.UserDAO;

@Controller
public class UserController {

	private UserDAO userDAO;
	private MessageDAO messageDAO;

	@Autowired
	public UserController(UserDAO userDAO, MessageDAO messageDAO) {
		this.userDAO = userDAO;
		this.messageDAO = messageDAO;
	}

	@RequestMapping(path="/users/new", method=RequestMethod.GET)
	public String displayNewUserForm() {
		return "newUser";
	}
	
	@RequestMapping(path="/users", method=RequestMethod.POST)
	public String createUser(@RequestParam String userName, @RequestParam String password) {
		userDAO.saveUser(userName, password);
		return "redirect:/login";
	}
	
	@RequestMapping(path="/users/{userName}", method=RequestMethod.GET)
	public String displayDashboard(Map<String, Object> model, @PathVariable String userName) {
		model.put("conversations", messageDAO.getConversationsForUser(userName));
		return "userDashboard";
	}
	
	@RequestMapping(path="/users/{forUserName}/conversations/{withUserName}", method=RequestMethod.GET)
	public String displayConversation(Map<String, Object> model, @PathVariable String forUserName, @PathVariable String withUserName) {
		model.put("conversation", messageDAO.getConversation(forUserName, withUserName));
		return "conversation";
	}
	
	@RequestMapping(path="/users/{userName}/messages", method=RequestMethod.GET)
	public String displaySentMessages(Map<String, Object> model, @PathVariable String userName) {
		model.put("messages", messageDAO.getMessagesSentByUser(userName));		
		return "sentMessages";
	}
	
	@RequestMapping(path="/users/{userName}/changePassword", method=RequestMethod.GET)
	public String displayChangePasswordForm(Map<String, Object> model, @PathVariable String userName) {
		model.put("userName", userName);
		return "changePassword";
	}
	
	@RequestMapping(path="/users/{userName}/changePassword", method=RequestMethod.POST)
	public String changePassword(@PathVariable String userName, @RequestParam String password) {
		userDAO.updatePassword(userName, password);
		return "userDashboard";
	}
}
