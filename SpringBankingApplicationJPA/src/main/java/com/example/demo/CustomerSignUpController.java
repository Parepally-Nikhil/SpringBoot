package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerSignUpController {
	@Autowired
	private CustDao cdao;
	@RequestMapping("customersignup")
	public String getCustomerSignUp() {
		return "customersignup";
	}
	
	@RequestMapping("customersignupform")
	public String getCustomerSignUpFormData(Customer cust,Model m) {
		CustomerService cservice=new CustomerService(cdao);
		Customer c=cservice.customerSignUp(cust);
		m.addAttribute("customer", c);
		return "customerhome";
	}
}