package com.example.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Employee;

 

@Service
public class EmployeeServiceImpl implements EmployeeService {

 

    /*
     * @Autowired EmployeeDao employeeDao;
     */
    @Autowired
    EmployeeRepo employeeDao;

 

    @Override
    public void insertEmployee(Employee employee) {
        // employeeDao.insertEmployee(employee);
        employeeDao.save(employee);
    }

 

    /*
     * @Override public void insertEmployees(List<Employee> employees) {
     * employeeDao.insertEmployees(employees); }
     */

 

    public List<Employee> getAllEmployees() {
        // return employeeDao.getAllEmployees();
        return employeeDao.findAll();
    }

 

    @Override
    public void getEmployeeById(String empId) {
        // Employee employee = employeeDao.getEmployeeById(empId);
        // System.out.println(employee);
        Employee employee = employeeDao.getById(empId);
        System.out.println(employee);
    }

 

}