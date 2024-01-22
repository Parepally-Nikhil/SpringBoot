package com.library.demo.exception;

public class BookNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Wrong book id! try again";
	}
}
