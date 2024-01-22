package com.libraryrest.demo.librariancontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libraryrest.demo.model.IssueBook;
import com.libraryrest.demo.service.LibrarianService;


@RestController
public class IssueBookController {
	@Autowired
	private LibrarianService ls;
	
	@PostMapping("issueBookFormData")
	public ResponseEntity<String> getIssueBookFormData(HttpServletRequest request,@RequestParam("bId") String bookId,@RequestParam("sId") String studentId,@RequestParam("iDate") String issuedDate) {
		IssueBook ib=new IssueBook();
		ib.setIssuedDate(issuedDate);

		int available=ls.issueBook(request,bookId,studentId,ib);
		if(available==1) {
			return new ResponseEntity<String>("Book does not exist in the library!",HttpStatus.NOT_ACCEPTABLE);
		}
		if(available==2) {
			return new ResponseEntity<String>("Please enter valid studentId!",HttpStatus.NOT_ACCEPTABLE);
		}
		if(available==3) {
			return new ResponseEntity<String>("Book issued successfully!",HttpStatus.ACCEPTED);
		}
		if(available==4) {
			return new ResponseEntity<String>("Sorry! unable to issue book the QUANTITY is 0",HttpStatus.NOT_ACCEPTABLE);
		}
		if(available==5) {
			return new ResponseEntity<String>("Please enter the requested date format yyyy-mm-dd and it should be today date",HttpStatus.NOT_ACCEPTABLE);
		}
		if(available==6) {
			return new ResponseEntity<String>("book already taken by the entered studentid",HttpStatus.NOT_ACCEPTABLE);
		}
		return null;
	}
	
}
