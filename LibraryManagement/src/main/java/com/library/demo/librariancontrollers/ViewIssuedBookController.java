package com.library.demo.librariancontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.demo.model.IssueBook;
import com.library.demo.service.LibrarianService;

@Controller
public class ViewIssuedBookController {
	@Autowired
	private LibrarianService ls;
	@RequestMapping("viewIssuedBooks")
	public String getViewIssuedBooks(Model m) {
		List<IssueBook> issuebooklist=ls.viewIssuedBooks();
		m.addAttribute("viewissuedbooks", issuebooklist);
		return "viewissuedbooks.jsp";
	}
}
