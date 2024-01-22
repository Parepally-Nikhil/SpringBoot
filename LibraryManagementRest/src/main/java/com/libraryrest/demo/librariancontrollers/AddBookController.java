package com.libraryrest.demo.librariancontrollers;

import javax.servlet.http.HttpServletRequest;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libraryrest.demo.model.Book;
import com.libraryrest.demo.service.LibrarianService;


@RestController
public class AddBookController {
	@Autowired
	private LibrarianService ls;

	@PostMapping("addBooksFormData")
	public ResponseEntity<String> getAddBooksFormData(HttpServletRequest request,@Valid @RequestBody Book book)
    {
		if(book.getBookQuantity()<=0) {
			return new ResponseEntity<String>("Quantity cannot be lessthan or equal to zero",HttpStatus.NOT_ACCEPTABLE);
    	}
		if (ls.addBooks(request, book)) {
			
			return new ResponseEntity<String>("Books added successfully!",HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String>("please enter today date only",HttpStatus.NOT_ACCEPTABLE);
        
    }
}
