package com.example.demo.exception;

import java.util.NoSuchElementException;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException){
        return new ResponseEntity<String>("Requested product doesn't exist : ",HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInputExceptionException(EmptyInputException elementException){
        return new ResponseEntity<String>("Empty input exception"+elementException.getErrorCode()+" "+elementException.getErrorMessage(),HttpStatus.NOT_FOUND);
    
       //return new ResponseEntity<String>(elementException.toString(),HttpStatus.NOT_FOUND);
	}
}
