package com.employee.maintainence.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer empId;

    @Column(name = "first_name")
    private String empName;

    @Column(name = "last_name")
    private String empLoc;

    @Column(name = "email")
    private String email;

    @Column(name = "location")
    private String location;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


}
