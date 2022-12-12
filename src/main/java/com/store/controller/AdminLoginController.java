package com.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hieun
 * 10 Aug 2022  14:37:42
 *
 * cloud.com.store.controller.AdminLoginController
 */

@Controller
public class AdminLoginController {

	@GetMapping({"/login","/"})
	public String loginAdmin() {
		return "login";
	}
}
