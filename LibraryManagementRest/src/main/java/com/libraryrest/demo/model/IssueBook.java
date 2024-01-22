package com.libraryrest.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.libraryrest.demo.sequencegenerator.StringPrefixedSequenceIdGenerator;


@Entity
public class IssueBook {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "Issu_Seq")
	@GenericGenerator(name="Issu_Seq",
    strategy = "com.libraryrest.demo.sequencegenerator.StringPrefixedSequenceIdGenerator",
    parameters = {
            @Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value="1"),
            @Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="Issu_"),
            @Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%04d")
    }
    )
	private String id;
	private String issuedDate;
	
	private String dueDate;
	private double fine;
	
	@ManyToOne
	private Librarian librarian;
	
	@ManyToOne
	private Book book=new Book();
	
	@ManyToOne
	private Student student=new Student();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Librarian getLibrarian() {
		return librarian;
	}
	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	
}
