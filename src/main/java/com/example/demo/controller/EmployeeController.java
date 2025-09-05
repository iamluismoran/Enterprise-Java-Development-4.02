package com.example.demo.controller;


import com.example.demo.enums.EmployeeStatus;
import com.example.demo.model.Employee;
import com.example.demo.service.interfaces.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // Get all doctors
    @GetMapping
    public List<Employee> all() {
        return employeeService.getAll();
    }

    // Get doctor by employee_id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> byId(@PathVariable Long id) {
        Employee e = employeeService.getById(id);
        return e == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(e);
    }

    // Get doctors by status (usa valores en MAYÚSCULAS: ON, OFF, ON_CALL)
    @GetMapping("/status/{status}")
    public List<Employee> byStatus(@PathVariable EmployeeStatus status) {
        return employeeService.getByStatus(status);
    }

    // Get doctors by department
    @GetMapping("/department/{department}")
    public List<Employee> byDepartment(@PathVariable String department) {
        return employeeService.getByDepartment(department);
    }
}
