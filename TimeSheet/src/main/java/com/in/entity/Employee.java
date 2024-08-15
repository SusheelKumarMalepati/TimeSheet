package com.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	private Long employeeId;
	private String employeeName;
	private String employeeEmail;
	private Long employeePhoneNumber;
	@Enumerated(EnumType.STRING)
	private JobType jobType;
}
