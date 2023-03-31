package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> employeeNotFound(EmployeeNotFoundException ex)
	{
		
		
		return new  ResponseEntity<String> (ex.getMessage(),HttpStatus.NOT_FOUND);
	}

}
