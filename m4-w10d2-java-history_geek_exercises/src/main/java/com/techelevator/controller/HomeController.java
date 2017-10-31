package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String displayHome() {
		return "home";
	}

	@RequestMapping("/usPresidents")
	public String displayUSPresidents() {
		return "usPresidents";
	}

}
