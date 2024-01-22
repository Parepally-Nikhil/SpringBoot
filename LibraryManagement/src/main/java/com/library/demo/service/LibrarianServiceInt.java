package com.library.demo.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import com.library.demo.model.Book;
import com.library.demo.model.IssueBook;
import com.library.demo.model.Librarian;

public interface LibrarianServiceInt {
	public boolean librarianLogin(Librarian librarian);
	public boolean addBooks(HttpServletRequest request,Book book);
	public List<Book> viewBooks();
	public int deleteBookById(HttpServletRequest request,Book book);
	public int issueBook(HttpServletRequest request,String bookId,String studentId,IssueBook ib);
	public List<IssueBook> viewIssuedBooks();
	public boolean returnBook(String bid,String sid);
	public IssueBook checkFine(String bid,String sid,String rdate);
}
