package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("login")
	public String successLogin(HttpServletRequest req,ModelMap m) {
		String name=req.getParameter("nam");
		String password=req.getParameter("pwd");
		m.addAttribute("un",name);
		m.addAttribute("up", password);
		if(name.equals("Nikhil") && password.equals("568356")) {
		
			return "success";
		}
		return "failure";
	}
}
