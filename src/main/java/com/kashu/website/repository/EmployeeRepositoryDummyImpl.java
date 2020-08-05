package com.kashu.website.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.kashu.website.model.Employee;

@Repository
@Component("dummyImpl")
public class EmployeeRepositoryDummyImpl implements ObjectRepository<Employee> {

	private Map<Integer, Employee> map;
	
	public EmployeeRepositoryDummyImpl() {
		this.map = new HashMap<>();
		//creating initial data
		Employee emp = new Employee(1, "Pankaj",LocalDate.of(1981, 12, 27),"Pa Ku String 32",36,true);
		this.map.put(1, emp);
	}
	
	@Override
	public void store(Employee emp) {
		map.put(emp.getId(), emp);		
	}

	@Override
	public Employee retrieve(int id) {
		return map.get(id);
	}
	
	@Override
	public List<Employee> search(String name) {
		// https://dzone.com/articles/convert-map-to-list-in-java-8		
		List<Employee> emps = map.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());
		return emps;
	}

	@Override
	public Employee delete(int id) {
		Employee e = map.get(id);
		this.map.remove(id);
		return e;
	}
	
	@Override
	public List<Employee> getAll() {
		List<Employee> emps = new ArrayList<>();
		
		for(Employee e : this.map.values())
			emps.add(e);
		
		return emps;
	}

	@Override
	public Employee update(int id, Employee e) {
		this.map.put(id, e);
		return e;
	}

}
