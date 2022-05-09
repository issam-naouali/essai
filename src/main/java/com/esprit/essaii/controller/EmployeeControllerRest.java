package com.esprit.essaii.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.essaii.exception.ResourceNotFoundException;
import com.esprit.essaii.model.Employee;
import com.esprit.essaii.reposirtory.EmployeeRepository;


@RestController
@RequestMapping("/api/v1")
public class EmployeeControllerRest {

	@Autowired
	private EmployeeRepository agent;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		//http://localhost:8089/clinique/api/v1/clients
		return (List<Employee>) agent.findAll();
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Employee employee = agent.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return agent.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long clientId,
			@Valid @RequestBody Employee clientDetails) throws ResourceNotFoundException {
		Employee client = agent.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));

		client.setId(clientDetails.getId());
		client.setNom(clientDetails.getNom());
		client.setDatedenaissance(clientDetails.getDatedenaissance());
		client.setPoste(clientDetails.getPoste());

		
		final Employee updatedclient = agent.save(client);
		return ResponseEntity.ok(updatedclient);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Employee client = agent.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));

		agent.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
}
