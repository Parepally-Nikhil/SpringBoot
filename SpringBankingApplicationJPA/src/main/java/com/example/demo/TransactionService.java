package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TransactionService {
	TransactionDao tdao;
	CustDao cdao;
	TransactionService(){
		
	}
	TransactionService(TransactionDao tdao,CustDao cdao){
		this.tdao=tdao;
		this.cdao=cdao;
	}
	
	public int deposit(HttpServletRequest request,int amount) {
		HttpSession session=request.getSession();
		int uid=(Integer)session.getAttribute("userid");
		Customer cust=cdao.findById(uid).orElse(null);
		int abalance=cust.getAccountBalance();
		abalance=abalance+amount;
		cust.setAccountBalance(abalance);
		Transaction t=new Transaction();
		cust.getTransactions().add(t);
		t.setC(cust);
		cdao.save(cust);
		tdao.save(t);
		return abalance; 
	}
	
	public int withdraw(HttpServletRequest request,int amount) {
		HttpSession session=request.getSession();
		int uid=(Integer)session.getAttribute("userid");
		Customer cust=cdao.findById(uid).orElse(null);
		int abalance=cust.getAccountBalance();
		abalance=abalance-amount;
		cust.setAccountBalance(abalance);
		Transaction t=new Transaction();
		cust.getTransactions().add(t);
		t.setC(cust);
		cdao.save(cust);
		tdao.save(t);
		return abalance;
	}
}
