package com.libraryrest.demo.admincontrollers;

import javax.servlet.http.HttpServletRequest;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.libraryrest.demo.model.Librarian;
import com.libraryrest.demo.service.AdminService;



@RestController
public class AddLibrarianController {
	@Autowired 
	private AdminService as;
	
	@PostMapping("addLibrarianFormData")
	public ResponseEntity<String> getLibrarianFormData(HttpServletRequest request,@Valid @RequestBody Librarian librarian)
    {
        	if(as.addLibrarian(request, librarian)) {
        		
        		return new ResponseEntity<String>("Librarian added successfully!",HttpStatus.CREATED);
        	}
        	return null;
        
    }
}
