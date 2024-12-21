package com.in.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in.entity.Employee;
import com.in.entity.TimeSheet;
import com.in.exception.EmployeeNotFoundException;
import com.in.exception.TimeSheetException;
import com.in.repository.EmployeeRepository;
import com.in.repository.TimeSheetRepository;
@Component
public class TimeSheetServiceImpl implements TimeSheetService{
	@Autowired
	TimeSheetRepository timeSheetRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public List<TimeSheet> getTimeSheetOfEmployee(Long employeeId)throws EmployeeNotFoundException{
		Optional<Employee> employee=employeeRepository.findById(employeeId);
		if(employee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with the above employee number doesnot exist");
		}
		return timeSheetRepository.findByEmployee_EmployeeId(employeeId);
	}
	@Override
	public TimeSheet updateTimeSheet(TimeSheet timeSheet) throws TimeSheetException {
		LocalDate startDate=timeSheet.getStartDate();
		LocalDate endDate=timeSheet.getEndDate();
		LocalDate today=LocalDate.now();
		if(startDate.isAfter(endDate)) {
			throw new TimeSheetException("Start date should be before End date");
		}
		if(endDate.isAfter(today)) {
			throw new TimeSheetException("End date should not be todays day");
		}
		if((ChronoUnit.DAYS.between(startDate, endDate)>=7)) {
			throw new TimeSheetException("You can mark for only one week at a time");
		}
		int hours=0;
		LocalDate date=startDate;
		while(!date.isAfter(endDate)) {
			if(!(date.getDayOfWeek()==DayOfWeek.SATURDAY||date.getDayOfWeek()==DayOfWeek.SUNDAY)) {
				if(timeSheet.getHoursWorkedPerDay()>9) {
					throw new TimeSheetException("Daily working hours is greater than limit");
				}
				hours+=timeSheet.getHoursWorkedPerDay();
			}
			date=date.plusDays(1);
		}
		timeSheet.setHoursWorked(hours);
		return timeSheetRepository.save(timeSheet);
	}
}
