package com.kashu.website.service;

import java.util.List;

import com.kashu.website.model.Employee;

public interface EmployeeService {

	public void save(Employee e);

	public Employee getOne(int id);
	
	public List<Employee> getAll();

	public List<Employee> search(String name);

	public Employee delete(int id);
	
	public Employee update(int id, Employee e);
}
