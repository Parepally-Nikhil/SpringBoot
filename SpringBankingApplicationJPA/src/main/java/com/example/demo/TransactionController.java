package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {
	@Autowired
	private TransactionDao tdao;
	@Autowired
	private CustDao cdao;
	@RequestMapping("deposit")
	public String deposit() {
		return "deposit";
	}
	
	@RequestMapping("depositm")
	public String depositAmount(HttpServletRequest request,@RequestParam("da")int amount,Model m) {
		
		TransactionService ts=new TransactionService(tdao,cdao);
		
		int b=ts.deposit(request,amount);
		m.addAttribute("bal",b );
		return "depositmsg";
	}
	
	@RequestMapping("withdraw")
	public String witdraw() {
		return "withdraw";
	}
	
	@RequestMapping("withdrawm")
	public String withdrawAmount(HttpServletRequest request,@RequestParam("wa")int amount,Model m) {
		
		TransactionService ts=new TransactionService(tdao,cdao);
		
		int b=ts.withdraw(request,amount);
		m.addAttribute("bal",b );
		return "withdrawmsg";
	}
}
