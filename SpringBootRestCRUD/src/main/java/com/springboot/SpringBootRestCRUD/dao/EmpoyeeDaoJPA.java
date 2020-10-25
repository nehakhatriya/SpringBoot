package com.springboot.SpringBootRestCRUD.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.SpringBootRestCRUD.entity.Employee;

public class EmpoyeeDaoJPA implements EmployeeDao{

	@Autowired
	EntityManager entitymanager;
	
	@Override
	public List<Employee> getEmployees() {
		TypedQuery<Employee> query=entitymanager.createQuery("from Employee",Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findById(int id) {
		return entitymanager.find(Employee.class,id);
	}

	@Override
	public void deleteEmployee(int id) {
		entitymanager.remove(entitymanager.find(Employee.class,id));
	}

	@Override
	public void saveEmployee(Employee employee) {
		entitymanager.merge(employee);
	}

}
