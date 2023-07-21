package com.employee.maintainence.util;

import lombok.Data;

import java.util.*;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;

public class EmployeeComparator {

    public static void main(String[] args){

        class Employee{

            Integer empId;
            String empName;
            Integer empSalary;
            String empLocation;
            String empDepartment;

            public Employee() {
            }

            public Employee(Integer empId, String empName, Integer empSalary, String empLocation, String empDepartment) {
                this.empId = empId;
                this.empName = empName;
                this.empSalary = empSalary;
                this.empLocation = empLocation;
                this.empDepartment = empDepartment;
            }

            public Integer getEmpId() {
                return empId;
            }

            public void setEmpId(Integer empId) {
                this.empId = empId;
            }

            public String getEmpName() {
                return empName;
            }

            public void setEmpName(String empName) {
                this.empName = empName;
            }

            public Integer getEmpSalary() {
                return empSalary;
            }

            public void setEmpSalary(Integer empSalary) {
                this.empSalary = empSalary;
            }

            public String getEmpLocation() {
                return empLocation;
            }

            public void setEmpLocation(String empLocation) {
                this.empLocation = empLocation;
            }

            public String getEmpDepartment() {
                return empDepartment;
            }

            public void setEmpDepartment(String empDepartment) {
                this.empDepartment = empDepartment;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Employee employee = (Employee) o;
                return Objects.equals(empId, employee.empId) && Objects.equals(empName, employee.empName) && Objects.equals(empSalary, employee.empSalary) && Objects.equals(empLocation, employee.empLocation) && Objects.equals(empDepartment, employee.empDepartment);
            }

            @Override
            public int hashCode() {
                return Objects.hash(empId, empName, empSalary, empLocation, empDepartment);
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "empId=" + empId +
                        ", empName='" + empName + '\'' +
                        ", empSalary='" + empSalary + '\'' +
                        ", empLocation='" + empLocation + '\'' +
                        ", empDepartment='" + empDepartment + '\'' +
                        '}';
            }
        }

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1,"Prateek",
                50000,"Mumbai","IT"));
        employeeList.add(new Employee(2,"Mandal",
                55000,"Kolkata","SL"));
        employeeList.add(new Employee(3,"Poulami",
                60000,"Kolkata","AC"));
        employeeList.add(new Employee(4,"Manna",
                70000,"Bangalore","AC"));
        employeeList.add(new Employee(5,"Kumar",
                30000,"Delhi","IT"));
        employeeList.add(new Employee(6,"Rishabh",
                40000,"Mumbai","HR"));
        employeeList.add(new Employee(7,"Shubham",
                35000,"Mumbai","OPS"));

       System.out.println("List :" +employeeList.toString());

       Optional<Integer> maxSalary = employeeList.stream().map(Employee::getEmpSalary).max(Integer::compareTo);

       maxSalary.ifPresent(salary->System.out.println("Max Salary :"+salary));

       Optional<Integer> minSalary = employeeList.stream().map(Employee::getEmpSalary).min(Integer::compareTo);

        minSalary.ifPresent(salary->System.out.println("Max Salary :"+salary));

       List<Employee> sortedList = employeeList.stream().sorted(Comparator.comparingInt(Employee::getEmpSalary).reversed()).collect(Collectors.toList());

       System.out.println("SortedList :" +sortedList);

        List<Employee> rangeList = employeeList.stream().filter(employee -> employee.getEmpSalary()>=30000 && employee.getEmpSalary()<=50000).sorted(Comparator.comparingInt(Employee::getEmpSalary)).collect(Collectors.toList());

        System.out.println("rangeList :" +rangeList);

        List<Employee> evenSalary = employeeList.stream().filter(employee -> employee.getEmpSalary()%11==0).collect(Collectors.toList());

        System.out.println("evenSalary :" +evenSalary);

        List<Employee> localeEmp = employeeList.stream().filter(employee -> employee.getEmpLocation().equals("Mumbai")).collect(Collectors.toList());

        System.out.println("localeEmp :" +localeEmp);



      /* Comparator<Employee> sortedEmployee = new Comparator<Employee>() {
           @Override
           public int compare(Employee o1, Employee o2) {
                return Integer.compare(o2.getEmpSalary(),o1.getEmpSalary());
           }
       };*/



    }

}

