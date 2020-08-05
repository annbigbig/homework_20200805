package com.kashu.website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kashu.website.model.Employee;
import com.kashu.website.service.EmployeeService;

@RestController
public class EmployeeRestController {

	//@Autowired
	//@Qualifier("hibernateImpl")
	//private ObjectRepository<Employee> repository;
	
	@Autowired
	@Qualifier("employeeServiceImpl")
	private EmployeeService employeeService;
	
	@GetMapping("/rest/employee/get/{id}")
	public Employee getEmployeeByID(@PathVariable("id") int id) {
		return employeeService.getOne(id);
	}
	
	@GetMapping("/rest/employee/getAll")
	//Returning is List is supported with JSON response only
	//If you want XML, then add a wrapper class as Root XML element, for example EmployeeList
	public List<Employee> getAllEmployees() {
		return employeeService.getAll();
	}

	@PostMapping("/rest/employee/create")
	public Employee createEmployee(@RequestBody Employee e) {
		employeeService.save(e);
		System.out.println(e.toString());
		System.out.println("status : " + (e.isStatus() ? "true" : "false") );
		return e;
	}
	
	@GetMapping("/rest/employee/search/{name}")
	public List<Employee> getEmployeeByName(@PathVariable("name") String name) {
		System.out.println("search name = " + name);
		return employeeService.search(name);
	}
	
	@DeleteMapping("/rest/employee/delete/{id}")
	public Employee deleteEmployeeByID(@PathVariable("id") int id) {
		return employeeService.delete(id);
	}
	
	@PutMapping("/rest/employee/update/{id}")
	public Employee updateEmployeeByID(@RequestBody Employee e, @PathVariable("id") int id) {
		return employeeService.update(id, e); 
		//employeeService.update(id, e);
		//Employee updated_employee = employeeService.getOne(id);
		//return updated_employee ;
	}
}