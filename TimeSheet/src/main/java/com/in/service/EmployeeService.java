package com.in.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.in.entity.Employee;

@Service
public interface EmployeeService {
	public List<Employee> getAllEmployeeDetails();
	public Employee createEmployee(Employee employee);
	public Employee getEmployeeById(Long employeeId);
}
