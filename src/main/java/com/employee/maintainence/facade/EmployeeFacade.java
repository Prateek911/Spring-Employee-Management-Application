package com.employee.maintainence.facade;

import com.employee.maintainence.model.Employee;
import com.employee.maintainence.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeFacade {

   @Autowired
   private EmployeeService employeeService;

   public List<Employee> getAllEmployyes() {

      return employeeService.getEmpData();

   }

   public BigDecimal getMaxSalary() {

      return employeeService.getMaxSalary();

   }

   public void deleteById(Integer empId){

      employeeService.deleteById(empId);

   }

   public Optional<Employee> findById (Integer empId){

      return employeeService.findById(empId);

   }



}
