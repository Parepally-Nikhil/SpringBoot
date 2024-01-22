package com.library.demo.librariancontrollers;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.demo.model.IssueBook;
import com.library.demo.service.LibrarianService;

@Controller
public class IssueBookController {
	@Autowired
	private LibrarianService ls;
	@RequestMapping("issueBook")
	public String getIssueBook() {
		return "issuebook.jsp";
	}
	
	@RequestMapping("issueBookFormData")
	public String getIssueBookFormData(HttpServletRequest request,@RequestParam("bId") String bookId,@RequestParam("sId") String studentId,@RequestParam("iDate") Date issuedDate) {
		IssueBook ib=new IssueBook();
		ib.setIssuedDate(issuedDate);
		int available=ls.issueBook(request,bookId,studentId,ib);
		if(available==1) {
			request.setAttribute("e", "5");
			return "issuebook.jsp";
		}
		if(available==2) {
			request.setAttribute("f", "6");
			return "issuebook.jsp";
		}
		if(available==3) {
			request.setAttribute("g", "7");
			return "librariansection.jsp";
		}
		if(available==4) {
			request.setAttribute("h", "8");
			return "issuebook.jsp";
		}
		if(available==5) {
			request.setAttribute("date", "d");
			return "issuebook.jsp";
		}
		if(available==6) {
			request.setAttribute("notallowed", "true");
			return "issuebook.jsp";
		}
		return "issuebook.jsp";
	}
	
}
