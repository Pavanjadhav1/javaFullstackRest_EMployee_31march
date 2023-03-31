package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:3000/")
@RequestMapping("/emp")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
	{
		
		Integer id =service.saveEmployee(employee);
		
		return new ResponseEntity<String>("Employee "+id+" is saved",HttpStatus.OK );
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEMployee()
	{
		List<Employee> list=service.getallEMployee();
		
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/one/{id}")
public ResponseEntity<Employee>	getOneEmployee(@PathVariable Integer id)
{
		Employee emp=service.getOneEmployee(id);
		
	return new ResponseEntity<Employee>(emp,HttpStatus.OK);
}
	
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id)
	{
		service.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee "+id+" is Deleted",HttpStatus.OK);
	}
	
	
	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee)
	{
		
		Employee db=service.getOneEmployee(id);
		
		db.setEmpName(employee.getEmpName());
		db.setEmpSalary(employee.getEmpSalary());
		db.setEmpDept(employee.getEmpDept());
		
		service.saveEmployee(db);
		
		
		
		return  new ResponseEntity<String>("Employee "+id+" is updated",HttpStatus.OK ) ;
	}
	
	
	
	
	
	
	
	
}
