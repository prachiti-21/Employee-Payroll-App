package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    // In-memory storage for employee data
    private final List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 1; // Simulating auto-increment ID

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    // Create new employee (using DTO)
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(idCounter++); // Simulating auto-increment
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employeeList.add(employee);
        return employee;
    }

    // Create new employee (using existing entity)
    public Employee createEmployee(Employee employee) {
        employee.setId(idCounter++); // Assign a new ID
        employeeList.add(employee);
        return employee;
    }

    // Update existing employee (using DTO)
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        return getEmployeeById(id).map(employee -> {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            return employee;
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Update existing employee (using entity)
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return getEmployeeById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setSalary(updatedEmployee.getSalary());
            return employee;
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Delete employee by ID
    public void deleteEmployee(Long id) {
        employeeList.removeIf(employee -> employee.getId().equals(id));
    }

    // Find employees by name
    public List<Employee> findEmployeesByName(String name) {
        return employeeList.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Find employees with salary greater than a given amount
    public List<Employee> findEmployeesWithSalaryGreaterThan(double salary) {
        return employeeList.stream()
                .filter(employee -> employee.getSalary() > salary)
                .collect(Collectors.toList());
    }

    // Find employees with salary less than a given amount
    public List<Employee> findEmployeesWithSalaryLessThan(double salary) {
        return employeeList.stream()
                .filter(employee -> employee.getSalary() < salary)
                .collect(Collectors.toList());
    }
}