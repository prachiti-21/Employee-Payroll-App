package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;

@Entity  // Represents a database table
@Table(name = "employees") // Table name in MySQL
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double salary;
    private String department; // New field
    private String email;      // New field

    // Constructors
    public Employee() {}

    public Employee(String name, double salary, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}