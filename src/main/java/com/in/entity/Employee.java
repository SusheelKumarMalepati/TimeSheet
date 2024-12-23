package com.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	private Long employeeId;
	private String employeeName;
	private String employeeEmail;
	private Long employeePhoneNumber;
	@Enumerated(EnumType.STRING)
	private JobType jobType;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public Long getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}
	public void setEmployeePhoneNumber(Long employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}
	public JobType getJobType() {
		return jobType;
	}
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	public Employee(Long employeeId, String employeeName, String employeeEmail, Long employeePhoneNumber,
			JobType jobType) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeePhoneNumber = employeePhoneNumber;
		this.jobType = jobType;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmail="
				+ employeeEmail + ", employeePhoneNumber=" + employeePhoneNumber + ", jobType=" + jobType + "]";
	}
}
