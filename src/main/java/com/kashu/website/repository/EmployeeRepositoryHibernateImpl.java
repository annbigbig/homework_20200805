package com.kashu.website.repository;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.kashu.website.model.Employee;

@Repository
@Component("hibernateImpl")
public class EmployeeRepositoryHibernateImpl implements ObjectRepository<Employee> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void store(Employee e) {
		sessionFactory.getCurrentSession().save(e);
	}

	@Override
	public Employee retrieve(int id) {
		return sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public List<Employee> getAll() {
		@SuppressWarnings("unchecked")
	      TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee");
	      return query.getResultList();
	}

	@Override
	public List<Employee> search(String name) {
		
		/*
		 * https://www.boraji.com/hibernate-5-criteria-query-example
		 * https://www.baeldung.com/hibernate-criteria-queries
		 */
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
		Root<Employee> root = query.from(Employee.class);
        //query.select(root).where(builder.equal(root.get("name"), name));
        query.select(root).where(builder.like(root.get("name"), "%"+name+"%"));
        Query<Employee> q=session.createQuery(query);
        List<Employee> employees=q.getResultList();
		
		System.out.println("echo from EmployeeRepositoryHibernate Impl [ name = " + name + " ]");
		return employees;
		
	}

	@Override
	public Employee delete(int id) {
		Employee killed_employee = retrieve(id);
		/* don't do this because this is not working
		  Employee e = new Employee();
		  e.setId(id);
		  sessionFactory.getCurrentSession().remove(e);
		*/
		sessionFactory.getCurrentSession().remove(killed_employee);
		return killed_employee;
	}

	@Override
	public Employee update(int id, Employee e) {
		Employee changed_employee = retrieve(id);
		changed_employee.setName(e.getName());
		changed_employee.setBirthday(e.getBirthday());
		changed_employee.setAddress(e.getAddress());
		changed_employee.setLuckyNumber(e.getLuckyNumber());
		changed_employee.setStatus(e.isStatus());
		sessionFactory.getCurrentSession().saveOrUpdate(changed_employee);
		return changed_employee;
	}

}
