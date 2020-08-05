package com.kashu.website.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kashu.website.model.Employee;
import com.kashu.website.repository.ObjectRepository;

@Transactional
@Component("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	@Qualifier("hibernateImpl")
	private ObjectRepository<Employee> repository;

	@Override
	public void save(Employee e) {
		repository.store(e);
	}

	@Override
	public Employee getOne(int id) {
		return repository.retrieve(id);
	}

	@Override
	public List<Employee> getAll() {
		return repository.getAll();
	}

	@Override
	public List<Employee> search(String name) {
		return repository.search(name);
	}

	@Override
	public Employee delete(int id) {
		return repository.delete(id);
	}

	@Override
	public Employee update(int id, Employee e) {
		return repository.update(id, e);
	}

}
