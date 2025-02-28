package com.example.Employee_Payroll;

// Custom exception for Employee not found scenario
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
