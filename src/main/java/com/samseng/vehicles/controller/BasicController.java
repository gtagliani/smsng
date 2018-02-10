package com.samseng.vehicles.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BasicController {
	static Logger log = Logger.getLogger(BasicController.class.getName());
	
	@RequestMapping("/")
    public String helloWorld(@RequestParam(value = "username", required = false, defaultValue = "World") String username, Model model) {
        model.addAttribute("username", username);
        log.info("HELLLLLLLLLO");
        return "index";
    }
	
	
}
