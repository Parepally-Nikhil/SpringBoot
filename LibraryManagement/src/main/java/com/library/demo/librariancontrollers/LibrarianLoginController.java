package com.library.demo.librariancontrollers;

import javax.servlet.http.HttpServletRequest;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.library.demo.model.Librarian;
import com.library.demo.service.LibrarianService;


@Controller
public class LibrarianLoginController {
	@Autowired
	private LibrarianService ls;
	//Logger l=LoggerFactory.getLogger(LibrarianLoginController.class);
	@RequestMapping("librarianlogin")
	public String getAdminLogin() {
		return "librarianlogin.jsp";
	}
	
	@RequestMapping("librarianLoginFormData")
	public String getLibrarianLoginFormData(HttpServletRequest request,Librarian librarian) {
		if(ls.librarianLogin(librarian)) {
			HttpSession session=request.getSession();
			session.setAttribute("librarian", librarian.getLibrarianId());
			return "librariansection.jsp";
		}
		return "librarianlogin.jsp";
	}
}
