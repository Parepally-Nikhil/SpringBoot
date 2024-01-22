package com.example.demo.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

 

import com.example.demo.dao.UserRepo;
import com.example.demo.model.Employee;
import com.example.demo.model.User;
import com.example.demo.service.EmployeeService;

 

@Controller
public class EmployeeController {

 

    @Autowired
    PasswordEncoder passwordEncoder;

 

    @Autowired
    EmployeeService employeeService;

 

    @Autowired
    UserRepo userRepo;

 

    @RequestMapping("/signup")
    public String getSignup() {
        return "signup";
    }

 

    @RequestMapping("/signin")
    public String login() {
        return "login";
    }

 

    @PostMapping("/insert")
    public String insertData(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "welcome";
    }

 

    @RequestMapping("/welcome")
    public ModelAndView firstPage() {
        return new ModelAndView("welcome");
    }

 

    @RequestMapping("/menu")
    public String getMenu() {
        return "menu";
    }

 

    @RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
    public ModelAndView show() {
        return new ModelAndView("addEmployee", "emp", new Employee());
    }

 

    @RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
    public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) {

 

        employeeService.insertEmployee(emp);
        List<Employee> employees = employeeService.getAllEmployees();
        ModelAndView model = new ModelAndView("getEmployees");
        model.addObject("employees", employees);
        return model;
    }

 

    @RequestMapping("/getEmployees")
    public ModelAndView getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        ModelAndView model = new ModelAndView("getEmployees");
        model.addObject("employees", employees);
        return model;
    }

 

    @RequestMapping("/logout-success")
    public String logoutPage() {
        return "logoutsuccess";
    }
}