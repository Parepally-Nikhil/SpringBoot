package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerLoginController {
	@Autowired
	private CustDao cdao;
	@RequestMapping("customerlogin")
	public String getCustomerLogin() {
		return "customerlogin";
	}
	
	@RequestMapping("customerloginform")
	public String getAdminLoginFormData(@RequestParam("customerId") int id,@RequestParam("customerPassword") String pwd,HttpServletRequest request) {
		CustomerService cservice=new CustomerService(cdao);
		if(cservice.customerLogin(id,pwd)) {
			HttpSession session=request.getSession();
			session.setAttribute("userid",id);
			return "customerhome2";
		}
		return "failure";
	}
}