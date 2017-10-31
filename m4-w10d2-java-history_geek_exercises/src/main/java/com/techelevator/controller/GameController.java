package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

	@RequestMapping(path="/game/game/{gridSize}")
    public String game(@PathVariable long gridSize, ModelMap model) {
//        // If the user didn't provide a gridSize (? makes it nullable)
//        // or they gave a value greater than 50 then just set it to 10
//        // by default.
//        if (!gridSize.HasValue || gridSize.Value > 50) {
//            gridSize = DefaultGridSize;
//        }
		model.addAttribute(gridSize);
        return "game/game";
    }

}
