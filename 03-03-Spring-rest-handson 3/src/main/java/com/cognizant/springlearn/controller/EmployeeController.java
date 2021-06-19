package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/employees",method = RequestMethod.GET)
	List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
		
	}
	
	@RequestMapping(value="/employees/{id}",method = RequestMethod.PUT)
	public Employee updateEmployee(@Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
		
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException
	{
		employeeService.deleteEmployee(id);
	}
}
