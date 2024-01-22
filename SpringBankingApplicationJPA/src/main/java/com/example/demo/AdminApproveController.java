package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminApproveController {
	@Autowired
	CustDao cdao;
	@RequestMapping("adminapprove")
	public String getApprover(Model m) {
		Service service=new Service(cdao);
		List<Customer> custl=service.getApprovers();
		m.addAttribute("approvers", custl);
		return "adminshow";
	}
	
	@RequestMapping("approvecustomers")
	public String approveCustomers(HttpServletRequest req) {
		Service service=new Service(cdao);
		service.approveCustomers();
		req.setAttribute("a","1");
		return "adminhome";
	}
}
