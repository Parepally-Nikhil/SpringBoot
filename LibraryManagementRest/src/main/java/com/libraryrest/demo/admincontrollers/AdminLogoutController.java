package com.libraryrest.demo.admincontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLogoutController {
	@RequestMapping("logout")
	public String logout() {
		return "index.jsp";
	}
}
