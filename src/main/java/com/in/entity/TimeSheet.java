package com.in.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
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
}
