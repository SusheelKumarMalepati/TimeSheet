package com.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.in.entity.Employee;
import com.in.entity.JobType;
import com.in.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@GetMapping(path="employee/getAll")
	public String getAllEmployeeDetails(Model model){
		List<Employee> employees= employeeService.getAllEmployeeDetails();
		model.addAttribute("employees", employees);
		model.addAttribute("jobTypes", JobType.values());
		return "employee";
	}
	@PostMapping(path="/create")
	public RedirectView createEmployee(@RequestParam("employeeId") Long employeeId,@RequestParam("employeeName") String employeeName,
			@RequestParam("employeePhoneNumber") Long employeePhoneNumber,@RequestParam("employeeEmail") String employeeEmail,
			@RequestParam("jobType") JobType jobType,Model model) {
		Employee employee=new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setEmployeePhoneNumber(employeePhoneNumber);
		employee.setEmployeeEmail(employeeEmail);
		employee.setJobType(jobType);
		employeeService.createEmployee(employee);
		 return new RedirectView("/employee/getAll");
	}
}
