package com.employee.maintainence.entity;

import com.employee.maintainence.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

BigDecimal findMaxSalary();



}
