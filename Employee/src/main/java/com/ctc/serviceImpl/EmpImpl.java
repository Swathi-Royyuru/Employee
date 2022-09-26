package com.ctc.serviceImpl;

import java.util.List;
import java.util.function.Supplier;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctc.entity.Employee;
import com.ctc.exception.ResourceNotFoundException;
import com.ctc.repository.EmpRepositoy;
import com.ctc.service.EmpService;


@Service
public class EmpImpl implements EmpService{

	@Autowired
	private EmpRepositoy employeeRepo;
	
	@Override
	public Employee createEmployee(Employee employee) {
		
		String regularExpressionFullName = "^[A-Z][A-Za-z0-9]{3,20}$";
		if (employee.getPhoneNumber().length() != 10)			
			throw new ValidationException("please the length of the mobile number must be 10");
	
		else if (!employee.getFullName().matches(regularExpressionFullName)) {
			throw new ValidationException("Invalid username try again.."
					+ "Rules --> first letter must be an uppercase alphabet and minmum 3 characters");
	}
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getDetails() {
		return employeeRepo.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) throws Throwable {		
		
	
		return 	employeeRepo.save(employee);
	}

	@Override
	public String deleteEmployee(Employee emp) throws ResourceNotFoundException {
		employeeRepo.delete(emp);
		return "Deleted";
		   
	}

	@Override
	public Employee getEmployee(String fullName) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
