package com.library.demo.librariancontrollers;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.demo.model.Book;
import com.library.demo.service.LibrarianService;

@Controller
public class AddBookController {
	@Autowired
	private LibrarianService ls;
	@RequestMapping("addBooks")
	public String getAddBooks(Model m) {
		m.addAttribute("book", new Book());
		return "addbooks.jsp";
	}
	
	@RequestMapping("addBooksFormData")
	public String getAddBooksFormData(HttpServletRequest request,@Valid @ModelAttribute("book") Book book,BindingResult br)
    {
        if(br.hasErrors())
        {
            return "addbooks.jsp";
        }
        else
        {
        	if(book.getBookQuantity()<=0) {
        		request.setAttribute("q", "0");
        		return "addbooks.jsp";
        	}
        	if(ls.addBooks(request, book)) {
    			request.setAttribute("b","2");
    			return "librariansection.jsp";
    		}
    		request.setAttribute("date","d");
    		return "addbooks.jsp";
        }
    }
}
