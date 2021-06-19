package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.dao.DepartmentDAO;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;
	public List<Department> getAllDepartments() {
		
		return departmentDAO.getAllDepartments();
	}

	
}
