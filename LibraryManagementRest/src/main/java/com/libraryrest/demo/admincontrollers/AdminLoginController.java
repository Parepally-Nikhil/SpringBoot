package com.libraryrest.demo.admincontrollers;

import javax.servlet.http.HttpServletRequest;






import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.libraryrest.demo.model.Admin;
import com.libraryrest.demo.service.AdminService;



@RestController
public class AdminLoginController {
	@Autowired 
	private AdminService as;
	
	@GetMapping("adminLoginFormData")
	public ResponseEntity<String> getAdminLoginFormData(HttpServletRequest request,@RequestBody Admin admin) {
		if(as.adminLogin(admin)) {
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin.getAdminName());
			return new ResponseEntity<String>("admin logged in succssfully!",HttpStatus.ACCEPTED);
		}
		return null;
	}
}
