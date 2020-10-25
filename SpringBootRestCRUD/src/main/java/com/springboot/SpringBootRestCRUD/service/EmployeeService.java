package com.springboot.SpringBootRestCRUD.service;

import java.util.List;

import com.springboot.SpringBootRestCRUD.entity.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();

	Employee findById(int id);

	void deleteEmployee(int id);

	void saveEmployee(Employee employee);

}