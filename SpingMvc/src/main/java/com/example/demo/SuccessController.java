package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SuccessController {
	@RequestMapping("successcontroller")
	public String success() {
		return "success";
	}
	
	@RequestMapping("index")
	public String home() {
		return "index";
	}
}
