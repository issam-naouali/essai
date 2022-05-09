package com.esprit.essaii.service;

import java.util.List;

import com.esprit.essaii.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	 
	 public Employee getEmployeeById(long id);
	  
	 public void saveOrUpdate(Employee employee);
	 
	 public void deleteEmployee(long id);
}
