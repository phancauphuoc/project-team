package com.store.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author william stanford mario jang
 *
 */

@Controller
public class HomeController {
		private Logger log = LoggerFactory.getLogger(HomeController.class);
		
	@GetMapping({"/", ""})
	public String home() {
		return "redirect:/admin";
	}
	@GetMapping({"/login", ""})
	public String login(Model model) {
		log.info("{}", "oi oi toi login form");
		return "login";
	}
}
