package com.esprit.essaii.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esprit.essaii.model.Employee;
import com.esprit.essaii.reposirtory.EmployeeRepository;

@Service //càd c est un service
@Transactional //càd on va utiliser des requetes sur la bd

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository agent;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) agent.findAll(); 
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return agent.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		// TODO Auto-generated method stub
		agent.save(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		agent.deleteById(id);
	}

}
