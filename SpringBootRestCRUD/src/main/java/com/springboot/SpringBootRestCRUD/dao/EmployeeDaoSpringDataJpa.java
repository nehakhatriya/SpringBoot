package com.springboot.SpringBootRestCRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.SpringBootRestCRUD.entity.Employee;

public interface EmployeeDaoSpringDataJpa extends JpaRepository<Employee,Integer>{


}
