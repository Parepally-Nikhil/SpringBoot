package com.libraryrest.demo.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.libraryrest.demo.admincontrollers.AdminLoginController;
import com.libraryrest.demo.admincontrollers.DeleteLibrarianController;
import com.libraryrest.demo.librariancontrollers.DeleteBookController;
import com.libraryrest.demo.librariancontrollers.LibrarianLoginController;
import com.libraryrest.demo.librariancontrollers.ReturnBookController;

@ControllerAdvice
public class GlobalExceptionHandler {
	Logger logger1=LoggerFactory.getLogger(AdminLoginController.class);
	Logger logger2=LoggerFactory.getLogger(DeleteLibrarianController.class);
	Logger logger3=LoggerFactory.getLogger(LibrarianLoginController.class);
	Logger logger4=LoggerFactory.getLogger(DeleteBookController.class);
	Logger logger5=LoggerFactory.getLogger(ReturnBookController.class);
	
	@ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<String> handleAdminNotFoundException(HttpServletRequest request,AdminNotFoundException aexception){
	
		logger1.error("AdminNotFoundException:"+aexception.getErrorMessage());
		return new ResponseEntity<String>("AdminNotFoundException:"+aexception.getErrorCode()+aexception.getErrorMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(DeleteLibrarianNotFoundException.class)
    public ResponseEntity<String> handleDeleteLibrarianNotFoundException(HttpServletRequest request,DeleteLibrarianNotFoundException dexception){
		HttpSession session=request.getSession();
		String aname=(String) session.getAttribute("admin");
		logger2.error("Admin Name:"+aname+" DeleteLibrarianNotFoundException:"+dexception.getErrorMessage());
		return new ResponseEntity<String>("DeleteLibrarianNotFoundException:"+dexception.getErrorCode()+dexception.getErrorMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> handleSQLIntegrityConstraintViolationException(HttpServletRequest request,SQLIntegrityConstraintViolationException sicvexception){
		HttpSession session=request.getSession();
		String aname=(String) session.getAttribute("admin");
		logger2.error("Admin Name:"+aname+" "+sicvexception);
		return new ResponseEntity<String>("SQLIntegrityConstraintViolationException:Sorry! cannot delete librarian as he issued some books to students",HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(LibrarianNotFoundException.class)
    public ResponseEntity<String> handleLibrarianNotFoundException(HttpServletRequest request,LibrarianNotFoundException lexception){
		logger3.error("LibrarianNotFoundException:"+lexception.getErrorMessage());
		return new ResponseEntity<String>("LibrarianNotFoundException:"+lexception.getErrorCode()+lexception.getErrorMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(HttpServletRequest request,BookNotFoundException bexception){
		HttpSession session=request.getSession();
		String libid=(String) session.getAttribute("librarian");
		logger4.error("Librarian Id:"+libid+" BookNotFoundException:"+bexception.getErrorMessage());
       	return new ResponseEntity<String>("BookNotFoundException:"+bexception.getErrorCode()+bexception.getErrorMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<String> handleInvalidDataException(HttpServletRequest request,InvalidDataException iexception){
		HttpSession session=request.getSession();
		String libid=(String) session.getAttribute("librarian");
		logger5.error("Librarian Id:"+libid+" InvalidDataException:"+iexception.getErrorMessage());
       	return new ResponseEntity<String>("InvalidDataException:"+iexception.getErrorCode()+iexception.getErrorMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
}
