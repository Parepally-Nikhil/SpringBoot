package com.library.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class AdminNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		return "Wrong admin credentials! try again";
	}
}
