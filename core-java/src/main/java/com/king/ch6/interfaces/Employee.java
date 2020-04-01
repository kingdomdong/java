package com.king.ch6.interfaces;

public class Employee implements Comparable<Employee> {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public int compareTo(Employee otherEmployee) {
        return Double.compare(salary, otherEmployee.salary);
    }
}
