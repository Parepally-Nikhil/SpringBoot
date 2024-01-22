package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminLoginController {
	@Autowired
	private Dao dao;
	@RequestMapping("adminlogin")
	public String getAdminLogin() {
		return "adminlogin";
	}
	
	@RequestMapping("adminloginform")
	public String getAdminLoginFormData(@RequestParam("adminName") String name,@RequestParam("adminPassword") String pwd,HttpServletRequest request) {
		Service service=new Service(dao);
		if(service.adminLogin(name,pwd)) {
			HttpSession session=request.getSession();
			session.setAttribute("user",name);
			return "adminhome";
		}
		return "failure";
	}
	
	
}
