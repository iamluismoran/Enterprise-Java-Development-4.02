package com.example.demo.service.interfaces;

import com.example.demo.enums.EmployeeStatus;
import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(Long id);
    List<Employee> getByStatus(EmployeeStatus status);
    List<Employee> getByDepartment(String department);
}
