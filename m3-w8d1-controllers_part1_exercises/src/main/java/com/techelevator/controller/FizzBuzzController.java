package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.FizzBuzz;


@Controller
public class FizzBuzzController {
	
	@RequestMapping(path="/fizzBuzz", method=RequestMethod.GET)
	
	public String showFizzBuzzForm() {
		
		return "fizzBuzzNameForm";
}
	
	@RequestMapping(path="/fizzBuzzResult", method=RequestMethod.GET)
	
	public String generateResults(@ModelAttribute FizzBuzz fizzBuzz ) {
		
		return "fizzBuzzResult";
	}
}