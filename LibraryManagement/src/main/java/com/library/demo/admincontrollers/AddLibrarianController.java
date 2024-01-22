package com.library.demo.admincontrollers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.library.demo.model.Librarian;
import com.library.demo.service.AdminService;

@Controller
public class AddLibrarianController {
	@Autowired 
	private AdminService as;
	@RequestMapping("addLibrarian")
	public String getAdminLogin(Model m) {
		
		m.addAttribute("lib", new Librarian());
		
		return "addlib.jsp";
	}
	
	@RequestMapping("addLibrarianFormData")
	public String getLibrarianFormData(HttpServletRequest request,@Valid @ModelAttribute("lib") Librarian librarian,  BindingResult br)
    {
        if(br.hasErrors())
        {
            return "addlib.jsp";
        }
        else
        {
        	if(as.addLibrarian(request, librarian)) {
        		request.setAttribute("b", "2");
        		return "adminsection.jsp";
        	}
        	return "addlib.jsp";
        }
    }
}
