package com.SpringBoot.MVC.demo1.Service;

import com.SpringBoot.MVC.demo1.Entity.Patient;

import java.util.List;
import java.util.Optional;


public interface PatientService {
    List<Patient> getAllPatient();

    Patient getPatientByName(String name);

    Patient addPatient(Patient patient);

    String deletePatient(Long id);

    Patient updatePatient(Patient patient);

    Patient findById(Long id);

    List<Patient> findByName(String name);
}
