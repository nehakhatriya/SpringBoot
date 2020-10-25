package com.springboot.SpringBootRestCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringBootRestCRUD.entity.Employee;
import com.springboot.SpringBootRestCRUD.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired 
	private EmployeeService service;;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return service.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee emp=service.findById(id);
		if(emp==null)
			throw new RuntimeException("cannot find employee");
		else
		return emp;
	}
	
	@PostMapping("/employees")
	public void addEmployee(@RequestBody() Employee employee) {
		employee.setId(0);
		service.saveEmployee(employee);
	}
	
	@PutMapping("/employees")
	public Employee editEmployee(@RequestBody() Employee employee) {
		service.saveEmployee(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
		return "Deleted employee wiht id: "+id;
	}
	
}
