package com.bridgelabz.employeepayrollapp.dto;

public class EmployeeDTO {
    private String name;
    private double salary;
    private String department;  // New field
    private String email;       // New field

    // Default Constructor
    public EmployeeDTO() {}

    // Constructor with all fields
    public EmployeeDTO(String name, double salary, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.email = email;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}