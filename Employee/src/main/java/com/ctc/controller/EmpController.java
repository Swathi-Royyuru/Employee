package com.ctc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ctc.entity.Employee;
import com.ctc.exception.ResourceNotFoundException;
import com.ctc.service.EmpService;
import com.ctc.serviceImpl.EmpImpl;


@RestController
@RequestMapping("/api")
public class EmpController {
	

	@Autowired
	private EmpImpl empImpl;

	

	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee)
	{
	Employee e = empImpl.createEmployee(employee);
	ResponseEntity<Employee> re=new ResponseEntity<Employee>(e,HttpStatus.OK);
	return re;
	}
	

	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<String> deleteEmployeeById(@Valid @RequestBody Employee emp) throws ResourceNotFoundException
	{
	String e = empImpl.deleteEmployee(emp);
	ResponseEntity<String> re=new ResponseEntity<String>(e,HttpStatus.OK);
	return re;
	}
	
	@PutMapping("/updateEmployee") 
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee emp) throws Throwable
	{
	Employee e = empImpl.updateEmployee(emp);
	ResponseEntity<Employee> re=new ResponseEntity<Employee>(e,HttpStatus.OK);
	return re;
	}
	
	
	@GetMapping("/getDetails")
	public ResponseEntity<List<Employee>> getAuthorDetails() {
		List<Employee> store = empImpl.getDetails();
		return new ResponseEntity<List<Employee>>(store, HttpStatus.OK);
	
	}
}