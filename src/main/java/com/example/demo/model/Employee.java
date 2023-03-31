package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Employee {
	
	
	@Id
	@GeneratedValue
	private Integer empId;
	
	private String empName;
	
	private double empSalary;
	
	
	private String empDept;
}
