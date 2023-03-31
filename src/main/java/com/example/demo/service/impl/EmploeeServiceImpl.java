package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmploeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;


	public Integer saveEmployee(Employee e) {
	
		return repo.save(e).getEmpId();
	}

	public List<Employee> getallEMployee() {
       
		List<Employee> list=repo.findAll();
		
		return list;
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		
		Optional<Employee> opt=repo.findById(id);
		
		//Employee emp=opt.orElseThrow(()->new EmplyeeNotFoundException("Employee Not found"));
		
		// or you can use easy method also
		
		Employee e;
		
		if(opt.isPresent())
		{
			e=opt.get();
		}
		else {
			throw new EmployeeNotFoundException("Employee not found");
			
		}
		return e;
	}


	public void deleteEmployee(Integer id) {
		
		Employee e=getOneEmployee(id);
		
		repo.delete(e);
		
	}

	
	
	
}
