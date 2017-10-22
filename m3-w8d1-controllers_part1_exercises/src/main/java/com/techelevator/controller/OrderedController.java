package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //spring controller
public class OrderedController {

	@RequestMapping("/xOrdered")
	
	public String formDisplay() {
		
		return "orderedNameForm";
	}
	@RequestMapping("/xOrderedResult")
	public String generateResults(@RequestParam String firstName,@RequestParam String middleName,@RequestParam String lastName,@RequestParam String order,ModelMap modelHolder ){
		if("FML".equals(order)){
			modelHolder.put("nameOrder",firstName + middleName + lastName);
		}
		if("FL".equals(order)){
			modelHolder.put("nameOrder",firstName + lastName);
		}
		if("LFM".equals(order)){
			modelHolder.put("nameOrder",lastName + firstName + middleName );
		}
		if("LF".equals(order)){
			modelHolder.put("nameOrder",lastName + firstName );
		}
		return "orderedNameResult";
	}
}
