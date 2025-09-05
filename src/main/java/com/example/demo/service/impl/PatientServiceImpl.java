package com.example.demo.service.impl;

import com.example.demo.enums.EmployeeStatus;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.interfaces.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> getByDobRange(LocalDate from, LocalDate to) {
        return patientRepository.findByDateOfBirthBetween(from, to);
    }

    @Override
    public List<Patient> getByDoctorDepartment(String department) {
        return patientRepository.findByAdmittedByDepartmentIgnoreCase(department);
    }

    @Override
    public List<Patient> getByDoctorStatus(EmployeeStatus status) {
        return patientRepository.findByAdmittedByStatus(status);
    }
}
