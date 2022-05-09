package com.esprit.essaii.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.esprit.essaii.model.Employee;
import com.esprit.essaii.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeservice;

	@RequestMapping(value = "/employees/add", method = RequestMethod.GET)  //lorsque je demande le formulaire j utilise GET
	public ModelAndView ajouter_employee() {  //cette methode va retourner un objet de type ModelAndView
		ModelAndView model = new ModelAndView();
		Employee c = new Employee(); // le modèle est une instance de la classe client (le modele c est l objet qui va etre remplie par l interface)
		model.addObject("employeeForm", c); // ajout du modéle
		//ce nom clientForm est le mm qui doit etre ajouté dans page html :    th:object="${clientForm}" càd l'objet créé ds page html 
		//c.setDatedenaissance(Calendar.getInstance().getTime());
		model.setViewName("Employee_Form"); // indiquer le nom de la page html qui va etre affiché
		return (model);

	}	
	
	@RequestMapping(value = "/employees/save", method = RequestMethod.POST) //lorsque je remplis le formulaire j utilise POST
	public ModelAndView save(@ModelAttribute("employeeForm") Employee c) { //je vais recuperer le modele clientForm en client c

		employeeservice.saveOrUpdate(c);
		return (new ModelAndView("redirect:/employees/list"));
		
	}
	
	
	@RequestMapping(value = "/employees/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		/* récupérer la liste des clients à partir de la base */
		List<Employee> listcl = employeeservice.getAllEmployees();
		model.addObject("employees", listcl);
		/* indiquer le nom de la page html à afficher */
		model.setViewName("Consulte_Employees");//nom de page web
		return (model);

	}
	
	@RequestMapping(value = "/employees/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") long id) {
		ModelAndView model = new ModelAndView();

		Employee cl = employeeservice.getEmployeeById(id);
		model.addObject("employeeForm", cl);
		model.setViewName("Employee_EditForm");

		return model;
	}

	@RequestMapping(value = "/employees/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
				
		employeeservice.deleteEmployee(id);
		return (new ModelAndView("redirect:/employees/list"));
	}
	
}
