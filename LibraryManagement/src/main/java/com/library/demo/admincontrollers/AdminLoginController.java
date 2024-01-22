package com.library.demo.admincontrollers;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.demo.model.Admin;
import com.library.demo.service.AdminService;

@Controller
public class AdminLoginController {
	@Autowired 
	private AdminService as;
	
	@RequestMapping("adminLogin")
	public String getAdminLogin() {
		return "adminlogin.jsp";
	}
	
	@RequestMapping("adminLoginFormData")
	public String getAdminLoginFormData(HttpServletRequest request,Admin admin) {
		if(as.adminLogin(admin)) {
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin.getAdminName());
			return "adminsection.jsp";
		}
		
		return "adminlogin.jsp";
	}
}
