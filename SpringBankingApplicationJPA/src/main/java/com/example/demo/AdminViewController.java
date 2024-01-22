package com.example.demo;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminViewController {
	@Autowired
	private Dao dao;
	@RequestMapping("adminviewprofile")
	public String getProfile(HttpServletRequest request,Model m) {
		Service service=new Service(dao);
		List<Admin> adl=service.adminProfile(request);
		
		
		m.addAttribute("adminprofile", adl);
		return "adminviewprofile";
	}
}
