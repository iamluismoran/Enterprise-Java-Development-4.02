package com.example.demo.service.interfaces;

import com.example.demo.enums.EmployeeStatus;
import com.example.demo.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface PatientService {
    List<Patient> getAll();
    Patient getById(Long id);
    List<Patient> getByDobRange(LocalDate from, LocalDate to);
    List<Patient> getByDoctorDepartment(String department);
    List<Patient> getByDoctorStatus(EmployeeStatus status);
}
