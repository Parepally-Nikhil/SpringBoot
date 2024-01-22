package com.library.demo.admincontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.demo.model.Librarian;
import com.library.demo.service.AdminService;

@Controller
public class ViewLibrarianController {
	@Autowired 
	private AdminService as;
	@RequestMapping("viewLibrarian")
	public String getViewLibrarian(Model m) {
		List<Librarian> librarianlist=as.viewLibrarian();
		m.addAttribute("viewlib", librarianlist);
		return "viewlib.jsp";
	}
}
