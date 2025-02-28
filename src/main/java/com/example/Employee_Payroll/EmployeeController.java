package com.example.Employee_Payroll;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // GET method to get all employees
    @GetMapping("/allemployees")
    public List<Employee> getEmployees() {
        log.info("Request to fetch all the employees.");
        return employeeService.getEmployeeList();
    }

    // GET method to get employee by ID
    @GetMapping("/employee/{id}")
    public Employee getEmployeeByID(@PathVariable int id) {
        log.info("Request to fetch employee by Id.");
        return employeeService.getEmployeeById(id);
    }

    // POST method to create a new employee
    @PostMapping("/create")
    public Employee createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Request to create a new employee.");
        return employeeService.createEmployee(employeeDTO);
    }

    // PUT method to update an existing employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Request to update the existing employee.");
        return employeeService.updateEmployee(id, employeeDTO);
    }

    // DELETE method to remove an existing employee
    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable int id) {
        log.info("Request to delete the existing employee.");
        return employeeService.deleteEmployee(id);
    }
}
