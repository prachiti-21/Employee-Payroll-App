package com.example.Employee_Payroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmployeeService {

    // Synchronized list for thread safety
    private final List<Employee> employeeList = new ArrayList<>();

    // Counter to assign unique IDs
    private int employeeIdCounter = 1;

    // Method to return all the existing employees
    public List<Employee> getEmployeeList() {
        log.info("Fetching all the employees.");
        return employeeList;
    }

    // Method to get the employee by ID
    public Employee getEmployeeById(int id) {
        log.info("Fetching the employee with the ID: {}", id);
        return employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("No employee found with the Id: {}", id);
                    return new RuntimeException("No employee found with ID: " + id);
                });
    }

    // Method to create a new employee
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        // Assign unique ID
        employee.setId(employeeIdCounter++);
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());

        employeeList.add(employee);
        log.info("New employee created: {}", employee);
        return employee;
    }

    // Method to update an existing employee
    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        log.info("Updating employee with ID: {}", id);

        return employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .map(employee -> {
                    employee.setName(employeeDTO.getName());
                    employee.setSalary(employeeDTO.getSalary());
                    log.info("Updated employee details: {}", employee);
                    return employee;
                })
                .orElseThrow(() -> {
                    log.error("Employee not found with Id: {}", id);
                    return new RuntimeException("Employee not found with ID: " + id);
                });
    }

    // Method to delete an existing employee
    public boolean deleteEmployee(int id) {
        log.info("Deleting employee with ID: {}", id);
        Employee employeeToDelete = employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("Employee not found with ID: {}", id);
                    return new RuntimeException("Employee not found with ID: " + id);
                });

        boolean removed = employeeList.remove(employeeToDelete);
        if (removed) {
            log.info("Employee deleted successfully: {}", id);
        }
        return removed;
    }
}
