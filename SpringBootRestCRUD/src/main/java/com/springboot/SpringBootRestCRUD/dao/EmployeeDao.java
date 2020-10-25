package com.springboot.SpringBootRestCRUD.dao;

import java.util.List;

import com.springboot.SpringBootRestCRUD.entity.Employee;

public interface EmployeeDao {

	List<Employee> getEmployees();

	Employee findById(int id);

	void deleteEmployee(int id);

	void saveEmployee(Employee employee);

}