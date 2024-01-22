package com.libraryrest.demo.librariancontrollers;

import java.util.ArrayList;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryrest.demo.model.IssueBook;
import com.libraryrest.demo.model.IssueBookData;
import com.libraryrest.demo.service.LibrarianService;

@RestController
public class ViewIssuedBookController {
	@Autowired
	private LibrarianService ls;
	@GetMapping("viewIssuedBooks")
	public ResponseEntity<List<IssueBookData>> getViewIssuedBooks() {
		List<IssueBook> issuebooklist=ls.viewIssuedBooks();
		List<IssueBookData> issuebooklist1=new ArrayList<IssueBookData>();
		
		for(IssueBook ib:issuebooklist) {
			IssueBookData ibd=new IssueBookData();
			ibd.setId(ib.getId());
			ibd.setBookId(ib.getBook().getBookId());
			ibd.setStudentId(ib.getStudent().getStudentId());
			ibd.setStudentName(ib.getStudent().getStudentName());
			ibd.setStudentContact(ib.getStudent().getStudentContact());
			ibd.setIssuedDate(ib.getIssuedDate());
			ibd.setDueDate(ib.getDueDate());
			ibd.setLibrarianId(ib.getLibrarian().getLibrarianId());
			issuebooklist1.add(ibd);
		}
		return new ResponseEntity<List<IssueBookData>>(issuebooklist1,HttpStatus.ACCEPTED);
	}
}
