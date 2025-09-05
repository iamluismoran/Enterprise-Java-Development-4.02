package com.example.demo.repository;

import com.example.demo.enums.EmployeeStatus;
import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByDateOfBirthBetween(LocalDate from, LocalDate to);

    List<Patient> findByAdmittedByDepartmentIgnoreCase(String department);

    List<Patient> findByAdmittedByStatus(EmployeeStatus status);
}
