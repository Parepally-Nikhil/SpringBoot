package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeDao extends CrudRepository<Employee,Integer> {
	List<Employee> findByDesig(String desig); //predefined method
	
	List<Employee> findByName(String name);		//predefined method
	
	List<Employee> findByIdGreaterThan(int id);//predefined method
	
	List<Employee> findBySalaryGreaterThan(int salary);//predefined method
	
	List<Employee> findBySalaryLessThan(int salary);//predefined method
	
	@Query("from Employee order by name")
	List<Employee> findByNameSorted();	//userdefined method thats why i used @Query annotation
	
	List<Employee> findByOrderByName();//predefined method
	
	List<Employee> findByDesigOrderByName(String desig);//predefined method
	
	
}
