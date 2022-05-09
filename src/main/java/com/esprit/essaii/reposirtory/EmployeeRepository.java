package com.esprit.essaii.reposirtory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.essaii.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
