package com.example.Employee_Payroll;

import lombok.Getter;
import lombok.Setter;

// Model class representing an Employee entity.
@Setter
@Getter
public class Employee {
    // Getters and Setters
    private int id;
    private String name;
    private double salary;

    // Default Constructor
     public Employee(){}

    // Parameterised Constructor
    public Employee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

}
