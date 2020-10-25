package com.springboot.SpringBootRestCRUD.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.SpringBootRestCRUD.entity.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

	@Autowired
	private EntityManager entitymanager;
	
	@Override
	public List<Employee> getEmployees() {
       Session session=entitymanager.unwrap(Session.class);
       Query<Employee> query=session.createQuery("from Employee",Employee.class); 
		return query.getResultList();
	}

	@Override
	public Employee findById(int id) {
		Session session=entitymanager.unwrap(Session.class);
		return session.get(Employee.class, id);
	}

	@Override
	public void deleteEmployee(int id) {
		Session session=entitymanager.unwrap(Session.class);
		session.delete(session.get(Employee.class, id));
	}

	@Override
	public void saveEmployee(Employee employee) {
		Session session=entitymanager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}
	
	

}
