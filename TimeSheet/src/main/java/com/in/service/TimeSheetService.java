package com.in.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.in.entity.TimeSheet;
import com.in.exception.EmployeeNotFoundException;
import com.in.exception.TimeSheetException;

@Service
public interface TimeSheetService {
	public List<TimeSheet> getTimeSheetOfEmployee(Long employeeId) throws EmployeeNotFoundException;
	public TimeSheet updateTimeSheet(TimeSheet timeSheet) throws TimeSheetException ;
}
