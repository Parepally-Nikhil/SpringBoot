package com.libraryrest.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.libraryrest.demo.model.Admin;
import com.libraryrest.demo.model.Librarian;
import com.libraryrest.demo.model.Book;
import com.libraryrest.demo.model.IssueBook;
import com.libraryrest.demo.dao.AdminDao;
import com.libraryrest.demo.dao.BookDao;
import com.libraryrest.demo.dao.IssueBookDao;
import com.libraryrest.demo.dao.LibrarianDao;
import com.libraryrest.demo.service.AdminService;
import com.libraryrest.demo.service.LibrarianService;

@SpringBootTest
class LibraryManagementRestApplicationTests {
	
	@Autowired
	AdminDao ad;
	
	@Autowired
	LibrarianDao ld;
	
	@Autowired
	BookDao bd;
	
	@Autowired
	IssueBookDao id;

	@Autowired
	AdminService as;
	
	@Autowired
	LibrarianService ls;
	
	@Test
	@Order(1)
	public void testAddLibrarian() {
		Librarian lib=new Librarian();
		Admin adm=new Admin();
		lib.setLibrarianName("Chay");
		lib.setLibrarianPassword("Chay@1234");
		lib.setLibrarianEmail("chay123@gmail.com");			//Add Librarian
		lib.setLibrarianAddress("Hyderabad");
		lib.setLibrarianGender("Male");
		lib.setLibrarianContactno("9182379142");
		lib.setAdmin(adm);
		lib.getAdmin().setAdminId("adm001");
		ld.save(lib);
		assertNotNull(ld.findById(lib.getLibrarianId()).get());
	}
	
	@Test
	@Order(2)
	public void testDeleteLibrarian() {
		Librarian lib=ld.findById("Lib_0003").get();
		as.deleteLibrarianById(lib);					//Delete Librarian 										
        assertThat(ld.existsById(lib.getLibrarianId())).isFalse();
    }

	@Test
	@Order(3)
	public void testViewLibrarians() {					
        List<Librarian> librarians = ld.findAll();			//View Librarian
        assertThat(librarians).size().isGreaterThan(0);
    }
	
	@Test
	@Order(4)
	public void testAddBook() {
		Book b=new Book();
		Librarian lib=new Librarian();
		b.setBookName("Hitler");
		b.setBookAuthor("Chiranjeevi");
		b.setBookPublisher("rajamouli");
		b.setBookQuantity(1);
								 				//Add Book
		b.setBookAddDate("2022-10-16");
		b.setLibrarian(lib);
		b.getLibrarian().setLibrarianId("Lib_0001");
		bd.save(b);
		assertNotNull(bd.findById(b.getBookId()).get());
	}
	
	@Test
	@Order(5)
	public void testDeleteBook() {
		bd.deleteById("Book_0007");					//Delete Book
		assertThat(bd.existsById("Book_0007")).isFalse();
    }
	
	@Test
	@Order(6)
	public void testViewBooks() {					
        List<Book> books = bd.findByBookNameSorted();			//View Books
        assertThat(books).size().isGreaterThan(0);
    }
	
	@Test
	@Order(7)
	public void testCheckFine() {					//Check Fine
		IssueBook ibook=ls.checkFine("Book_0002", "Stud_0002","2022-11-01");
		assertNotEquals(ibook.getFine(),0.0);	
	}
	
	@Test
	@Order(8)
	public void testReturnBook() {					//Return Book
		boolean result=ls.returnBook("Book_0003", "Stud_0002");
		assertEquals(true,result);
	}
}
