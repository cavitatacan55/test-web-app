package com.ca.works.crud;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ca.works.crud.Employee;

@Stateless
@LocalBean
public class EmployeeDAO {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		Query qry = em.createQuery("from Employee");
		return qry.getResultList();
		
	}
	
	public void  add(Employee e) {
		em.merge(e);
	}
	
	public Employee update(Employee e) {
		return em.merge(e);
	}
	
	public Employee findById(Object id) {
		
		return em.find(Employee.class, id);
	}
	
	public void remove(Employee e) {
		
		 em.remove(em.contains(e) ? e : em.merge(e));
	}
	
}
