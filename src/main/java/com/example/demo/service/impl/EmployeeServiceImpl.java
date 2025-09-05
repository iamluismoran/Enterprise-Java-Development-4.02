package com.example.demo.service.impl;

import com.example.demo.enums.EmployeeStatus;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.interfaces.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getByStatus(EmployeeStatus status) {
        return employeeRepository.findByStatus(status);
    }

    @Override
    public List<Employee> getByDepartment(String department) {
        return employeeRepository.findByDepartmentIgnoreCase(department);
    }
}
