package com.library.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class LibrarianNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Wrong librarian credentials! try again";
	}
}
