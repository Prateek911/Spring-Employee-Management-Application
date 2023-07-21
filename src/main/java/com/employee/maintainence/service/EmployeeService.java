package com.employee.maintainence.service;

import com.employee.maintainence.model.Employee;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

 List<Employee> getEmpData();

 void updateRecord(Employee emp);

 BigDecimal getMaxSalary();

 void deleteById(Integer empId);

 Optional<Employee> findById(Integer empId);

}
