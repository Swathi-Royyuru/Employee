package com.ctc.service;

import java.util.List;

import com.ctc.entity.Employee;
import com.ctc.exception.ResourceNotFoundException;


public interface EmpService {

	
	public Employee createEmployee(Employee employee);
	public List<Employee> getDetails();
	public Employee updateEmployee(Employee employee) throws Throwable;
	public String deleteEmployee(Employee emp) throws ResourceNotFoundException;
	public Employee getEmployee(String fullName) throws ResourceNotFoundException;
}
