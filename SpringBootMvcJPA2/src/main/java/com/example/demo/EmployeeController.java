package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao edao;
	
	@RequestMapping("emp")
	public String getEmployee() {
		return "employee";
	}
	
	@RequestMapping("insertemployeedata")
	public String insertEmpData(Employee e) {
		Employee emp=edao.save(e);
		if(emp!=null) {
			return "empinsert";
		}
		return "failure";
	}
	
	@RequestMapping("getemployeedata")
	public String getData(@RequestParam("Id") int id,Model m) {
		Employee emp=edao.findById(id).orElse(null);
		//Employee emp=edao.findById(id).get();
		if(emp!=null) { 
			m.addAttribute("empobj", emp);
			return "empshow";
		}
		
		return "failure";
	}
	
	@RequestMapping("deleteemployeedata")
	public String deleteData(@RequestParam("Id") int id,Model m) {
		
		//studentdao.deleteById(id);
		
		Employee employee=edao.findById(id).orElse(null);
		if(employee!=null) {
			edao.delete(employee);
			m.addAttribute("empobj", "Employee record deleted by id "+id);
			return "empdel";
		}
		return "failure";
	
	}
	
	@RequestMapping("updateemployeedata")
	public String updateData(Employee employee,Model m) {
		
		Employee emp=edao.save(employee);
		if(emp!=null) {
			m.addAttribute("empobj", "Employee record updated by id "+employee.getId());
			return "empup";
		}
		return "failure";
	}
	
	@RequestMapping("selectemployeedata")
	public String selectData(Model m) {
		
		Iterable<Employee> employees=edao.findAll();
		m.addAttribute("empall", employees);
		return "showall";
	}
	
	@RequestMapping("findbydesig")
	public String getDesig(@RequestParam("desig") String desig,Model m) {
		List<Employee> emp=edao.findByDesig(desig);
		m.addAttribute("emp", emp);
		return "showall";
	}
	
	@RequestMapping("findbyname")
	public String getName(@RequestParam("name") String name,Model m) {
		List<Employee> emp=edao.findByName(name);
		m.addAttribute("emp", emp);
		return "showall";
	}
	
	@RequestMapping("findbyid")
	public String getId(@RequestParam("id") int id,Model m) {
		List<Employee> emp=edao.findByIdGreaterThan(id);
		m.addAttribute("emp", emp);
		return "showall";
	}
	
	@RequestMapping("findbysalaryg")
	public String getSalaryg(@RequestParam("salary") int salary,Model m) {
		List<Employee> emp=edao.findBySalaryGreaterThan(salary);
		m.addAttribute("emp", emp);
		return "showall";
	}
	
	@RequestMapping("findbysalaryl")
	public String getSalaryl(@RequestParam("salary") int salary,Model m) {
		List<Employee> emp=edao.findBySalaryLessThan(salary);
		m.addAttribute("emp", emp);
		return "showall";
	}
	
	@RequestMapping("findbynamesorted")
	public String getNameSorted(Model m) {
		List<Employee> emp=edao.findByNameSorted();
		m.addAttribute("emp", emp);
		return "showall";
	}
	
	@RequestMapping("findbynamesortedpredefined")
	public String getNameSortedPreDefined(Model m) {
		List<Employee> emp=edao.findByOrderByName();
		m.addAttribute("emp", emp);
		return "showall";
	}
	
	@RequestMapping("findbydesigorderbyname")
	public String getDesigByName(@RequestParam("desig") String desig,Model m) {
		List<Employee> emp=edao.findByDesigOrderByName(desig);
		m.addAttribute("emp", emp);
		return "showall";
	}
}
