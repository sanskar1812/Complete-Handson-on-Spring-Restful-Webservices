package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDAO;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;

	public List<Employee> getAllEmployees(){
		
		return employeeDao.getAllEmployee();
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException
	{

		return employeeDao.updateEmployee(employee);
	}

	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		
		employeeDao.deleteEmployee(id);
		
	}
	
}
