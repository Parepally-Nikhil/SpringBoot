package com.libraryrest.demo.admincontrollers;

import java.util.ArrayList;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryrest.demo.model.Librarian;
import com.libraryrest.demo.model.LibrarianData;
import com.libraryrest.demo.service.AdminService;


@RestController
public class ViewLibrarianController {
	@Autowired 
	private AdminService as;
	@GetMapping("viewLibrarian")
	public ResponseEntity<List<LibrarianData>> getViewLibrarian() {
		List<Librarian> librarianlist=as.viewLibrarian();
		List<LibrarianData> librarianlist1=new ArrayList<LibrarianData>();
		for(Librarian lib:librarianlist) {
			LibrarianData libd=new LibrarianData();
			libd.setLibrarianId(lib.getLibrarianId());
			libd.setLibrarianName(lib.getLibrarianName());
			libd.setLibrarianEmail(lib.getLibrarianEmail());
			libd.setLibrarianAddress(lib.getLibrarianAddress());
			libd.setLibrarianGender(lib.getLibrarianGender());
			libd.setLibrarianContactno(lib.getLibrarianContactno());
			librarianlist1.add(libd);
		}
		
		return new ResponseEntity<List<LibrarianData>>(librarianlist1,HttpStatus.ACCEPTED);
	}
}
