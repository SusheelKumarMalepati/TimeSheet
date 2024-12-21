package com.in.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.entity.TimeSheet;
@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long>{
	public List<TimeSheet> findByEmployee_EmployeeId(Long employeeId);
}
