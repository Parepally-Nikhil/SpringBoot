package com.libraryrest.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class BookNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = -1053886567699465007L;
    private String errorCode;
    private String errorMessage;

 

    public String getErrorCode() {
        return errorCode;
    }

 

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

 

    public String getErrorMessage() {
        return errorMessage;
    }

 

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

 

    public BookNotFoundException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

 

    public BookNotFoundException() {
        super();
        // TODO Auto-generated constructor stub
    }

}