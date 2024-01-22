package com.example.association1;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int sRollno;
	private String sName;
	private String sMarks;
	
	
//	@OneToOne
//	private Laptop laptop;
//	
//	public Laptop getLaptop() {
//		return laptop;
//	}
//	public void setLaptop(Laptop laptop) {
//		this.laptop = laptop;
//	}
	
	@OneToMany(mappedBy="student")
	private List<Laptop> laptop=new ArrayList<Laptop>();
	
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	public int getsRollno() {
		return sRollno;
	}
	public void setsRollno(int sRollno) {
		this.sRollno = sRollno;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsMarks() {
		return sMarks;
	}
	public void setsMarks(String sMarks) {
		this.sMarks = sMarks;
	}
	
	
}
