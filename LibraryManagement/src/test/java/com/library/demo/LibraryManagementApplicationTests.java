package com.library.demo;

import static org.assertj.core.api.Assertions.assertThat;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.library.demo.dao.AdminDao;
import com.library.demo.dao.BookDao;
import com.library.demo.dao.IssueBookDao;
import com.library.demo.dao.LibrarianDao;
import com.library.demo.model.Admin;
import com.library.demo.model.Book;
import com.library.demo.model.Librarian;
import com.library.demo.service.AdminService;
import com.library.demo.service.LibrarianService;
import com.library.demo.model.IssueBook;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class LibraryManagementApplicationTests {
	
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
		Librarian lib=ld.findById("Lib_0018").get();
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
		String date="2022-10-10";						 //Add Book
		Date d=Date.valueOf(date);
		b.setBookAddDate(d);
		b.setLibrarian(lib);
		b.getLibrarian().setLibrarianId("Lib_0002");
		bd.save(b);
		assertNotNull(bd.findById(b.getBookId()).get());
	}
		
	@Test
	@Order(5)
	public void testDeleteBook() {
		bd.deleteById("Book_0006");							//Delete Book
		assertThat(bd.existsById("Book_0006")).isFalse();
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
		IssueBook ibook=ls.checkFine("Book_0022","Stud_0002","2022-11-30");
		assertNotEquals(ibook.getFine(),0.0);	
	}
	
	@Test
	@Order(8)
	public void testReturnBook() {								//Return Book
		boolean result=ls.returnBook("Book_0006", "Stud_0001");
		assertEquals(true,result);
	}
	
}

