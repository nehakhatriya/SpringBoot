package com.springboot.SpringBootRestCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.SpringBootRestCRUD.dao.EmployeeDao;
import com.springboot.SpringBootRestCRUD.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return dao.getEmployees();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return dao.findById(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);	
	}
}
