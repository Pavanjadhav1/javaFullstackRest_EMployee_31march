package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	
	
	Integer saveEmployee(Employee e);
	
	List<Employee> getallEMployee();
	
	 Employee getOneEmployee(Integer id);

	 void deleteEmployee(Integer id);
	 
	 
	 
	 
}
