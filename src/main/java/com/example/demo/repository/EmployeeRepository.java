package com.example.demo.repository;

import com.example.demo.enums.EmployeeStatus;
import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByStatus(EmployeeStatus status);

    List<Employee> findByDepartmentIgnoreCase(String department);
}
