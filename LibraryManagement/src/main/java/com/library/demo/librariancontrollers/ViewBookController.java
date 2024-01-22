package com.library.demo.librariancontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.demo.model.Book;
import com.library.demo.service.LibrarianService;

@Controller
public class ViewBookController {
	@Autowired
	private LibrarianService ls;
	@RequestMapping("viewBooks")
	public String getViewBooks(Model m) {
		List<Book> booklist=ls.viewBooks();
		m.addAttribute("viewbooks", booklist);
		return "viewbooks.jsp";
	}
	
}
