package com.employee.maintainence.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Integer id;

    @Column(name="department_name")
    private Integer deptName;

    @Column(name="department_code")
    private Integer deptCode;
}
