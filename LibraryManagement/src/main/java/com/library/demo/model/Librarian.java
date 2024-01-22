package com.library.demo.model;

import java.util.ArrayList;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.library.demo.sequencegenerator.StringPrefixedSequenceIdGenerator;


@Entity
public class Librarian {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "Lib_Seq")
	@GenericGenerator(name="Lib_Seq",
    strategy = "com.library.demo.sequencegenerator.StringPrefixedSequenceIdGenerator",
    parameters = {
            @Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value="1"),
            @Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="Lib_"),
            @Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%04d")
    }
    )
	private String librarianId; 
	
	@Pattern(regexp="[a-zA-Z ]{4,}",message="*must contain only alphabets with atleast size 4")
	private String librarianName;
	
	@Pattern(regexp="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",message="*must have:atleast 1Upper,1Lower,1SpecialChar,1digit")
	@Size(min=8,message="*password size must be atleast 8")
	private String librarianPassword;
	
	@Pattern(regexp="^[a-z]{4}[a-z0-9]+@gmail.com",message="*first 4 chars alphabets then AlphaNumerics and @gmail.com")
	private String librarianEmail;
	
	@Size(min=3,message= "*must contain atleast 3 chars")
	private String librarianAddress;
	
	@NotBlank(message="*this field is required")
	private String librarianGender;
	
	@Pattern(regexp="[0-9]{10}",message="*please enter 10 digit mobile number only")
	private String librarianContactno;
	
	@OneToMany(mappedBy="librarian")
	List<Book> books=new ArrayList<Book>();
	
	@ManyToOne
	private Admin admin;
	
	@OneToMany(mappedBy="librarian")
	List<IssueBook> issueBooks=new ArrayList<IssueBook>();
	
	
	public String getLibrarianId() {
		return librarianId;
	}
	public void setLibrarianId(String librarianId) {
		this.librarianId = librarianId;
	}
	public String getLibrarianName() {
		return librarianName;
	}
	public void setLibrarianName(String librarianName) {
		this.librarianName = librarianName;
	}
	public String getLibrarianPassword() {
		return librarianPassword;
	}
	public void setLibrarianPassword(String librarianPassword) {
		this.librarianPassword = librarianPassword;
	}
	public String getLibrarianEmail() {
		return librarianEmail;
	}
	public void setLibrarianEmail(String librarianEmail) {
		this.librarianEmail = librarianEmail;
	}
	public String getLibrarianAddress() {
		return librarianAddress;
	}
	public void setLibrarianAddress(String librarianAddress) {
		this.librarianAddress = librarianAddress;
	}
	public String getLibrarianGender() {
		return librarianGender;
	}
	public void setLibrarianGender(String librarianGender) {
		this.librarianGender = librarianGender;
	}
	public String getLibrarianContactno() {
		return librarianContactno;
	}
	public void setLibrarianContactno(String librarianContactno) {
		this.librarianContactno = librarianContactno;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<IssueBook> getIssueBooks() {
		return issueBooks;
	}
	public void setIssueBooks(List<IssueBook> issueBooks) {
		this.issueBooks = issueBooks;
	}
	
	
}
