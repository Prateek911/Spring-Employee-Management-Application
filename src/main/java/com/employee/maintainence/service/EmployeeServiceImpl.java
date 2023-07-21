package com.employee.maintainence.service;

import com.employee.maintainence.entity.EmployeeRepository;
import com.employee.maintainence.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

@Autowired
private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getEmpData() {


        return employeeRepository.findAll();
    }

    @Override
    public void updateRecord(Employee emp) {

        employeeRepository.save(emp);

    }

    @Override
    public BigDecimal getMaxSalary() {

        return employeeRepository.findMaxSalary();
    }

    @Override
    public void deleteById(Integer empId) {

        employeeRepository.deleteById(empId);
    }

    @Override
    public Optional<Employee> findById(Integer empId) {

        return employeeRepository.findById(empId);

    }


}
