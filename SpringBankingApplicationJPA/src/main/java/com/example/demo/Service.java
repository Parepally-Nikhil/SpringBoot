package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@org.springframework.stereotype.Service

public class Service {
	
	Dao dao;
	CustDao cdao;
	Service(){
		
	}
	Service(Dao dao){
		this.dao=dao;
	}
	
	Service(CustDao cdao){
		this.cdao=cdao;
	}
	static int i=40;
	public boolean adminLogin(String name,String pwd) {
		List<Admin> ad1=dao.findByAdminName(name);
		for(Admin admin:ad1) {
			if(admin.getAdminName().equals(name) && admin.getAdminPassword().equals(pwd)) {
				return true;
			}
		}
		return false;
	}
	public List<Admin> adminProfile(HttpServletRequest request) {
		String name=(String)request.getSession().getAttribute("user");
		
		List<Admin> adl=dao.findByAdminName(name);
		
		
		return adl;
	}

	public List<Customer> getApprovers() {
		List<Customer> cl=cdao.findByCustomerPassword(null);
		//List<Customer> cl=cdao.findByCustomerName("shiva");
		return cl;
	}
	
	public void approveCustomers() {
		List<Customer> cl=cdao.findByCustomerPassword(null);
		
		for(Customer c:cl) {
			c.setCustomerPassword("1aCFG"+i);
			cdao.save(c);
			i++;
			System.out.println("Username:"+c.getCustomerName());
			System.out.println("Password:"+c.getCustomerPassword());
		}
		
	}
	
}
