package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Create new employee (using DTO)
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }

    // Create new employee (using existing entity)
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Update existing employee (using DTO)
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Update existing employee (using entity)
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setSalary(updatedEmployee.getSalary());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Delete employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Find employees by name
    public List<Employee> findEmployeesByName(String name) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Find employees with salary greater than a given amount
    public List<Employee> findEmployeesWithSalaryGreaterThan(double salary) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getSalary() > salary)
                .collect(Collectors.toList());
    }

    // Find employees with salary less than a given amount
    public List<Employee> findEmployeesWithSalaryLessThan(double salary) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getSalary() < salary)
                .collect(Collectors.toList());
    }
}