package com.libraryrest.demo.service;

import javax.servlet.http.HttpServletRequest;

import com.libraryrest.demo.model.Admin;
import com.libraryrest.demo.model.Librarian;

public interface AdminServiceInt {
	public boolean adminLogin(Admin admin);
	public boolean addLibrarian(HttpServletRequest request,Librarian librarian);
	public boolean deleteLibrarianById(Librarian librarian);
}
