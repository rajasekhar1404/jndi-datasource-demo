package com.employee.dao;

import com.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
