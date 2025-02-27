package com.bridgelabz.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor  // Generates a no-args constructor
@AllArgsConstructor  // Generates a constructor with all fields
public class EmployeeDTO {
    private String name;
    private double salary;
    private String department;
    private String email;
}