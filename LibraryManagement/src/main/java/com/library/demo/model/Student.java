package com.library.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.library.demo.sequencegenerator.StringPrefixedSequenceIdGenerator;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "Stud_Seq")
	@GenericGenerator(name="Stud_Seq",
    strategy = "com.library.demo.sequencegenerator.StringPrefixedSequenceIdGenerator",
    parameters = {
            @Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value="1"),
            @Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="Stud_"),
            @Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,value="%04d")
    }
    )
	private String studentId;
	private String studentName;
	private String studentYear;
	private String studentBranch;
	private String studentSemester;
	private String studentContact;
	
	@OneToMany(mappedBy="student")
	List<IssueBook> issueBooks=new ArrayList<IssueBook>();
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentYear() {
		return studentYear;
	}
	public void setStudentYear(String studentYear) {
		this.studentYear = studentYear;
	}
	public String getStudentBranch() {
		return studentBranch;
	}
	public void setStudentBranch(String studentBranch) {
		this.studentBranch = studentBranch;
	}
	public String getStudentSemester() {
		return studentSemester;
	}
	public void setStudentSemester(String studentSemester) {
		this.studentSemester = studentSemester;
	}
	public String getStudentContact() {
		return studentContact;
	}
	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
	}
	
	public List<IssueBook> getIssueBooks() {
		return issueBooks;
	}
	public void setIssueBooks(List<IssueBook> issueBooks) {
		this.issueBooks = issueBooks;
	}	
	
	
}
