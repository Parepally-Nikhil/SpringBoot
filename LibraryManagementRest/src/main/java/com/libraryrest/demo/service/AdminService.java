package com.libraryrest.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.libraryrest.demo.dao.AdminDao;
import com.libraryrest.demo.dao.LibrarianDao;
import com.libraryrest.demo.exception.AdminNotFoundException;
import com.libraryrest.demo.exception.DeleteLibrarianNotFoundException;
import com.libraryrest.demo.model.Admin;
import com.libraryrest.demo.model.Librarian;


@Service
public class AdminService implements AdminServiceInt{
	@Autowired
	private AdminDao adao;
	@Autowired
	private LibrarianDao ldao;
	public boolean adminLogin(Admin admin) {
		
		Admin ad=adao.findByAdminName(admin.getAdminName());
		if(ad!=null) {
			if(admin.getAdminPassword().equals(ad.getAdminPassword())) {
				return true;
			}
		}
		throw new AdminNotFoundException("406 ","Wrong admin credentials! try again");
		//return false;
	}
	
	public boolean addLibrarian(HttpServletRequest request,Librarian librarian) {
	
		HttpSession session=request.getSession();
		String aname=(String)session.getAttribute("admin");
		Admin admin=adao.findByAdminName(aname);
		admin.getLibrarians().add(librarian);
		librarian.setAdmin(admin);
		adao.save(admin);
		ldao.save(librarian);
		return true;
	}
	
	public List<Librarian> viewLibrarian(){
		return ldao.findAll();
	}
	
	public boolean deleteLibrarianById(Librarian librarian) {
		
		Librarian lib=ldao.findById(librarian.getLibrarianId()).orElse(null);
		 if(lib!=null) {
			 ldao.delete(lib);
			 return true;
		 }
		 throw new DeleteLibrarianNotFoundException("406 ","Wrong librarian id! try again");
	}
}
