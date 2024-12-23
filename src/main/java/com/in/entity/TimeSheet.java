package com.in.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TimeSheet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long timeSheetId;
	private LocalDate startDate;
	private LocalDate endDate;
	private int hoursWorkedPerDay;
	private int hoursWorked;
	@ManyToOne
	@JoinColumn(name="employee_employeeId",nullable=false)
	private Employee employee;
	public Long getTimeSheetId() {
		return timeSheetId;
	}
	public void setTimeSheetId(Long timeSheetId) {
		this.timeSheetId = timeSheetId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getHoursWorkedPerDay() {
		return hoursWorkedPerDay;
	}
	public void setHoursWorkedPerDay(int hoursWorkedPerDay) {
		this.hoursWorkedPerDay = hoursWorkedPerDay;
	}
	public int getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public TimeSheet(Long timeSheetId, LocalDate startDate, LocalDate endDate, int hoursWorkedPerDay, int hoursWorked,
			Employee employee) {
		super();
		this.timeSheetId = timeSheetId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hoursWorkedPerDay = hoursWorkedPerDay;
		this.hoursWorked = hoursWorked;
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "TimeSheet [timeSheetId=" + timeSheetId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", hoursWorkedPerDay=" + hoursWorkedPerDay + ", hoursWorked=" + hoursWorked + ", employee=" + employee
				+ "]";
	}
	
}
