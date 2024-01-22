package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CustomerService {
	CustDao cdao;
	CustomerService(CustDao cdao){
		this.cdao=cdao;
	}
	
	public Customer customerSignUp(Customer cust) {
		
		Customer c=cdao.save(cust);
		return c;
	}

	public boolean customerLogin(int id,String pwd) {
		Customer customer=cdao.findById(id).orElse(null);
		
			if(customer.getCustomerPassword().equals(pwd)) {
				return true;
			}
		
		
		return false;
	}

	public void changePwd(HttpServletRequest request, String pwd) {
		HttpSession session=request.getSession();
		int id=(Integer)session.getAttribute("userid");
		Customer customer=cdao.findById(id).orElse(null);
		customer.setCustomerPassword(pwd);
		cdao.save(customer);
	}
}
