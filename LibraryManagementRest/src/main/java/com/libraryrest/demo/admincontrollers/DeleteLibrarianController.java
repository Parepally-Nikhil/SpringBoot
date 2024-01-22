package com.libraryrest.demo.admincontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.libraryrest.demo.model.Librarian;
import com.libraryrest.demo.service.AdminService;

@RestController
public class DeleteLibrarianController {
	@Autowired 
	private AdminService as;
	
	@DeleteMapping("deleteLibrarianFormData")
	public ResponseEntity<String> getDeleteLibrarianFormData(HttpServletRequest request,@RequestBody Librarian librarian) {
		
		
		if(as.deleteLibrarianById(librarian)) {

			return new ResponseEntity<String>("Librarian deleted succssfully!",HttpStatus.ACCEPTED);
		}
		return null;

	}
}
