package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerPasswordController {
	@Autowired
	private CustDao cdao;
	@RequestMapping("changepassword")
	public String changePassword(HttpServletRequest request,@RequestParam("customerpassword") String pwd) {
		CustomerService cservice=new CustomerService(cdao);
		cservice.changePwd(request,pwd);
		request.setAttribute("b","2");
		return "customerlogin";
	}
}
