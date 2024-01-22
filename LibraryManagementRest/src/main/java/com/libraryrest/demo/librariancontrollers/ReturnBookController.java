package com.libraryrest.demo.librariancontrollers;

import javax.servlet.http.HttpServletRequest;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libraryrest.demo.model.IssueBook;
import com.libraryrest.demo.service.LibrarianService;


@RestController
public class ReturnBookController {
	@Autowired
	private LibrarianService ls;

	@DeleteMapping("returnBookFormData")
	public ResponseEntity<String> getReturnBookFormData(HttpServletRequest request,@RequestParam("bid") String bid,@RequestParam("sid") String sid) {
		HttpSession session=request.getSession();
		String f=(String)session.getAttribute("first");
		if(f!=null) {
			if(ls.returnBook(bid,sid)) {
				return new ResponseEntity<String>("Book returned successfully!",HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<String>("Please enter valid credentials!",HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>("Kindly first check fine and then return",HttpStatus.NOT_ACCEPTABLE);
	}
	

	@GetMapping("checkFineFormData")
	public ResponseEntity<IssueBook> getCheckFineFormData(HttpServletRequest request,@RequestParam("bid") String bid,@RequestParam("sid") String sid,@RequestParam("rdate") String rdate) {
		IssueBook issueBook=ls.checkFine(bid,sid,rdate);
		if(ls.checkFine(bid,sid,rdate)!=null) {
			
			HttpSession session=request.getSession();
			session.setAttribute("first", "fine");
			return new ResponseEntity<IssueBook>(issueBook,HttpStatus.NOT_ACCEPTABLE);
		}
		return null;
	}
}
