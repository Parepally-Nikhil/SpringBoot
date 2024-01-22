package com.library.demo.admincontrollers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.demo.model.Librarian;
import com.library.demo.service.AdminService;

@Controller
public class DeleteLibrarianController {
	@Autowired 
	private AdminService as;
	
	@RequestMapping("deleteLibrarian")
	public String getDeleteLibrarian() {
		return "dellib.jsp";
	}
	
	@RequestMapping("deleteLibrarianFormData")
	public String getDeleteLibrarianFormData(HttpServletRequest request,Librarian librarian) {
		
		
		if(as.deleteLibrarianById(librarian)) {
			request.setAttribute("c", "3");
			return "adminsection.jsp";
		}

		return "dellib.jsp";

	}
}
