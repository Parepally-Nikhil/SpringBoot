package com.library.demo.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.library.demo.admincontrollers.AdminLoginController;
import com.library.demo.admincontrollers.DeleteLibrarianController;
import com.library.demo.librariancontrollers.DeleteBookController;
import com.library.demo.librariancontrollers.LibrarianLoginController;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	Logger logger1=LoggerFactory.getLogger(AdminLoginController.class);
	Logger logger2=LoggerFactory.getLogger(DeleteLibrarianController.class);
	Logger logger3=LoggerFactory.getLogger(LibrarianLoginController.class);
	Logger logger4=LoggerFactory.getLogger(DeleteBookController.class);
	
	@ExceptionHandler(AdminNotFoundException.class)
    public String handleAdminNotFoundException(HttpServletRequest request,AdminNotFoundException aexception){
		
		String msg=aexception.toString();
		request.setAttribute("a",msg);
		logger1.error("AdminNotFoundException:"+msg);
		return "adminlogin.jsp";
	}
	
	@ExceptionHandler(DeleteLibrarianNotFoundException.class)
    public String handleDeleteLibrarianNotFoundException(HttpServletRequest request,DeleteLibrarianNotFoundException dlexception){
		HttpSession session=request.getSession();
		String aname=(String) session.getAttribute("admin");
		
		String msg=dlexception.toString();		
		request.setAttribute("d",msg);
		logger2.error("Admin Name:"+aname+" DeleteLibrarianNotFoundException:"+msg);
		return "dellib.jsp";
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String handleSQLIntegrityConstraintViolationException(HttpServletRequest request,SQLIntegrityConstraintViolationException sicvexception){
		HttpSession session=request.getSession();
		String aname=(String) session.getAttribute("admin");
		request.setAttribute("ex","exception");
		logger2.error("Admin Name:"+aname+" "+sicvexception);
		return "dellib.jsp";
	}
	
	@ExceptionHandler(LibrarianNotFoundException.class)
    public String handleLibrarianNotFoundException(HttpServletRequest request,LibrarianNotFoundException lexception){
       
		String msg=lexception.toString();		
		request.setAttribute("a",msg);
		logger3.error("LibrarianNotFoundException:"+msg);
		return "librarianlogin.jsp";
	}
	
	@ExceptionHandler(BookNotFoundException.class)
    public String handleBookNotFoundException(HttpServletRequest request,BookNotFoundException bexception){
		HttpSession session=request.getSession();
		String libid=(String) session.getAttribute("librarian");
		String msg=bexception.toString();
		request.setAttribute("d",msg);
		logger4.error("Librarian Id:"+libid+" BookNotFoundException:"+msg);
		return "delbook.jsp";
	}
	

}
