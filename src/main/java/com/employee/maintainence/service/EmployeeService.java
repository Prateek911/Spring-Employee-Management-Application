package com.employee.maintainence.service;

import com.employee.maintainence.model.Employee;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

 List<Employee> getEmpData();

 @Query("select MAX(e.salary) from Employee e")
 BigDecimal getMaxSalary();

 void deleteById(Integer empId);

 Optional<Employee> findById(Integer empId);

}
