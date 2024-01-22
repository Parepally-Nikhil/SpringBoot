package com.library.demo.service;

import java.text.DateFormat;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.demo.dao.BookDao;
import com.library.demo.dao.IssueBookDao;
import com.library.demo.dao.LibrarianDao;
import com.library.demo.dao.StudentDao;
import com.library.demo.exception.LibrarianNotFoundException;
import com.library.demo.model.Book;
import com.library.demo.model.IssueBook;
import com.library.demo.model.Librarian;
import com.library.demo.model.Student;

@Service
public class LibrarianService implements LibrarianServiceInt{
	@Autowired
	private LibrarianDao ldao;
	@Autowired
	private BookDao bdao;
	
	@Autowired
	private StudentDao sdao;
	@Autowired
	private IssueBookDao idao;
	public boolean librarianLogin(Librarian librarian) {
		Librarian lib=ldao.findById(librarian.getLibrarianId()).orElse(null);
		if(lib!=null) {
			if(librarian.getLibrarianPassword().equals(lib.getLibrarianPassword())) {
				return true;
			}
		}
		throw new LibrarianNotFoundException();
		//return false;
	}
	
	public boolean addBooks(HttpServletRequest request,Book book) {
		
		HttpSession session=request.getSession();
		String libid=(String) session.getAttribute("librarian");
	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String d1[]=dateFormat.format(date).split("-");
		String d[]=book.getBookAddDate().toString().split("-");
		if(!(d1[0].equals(d[0]) && d1[1].equals(d[1]) && d1[2].equals(d[2]))) {
			return false;
		}
		Librarian lib=ldao.findById(libid).get();
		lib.getBooks().add(book);
		book.setLibrarian(lib);
		ldao.save(lib);
		bdao.save(book);
		return true;
	}
	
	public List<Book> viewBooks(){
		//return bdao.findAll();
		
		return bdao.findByBookNameSorted();
	}
	
	public int deleteBookById(HttpServletRequest request,Book book) {
				
		int check=0;
		try {
		
		Book b=bdao.findById(book.getBookId()).orElse(null);
		HttpSession session=request.getSession();
		String libid=(String) session.getAttribute("librarian");
		
		if(b!=null) {
			if(b.getLibrarian().getLibrarianId().equals(libid)) {
				check=1;
				bdao.delete(b);
				return check;
			}		
			else {
				check=2;
				return check;
			}
		}
		}
		catch(Exception e) {
			return check=3;
		}
		return check;
	}
	
	public int issueBook(HttpServletRequest request,String bookId,String studentId,IssueBook ib) {
		int available=0;
		List<IssueBook> issueBooks=idao.findAll();
		for(IssueBook ibook:issueBooks) {
			if(bookId.equals(ibook.getBook().getBookId()) && studentId.equals(ibook.getStudent().getStudentId())) {
				available=6;
				return available;
			}
		}
		
		HttpSession session=request.getSession();
		String libid=(String) session.getAttribute("librarian");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String now=dateFormat.format(date);
		String d1[]=now.split("-");//10-10-2022
		String d[]=ib.getIssuedDate().toString().split("-");//10-10-2022
		if(!(d1[0].equals(d[0]) && d1[1].equals(d[1]) && d1[2].equals(d[2]))) {
			available=5;
			return available;
		}
		
		
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(dateFormat.parse(now));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(Calendar.DATE, 15);
		String duedate = dateFormat.format(c.getTime());	
		ib.setDueDate(duedate);
		Librarian lib=ldao.findById(libid).get();
		lib.getIssueBooks().add(ib);
		ib.setLibrarian(lib);
		Book b=bdao.findById(bookId).orElse(null);
		Student s=sdao.findById(studentId).orElse(null);
		if(b==null) {
			available=1;
			return available;
		}
		if(s==null) {
			available=2;
			return available;
		}
		if(b!=null && s!=null) {
			available=3;
			
			if(b.getBookQuantity()>=1) {
				b.getIssueBooks().add(ib);
				int q=b.getBookQuantity();
				q--;
				b.setBookQuantity(q);
				int i=b.getBookIssued();
				i++;
				b.setBookIssued(i);
				ib.setBook(b);
				
				s.getIssueBooks().add(ib);
				ib.setStudent(s);
				
				ldao.save(lib);
				bdao.save(b);
				idao.save(ib);
			}
			else {
				available=4;
				return available;
			}
		}
		return available;
	}
	
	public List<IssueBook> viewIssuedBooks() {
		return idao.findAll();
	}
	
	public boolean returnBook(String bid,String sid) {
		List<IssueBook> ibl=idao.findAll();
		for(IssueBook ib:ibl) {
			if(ib.getBook().getBookId().equals(bid) && ib.getStudent().getStudentId().equals(sid)) {
				idao.delete(ib);
				Book b=bdao.findById(bid).orElse(null);
				int q=b.getBookQuantity();
				q++;
				b.setBookQuantity(q);
				int i=b.getBookIssued();
				i--;
				b.setBookIssued(i);
				bdao.save(b);
				return true;
			}
		}
		return false;
	}
	
	public IssueBook checkFine(String bid,String sid,String rdate) {
		List<IssueBook> ibl=idao.findAll();
		for(IssueBook ib:ibl) {
			if(ib.getBook().getBookId().equals(bid) && ib.getStudent().getStudentId().equals(sid)) {
				double fine=ib.getFine();
			
				if(fine!=0) {
					fine=0.0;
				}
				final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String dueDate=ib.getDueDate();
				final LocalDate firstDate = LocalDate.parse(dueDate, formatter);
			    final LocalDate secondDate = LocalDate.parse(rdate, formatter);
			    long days = ChronoUnit.DAYS.between(firstDate, secondDate);
			    if(days>0) {
			    	for(int i=1;i<=days;i++) {
			       		fine=fine+10;
			       	}
			    }
				ib.setFine(fine);
				IssueBook issueBook=idao.save(ib);
				return issueBook;
				}
			}
		
		return null;
	}
}
