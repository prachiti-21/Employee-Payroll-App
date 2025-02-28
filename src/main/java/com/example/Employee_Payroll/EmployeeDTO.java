package com.example.Employee_Payroll;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

// Data Transfer Object (DTO) for Employee.
@Data
public class EmployeeDTO {
    @NotBlank(message = "Name cannot be empty.")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "First letter in uppercase, minimum 3 letters are required.")
    private String name;
    private double salary;
}




