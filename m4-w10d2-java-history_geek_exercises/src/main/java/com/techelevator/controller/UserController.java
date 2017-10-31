package com.techelevator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes("email")
public class UserController {

	private UserDAO userDao;
	
	@Autowired
	public UserController(UserDAO userDAO) {
		this.userDao = userDAO;
	}
	
	@RequestMapping(path="/user/register")
	public String inputNewUser() {
		return "user/register";
	}
	
    @RequestMapping(path="/user/register", method=RequestMethod.POST)
    public String registerNewUser(@RequestParam String email, @RequestParam String password, ModelMap model) {
    	User user = new User();
    	user.setEmail(email);
    	user.setPassword(password);
    	userDao.saveUser(user);
    	return "redirect:/user/login";
    }

    @RequestMapping(path={"/user/login"})
    public String inputLogin() {
    	return "user/login";
    }

    @RequestMapping(path="/user/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam String email, @RequestParam String password, ModelMap model) {            
		User user = userDao.getUser(email);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				model.addAttribute("email", user.getEmail());
				return "redirect:/";
			}
		}
   		return "user/login";
     }

    @RequestMapping(path="/user/logout")
    public String logout(HttpSession session, ModelMap model) {
    	session.invalidate();
    	model.remove("email");
        return "redirect:/";
    }
}
