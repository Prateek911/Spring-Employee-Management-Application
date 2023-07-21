package com.employee.maintainence.controller;

import com.employee.maintainence.Exception.EmployeeNotFoundException;
import com.employee.maintainence.facade.EmployeeFacade;
import com.employee.maintainence.model.Employee;
import com.employee.maintainence.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/employees/")
public class EmployeeController {

    @Autowired
    private EmployeeFacade employeeFacade;

    @GetMapping("/inquiry")
    @ResponseBody
    public List<Employee> getAllEmployees() throws EmployeeNotFoundException{

        return employeeFacade.getAllEmployyes();

    }

    @GetMapping("/inquiry/{empId}")
    public ResponseEntity<Employee> getById(@PathVariable("empId") Integer id) throws EmployeeNotFoundException{

        Optional<Employee> empOptional = employeeFacade.findById(id);

        if(empOptional.isPresent()){

            Employee emp = empOptional.get();

            return ResponseEntity.ok(emp);

        } else {

            return ResponseEntity.notFound().build();
        }

    }


    @GetMapping("/salaryInquiry")
    public BigDecimal getMaxSalary(){

        return employeeFacade.getMaxSalary();

    }

    @DeleteMapping("/purge/{empId}")
    public ResponseEntity<String> getAllEmployees(@PathVariable("empId") Integer id) throws EmployeeNotFoundException{

        Optional<Employee> employeeOptional = employeeFacade.findById(id);

        if(employeeOptional.isPresent()){
            employeeFacade.deleteById(id);
            return ResponseEntity.ok("Employee deleted successfully for" +id);
        }else{
          return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("update/{empId}/{deptId}")
    public ResponseEntity<String> updateDeptId(@PathVariable("empId") Integer id, @PathVariable("deptId") BigDecimal deptId) throws EmployeeNotFoundException{

        Optional<Employee> employeeOptional = employeeFacade.findById(id);

        if(employeeOptional.isPresent()){
            Employee emp = employeeOptional.get();
            emp.setDepartmentId(deptId);
            employeeFacade.updateRecord(emp);
            return ResponseEntity.ok("Record Updated for "+id+" with new dept "+deptId);

        }else{

            return ResponseEntity.notFound().build();

        }


    }

}
