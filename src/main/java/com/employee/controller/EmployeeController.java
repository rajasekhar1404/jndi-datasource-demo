package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getall")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }


}
