package com.libraryrest.demo.librariancontrollers;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.libraryrest.demo.model.Librarian;
import com.libraryrest.demo.service.LibrarianService;



@Controller
public class LibrarianLoginController {
	@Autowired
	private LibrarianService ls;
	
	@GetMapping("librarianLoginFormData")
	public ResponseEntity<String> getLibrarianLoginFormData(HttpServletRequest request,@RequestBody Librarian librarian) {
		if(ls.librarianLogin(librarian)) {
			HttpSession session=request.getSession();
			session.setAttribute("librarian", librarian.getLibrarianId());
			return new ResponseEntity<String>("Librarian logged in succssfully!",HttpStatus.ACCEPTED);
		}

		return null;
	}
}
