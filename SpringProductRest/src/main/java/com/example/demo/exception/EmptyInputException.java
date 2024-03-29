package com.example.demo.exception;

import org.springframework.stereotype.Component;

@Component //Not Mandatory
public class EmptyInputException extends RuntimeException {
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

 

    public EmptyInputException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

 

    public EmptyInputException() {
        super();
        // TODO Auto-generated constructor stub
    }

//	public String toString() {
//		return "Empty input exception1";
//	}

}
