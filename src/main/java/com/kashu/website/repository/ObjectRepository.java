package com.kashu.website.repository;

import java.util.List;

public interface ObjectRepository<T> {

	public void store(T t);

	public T retrieve(int id);
	
	public List<T> getAll();

	public List<T> search(String name);

	public T delete(int id);
	
	public T update(int id, T t);
}