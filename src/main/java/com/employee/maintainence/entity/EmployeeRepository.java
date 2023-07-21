package com.employee.maintainence.entity;

import com.employee.maintainence.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

@Query("select MAX(e.salary) from Employee e")
BigDecimal findMaxSalary();



}
