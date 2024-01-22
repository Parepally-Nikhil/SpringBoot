package com.libraryrest.demo.librariancontrollers;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.libraryrest.demo.exception.BookNotFoundException;
import com.libraryrest.demo.model.Book;
import com.libraryrest.demo.service.LibrarianService;

@RestController
public class DeleteBookController {
	@Autowired
	private LibrarianService ls;
	
	@DeleteMapping("deleteBookFormData/{bookId}")
	public ResponseEntity<String> getDeleteBookFormData(HttpServletRequest request,@PathVariable("bookId") String bookId) {
		Book book=new Book();
		book.setBookId(bookId);
		int check=ls.deleteBookById(request,book);
		if(check==1) {
			return new ResponseEntity<String>("Book deleted successfully!",HttpStatus.ACCEPTED);
		}
		
		if(check==2) {
			
			return new ResponseEntity<String>("Sorry! book added librarian can only delete the book",HttpStatus.NOT_ACCEPTABLE);
		}
		
		
		if(check==3) {
			
			return new ResponseEntity<String>("Sorry!cannot delete the book as it is issued to some student",HttpStatus.NOT_ACCEPTABLE);
		}
		
		throw new BookNotFoundException("406 ","Wrong book id! try again");
		
	}
}
