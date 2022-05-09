package com.esprit.essaii.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.essaii.model.Employee;
import com.esprit.essaii.model.Poste;



@RestController
public class TestEmplController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setNom("issam");
		emp.setDatedenaissance(new Date());
		//emp.setId();
		emp.setPoste(Poste.Actionnaire);

		return emp;
	}

}
