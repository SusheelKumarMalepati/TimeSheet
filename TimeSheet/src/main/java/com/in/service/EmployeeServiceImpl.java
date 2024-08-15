package com.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in.entity.Employee;
import com.in.repository.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployeeDetails(){
		return employeeRepository.findAll();
	}
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.getById(employeeId);
	}
}
