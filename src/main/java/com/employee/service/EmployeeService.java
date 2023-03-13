package com.employee.service;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    final private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getEmployees() {
        return employeeDAO.findAll();
    }

}
