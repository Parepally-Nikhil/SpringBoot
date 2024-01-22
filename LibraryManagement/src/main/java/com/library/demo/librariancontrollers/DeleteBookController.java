package com.library.demo.librariancontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.demo.exception.BookNotFoundException;
import com.library.demo.model.Book;
import com.library.demo.service.LibrarianService;

@Controller
public class DeleteBookController {
	@Autowired
	private LibrarianService ls;
	//Logger l=LoggerFactory.getLogger(DeleteBookController.class);
	@RequestMapping("deleteBook")
	public String getDeleteBook() {
		return "delbook.jsp";
	}
	
	@RequestMapping("deleteBookFormData")
	public String getDeleteBookFormData(HttpServletRequest request,Book book) {
		int check=ls.deleteBookById(request,book);
		if(check==1) {
			request.setAttribute("c", "3");
			return "librariansection.jsp";
		}
		
		if(check==2) {
			request.setAttribute("m", "9");
			return "delbook.jsp";
		}
		
		
		if(check==3) {
			request.setAttribute("ex", "10");
			return "delbook.jsp";
		}
		
		throw new BookNotFoundException();
		//request.setAttribute("d", "4");
		//return "delbook.jsp";
	}
}
