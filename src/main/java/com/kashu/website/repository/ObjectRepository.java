package com.kashu.website.repository;

import java.util.List;
import com.kashu.website.model.Employee;

public interface ObjectRepository<T> {

	public void store(T t);

	public T retrieve(int id);
	
	public List<Employee> getAll();

	public List<Employee> search(String name);

	public T delete(int id);
	
	public T update(int id, T t);
}