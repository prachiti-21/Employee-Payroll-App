package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/get/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Create a new employee using DTO
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    // Create a new employee using the entity (for backward compatibility)
    @PostMapping("/create-entity")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // Update an existing employee using DTO
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    // Update an existing employee using entity (for backward compatibility)
    @PutMapping("/update-entity/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    // Delete an employee by ID
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully!";
    }

    // Find employees by name
    @GetMapping("/findByName")
    public List<Employee> findEmployeesByName(@RequestParam String name) {
        return employeeService.findEmployeesByName(name);
    }

    // Find employees with salary greater than a given amount
    @GetMapping("/findBySalaryGreaterThan")
    public List<Employee> findEmployeesWithSalaryGreaterThan(@RequestParam double salary) {
        return employeeService.findEmployeesWithSalaryGreaterThan(salary);
    }

    // Find employees with salary less than a given amount
    @GetMapping("/findBySalaryLessThan")
    public List<Employee> findEmployeesWithSalaryLessThan(@RequestParam double salary) {
        return employeeService.findEmployeesWithSalaryLessThan(salary);
    }
}