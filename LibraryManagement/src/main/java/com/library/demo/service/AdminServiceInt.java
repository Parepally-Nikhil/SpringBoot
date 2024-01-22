package com.library.demo.service;

import javax.servlet.http.HttpServletRequest;


import com.library.demo.model.Admin;
import com.library.demo.model.Librarian;

public interface AdminServiceInt {
	public boolean adminLogin(Admin admin);
	public boolean addLibrarian(HttpServletRequest request,Librarian librarian);
	public boolean deleteLibrarianById(Librarian librarian);
}
