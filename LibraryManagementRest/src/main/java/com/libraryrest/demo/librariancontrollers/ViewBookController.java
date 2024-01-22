package com.libraryrest.demo.librariancontrollers;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryrest.demo.model.Book;
import com.libraryrest.demo.model.BookData;
import com.libraryrest.demo.service.LibrarianService;

@RestController
public class ViewBookController {
	@Autowired
	private LibrarianService ls;
	@GetMapping("viewBooks")
	public ResponseEntity<List<BookData>> getViewBooks() {
		List<Book> booklist=ls.viewBooks();
		List<BookData> booklist1=new ArrayList<BookData>();
		for(Book b:booklist) {
			BookData bd=new BookData();
			bd.setBookId(b.getBookId());
			bd.setBookName(b.getBookName());
			bd.setBookAuthor(b.getBookAuthor());
			bd.setBookPublisher(b.getBookPublisher());
			bd.setTotalQuantity(b.getBookQuantity()+b.getBookIssued());
			bd.setBookQuantity(b.getBookQuantity());
			bd.setBookIssued(b.getBookIssued());
			bd.setBookAddDate(b.getBookAddDate());
			bd.setLibrarianId(b.getLibrarian().getLibrarianId());
			booklist1.add(bd);
		}
		return new ResponseEntity<List<BookData>>(booklist1,HttpStatus.ACCEPTED);
	}
	
}
