package com.in.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.in.entity.Employee;
import com.in.entity.TimeSheet;
import com.in.exception.EmployeeNotFoundException;
import com.in.exception.TimeSheetException;
import com.in.service.EmployeeService;
import com.in.service.TimeSheetService;

@Controller
public class TimeSheetController {
	@Autowired
	TimeSheetService timeSheetService;
	@Autowired
	EmployeeService employeeService;
	@GetMapping(path="/getTimesheet/{employeeId}")
	public String getTimeSheetOfEmployee(@PathVariable Long employeeId,Model model) throws EmployeeNotFoundException{
		List<TimeSheet> timesheets = timeSheetService.getTimeSheetOfEmployee(employeeId);
		Employee employee=employeeService.getEmployeeById(employeeId);
		model.addAttribute("timesheets", timesheets);
		model.addAttribute("employeeId", employeeId);
		model.addAttribute("employee",employee);
		return "timesheet";
	}
	@PostMapping(path="/submitTimesheet")
	public RedirectView updateTimeSheet(@RequestParam LocalDate startDate,@RequestParam LocalDate endDate,
			@RequestParam int hoursWorkedPerDay,@RequestParam Long employeeId) throws TimeSheetException  {
		TimeSheet timeSheet=new TimeSheet();
		timeSheet.setStartDate(startDate);
		timeSheet.setEndDate(endDate);
		timeSheet.setHoursWorkedPerDay(hoursWorkedPerDay);
		Employee employee=employeeService.getEmployeeById(employeeId);
		timeSheet.setEmployee(employee);
		timeSheetService.updateTimeSheet(timeSheet);
		return new RedirectView("/getTimesheet/"+employeeId);
	}
}
