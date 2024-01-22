package com.library.demo.librariancontrollers;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.library.demo.model.IssueBook;
import com.library.demo.service.LibrarianService;

@Controller
public class ReturnBookController {
	@Autowired
	private LibrarianService ls;
	@RequestMapping("returnBook")
	public String getReturnBook() {
		return "returnbook.jsp";
	}
	
	@RequestMapping("returnBookFormData")
	public String getReturnBookFormData(HttpServletRequest request,@RequestParam("bid") String bid,@RequestParam("sid") String sid) {
		HttpSession session=request.getSession();
		String f=(String)session.getAttribute("first");
		if(f!=null) {
			if(ls.returnBook(bid,sid)) {
				request.setAttribute("j", "9");
				return "librariansection.jsp";
			}
			request.setAttribute("k", "10");
			return "returnbook.jsp";
		}
		request.setAttribute("go", "check");
		return "returnbook.jsp";
	}
	
	@RequestMapping("checkFine")
	public String getCheckFine() {
		return "checkfine.jsp";
	}
	
	@RequestMapping("checkFineFormData")
	public String getCheckFineFormData(HttpServletRequest request,@RequestParam("bid") String bid,@RequestParam("sid") String sid,@RequestParam("rdate") String rdate,Model m) {
		IssueBook issueBook=ls.checkFine(bid,sid,rdate);
		if(ls.checkFine(bid,sid,rdate)!=null) {
			m.addAttribute("issueBook",issueBook);
			//request.setAttribute("j", "9");
			HttpSession session=request.getSession();
			session.setAttribute("first", "fine");
			return "checkfine.jsp";
		}
		request.setAttribute("k", "10");
		return "returnbook.jsp";
	}
}
