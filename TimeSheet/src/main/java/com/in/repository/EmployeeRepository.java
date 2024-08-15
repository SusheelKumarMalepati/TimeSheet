package com.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long >{

}
