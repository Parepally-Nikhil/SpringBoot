package com.library.demo.exception;

public class DeleteLibrarianNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Wrong librarian id! try again";
	}
}
