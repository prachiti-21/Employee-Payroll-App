package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j  // Lombok Logging
@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 1; // Simulating auto-increment ID

    // Get all employees
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees. Total count: {}", employeeList.size());
        return employeeList;
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        Optional<Employee> employee = employeeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        if (employee.isPresent()) {
            log.debug("Employee found: ID={}, Name={}, Salary={}",
                    employee.get().getId(), employee.get().getName(), employee.get().getSalary());
        } else {
            log.error("Employee not found with ID: {}", id);
        }

        return employee;
    }

    // Create new employee (using DTO)
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(idCounter++); // Simulating auto-increment
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employeeList.add(employee);

        log.info("Created new employee: ID={}, Name={}, Salary={}",
                employee.getId(), employee.getName(), employee.getSalary());
        return employee;
    }

    // Create new employee (using existing entity)
    public Employee createEmployee(Employee employee) {
        employee.setId(idCounter++); // Assign a new ID
        employeeList.add(employee);

        log.info("Created new employee: ID={}, Name={}, Salary={}",
                employee.getId(), employee.getName(), employee.getSalary());
        return employee;
    }

    // Update existing employee (using DTO)
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        return getEmployeeById(id).map(employee -> {
            log.info("Updating employee with ID: {}", id);
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());

            log.info("Updated employee: ID={}, Name={}, Salary={}",
                    employee.getId(), employee.getName(), employee.getSalary());
            return employee;
        }).orElseThrow(() -> {
            log.error("Employee not found with ID: {}", id);
            return new RuntimeException("Employee not found");
        });
    }

    // Update existing employee (using entity)
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return getEmployeeById(id).map(employee -> {
            log.info("Updating employee with ID: {}", id);
            employee.setName(updatedEmployee.getName());
            employee.setSalary(updatedEmployee.getSalary());

            log.info("Updated employee: ID={}, Name={}, Salary={}",
                    employee.getId(), employee.getName(), employee.getSalary());
            return employee;
        }).orElseThrow(() -> {
            log.error("Employee not found with ID: {}", id);
            return new RuntimeException("Employee not found");
        });
    }

    // Delete employee by ID
    public void deleteEmployee(Long id) {
        boolean removed = employeeList.removeIf(employee -> employee.getId().equals(id));
        if (removed) {
            log.warn("Deleted employee with ID: {}", id);
        } else {
            log.error("Failed to delete employee. ID not found: {}", id);
        }
    }

    // Find employees by name
    public List<Employee> findEmployeesByName(String name) {
        List<Employee> result = employeeList.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        log.info("Found {} employees with name: {}", result.size(), name);
        log.debug("Employee details: {}", result);
        return result;
    }

    // Find employees with salary greater than a given amount
    public List<Employee> findEmployeesWithSalaryGreaterThan(double salary) {
        List<Employee> result = employeeList.stream()
                .filter(employee -> employee.getSalary() > salary)
                .collect(Collectors.toList());

        log.info("Found {} employees with salary greater than {}", result.size(), salary);
        log.debug("Employee details: {}", result);
        return result;
    }

    // Find employees with salary less than a given amount
    public List<Employee> findEmployeesWithSalaryLessThan(double salary) {
        List<Employee> result = employeeList.stream()
                .filter(employee -> employee.getSalary() < salary)
                .collect(Collectors.toList());

        log.info("Found {} employees with salary less than {}", result.size(), salary);
        log.debug("Employee details: {}", result);
        return result;
    }
}