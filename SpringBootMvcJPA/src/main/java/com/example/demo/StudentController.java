package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	@Autowired
	private StudentDao studentdao;
	
	@RequestMapping("stud")
	public String getStudent() {
		return "student";
	}
	
	@RequestMapping("insertstudentdata")
	public String insertData(Student stud) {
		studentdao.save(stud);
		return "student";
	}
	
	@RequestMapping("getstudentdata")
	public String getData(@RequestParam("studId") int id,Model m) {
		Student student=studentdao.findById(id).orElse(new Student());
		m.addAttribute("student", student);
		return "show";
	}
	
	@RequestMapping("deletestudentdata")
	public String deleteData(@RequestParam("studId") int id,Model m) {
		
		//studentdao.deleteById(id);
		
		Student student=studentdao.findById(id).orElse(null);
		if(student!=null) {
			studentdao.delete(student);
			m.addAttribute("studobj", "Student record deleted by id "+id);
			return "show";
		}
		else {
			return "failure";
		}
	
	}
	
	@RequestMapping("updatestudentdata")
	public String updateData(Student student,Model m) {
		
		studentdao.save(student);
		m.addAttribute("studobj1", "Student record updated by id "+student.getStudId());
		return "show";
	}
	
	@RequestMapping("selectstudentdata")
	public String selectData(Model m) {
		
		Iterable<Student> students=studentdao.findAll();
		m.addAttribute("studall", students);
		return "showall";
	}
}
