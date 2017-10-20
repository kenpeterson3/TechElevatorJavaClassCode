package com.techelevator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.model.ReviewDao;

@Controller 
public class HelloController {
	
	@Autowired
	ReviewDao reviewDao;

	@RequestMapping("/greeting")
	public String displayGreeting() {
		
		return "greeting";
	}
}
