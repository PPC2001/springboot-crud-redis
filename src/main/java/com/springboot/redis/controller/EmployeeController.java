package com.springboot.redis.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.redis.model.Employee;
import com.springboot.redis.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        logger.info("Received request to create employee: {}", employee);
        employeeRepository.save(employee);
        logger.info("Employee saved successfully with ID: {}", employee.getEmpId());
        return ResponseEntity.ok("Employee saved successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        logger.info("Received request to get employee with ID: {}", id);
        Employee employee = employeeRepository.findById(id);
        if (employee != null) {
            logger.info("Employee found: {}", employee);
            return ResponseEntity.ok(employee);
        } else {
            logger.warn("Employee with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Map<Object, Object>> getAllEmployees() {
        logger.info("Received request to get all employees");
        Map<Object, Object> employees = employeeRepository.findAll();
        logger.info("Total employees found: {}", employees.size());
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        logger.info("Received request to delete employee with ID: {}", id);
        employeeRepository.delete(id);
        logger.info("Employee with ID: {} deleted successfully", id);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
}
