package com.example.demo.util;

import com.example.demo.enums.EmployeeStatus;
import com.example.demo.model.Employee;
import com.example.demo.model.Patient;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;

    @Override
    @Transactional
    public void run(String... args) {
        var e1 = Employee.builder().employeeId(356712L).department("cardiology").name("Alonso Flores").status(EmployeeStatus.ON_CALL).build();
        var e2 = Employee.builder().employeeId(564134L).department("immunology").name("Sam Ortega").status(EmployeeStatus.ON).build();
        var e3 = Employee.builder().employeeId(761527L).department("cardiology").name("German Ruiz").status(EmployeeStatus.OFF).build();
        var e4 = Employee.builder().employeeId(166552L).department("pulmonary").name("Maria Lin").status(EmployeeStatus.ON).build();
        var e5 = Employee.builder().employeeId(156545L).department("orthopaedic").name("Paolo Rodriguez").status(EmployeeStatus.ON_CALL).build();
        var e6 = Employee.builder().employeeId(172456L).department("psychiatric").name("John Paul Armes").status(EmployeeStatus.OFF).build();

        employeeRepository.saveAll(List.of(e1, e2, e3, e4, e5, e6));

        var p1 = Patient.builder().name("Jaime Jordan").dateOfBirth(LocalDate.parse("1984-03-02")).admittedBy(e2).build();
        var p2 = Patient.builder().name("Marian Garcia").dateOfBirth(LocalDate.parse("1972-01-12")).admittedBy(e2).build();
        var p3 = Patient.builder().name("Julia Dusterdieck").dateOfBirth(LocalDate.parse("1954-06-11")).admittedBy(e1).build();
        var p4 = Patient.builder().name("Steve McDuck").dateOfBirth(LocalDate.parse("1931-11-10")).admittedBy(e3).build();
        var p5 = Patient.builder().name("Marian Garcia").dateOfBirth(LocalDate.parse("1999-02-15")).admittedBy(e6).build();

        patientRepository.saveAll(List.of(p1, p2, p3, p4, p5));

        System.out.println(">>> Seed OK: 6 employees and 5 patients");
    }
}
