package com.SpringBoot.MVC.demo1.Service.ServiceImpl;

import com.SpringBoot.MVC.demo1.Entity.MedicalExam;
import com.SpringBoot.MVC.demo1.Entity.Patient;
import com.SpringBoot.MVC.demo1.Repository.PatientRepository;
import com.SpringBoot.MVC.demo1.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository repository;

    public List<Patient> getAllPatient()
    {
        return repository.findAll();
    }

    public Patient getPatientByName(String name)
    {
        return repository.findPatientByName(name);
    }

    public Patient addPatient(Patient patient)
    {
        return repository.save(patient);
    }

    public String deletePatient(Long id)
    {
        repository.deleteById(id);
        return "Delete successfully "+ id;
    }

    public Patient updatePatient(Patient patient)
    {
        // check patient exist
        Patient current = (Patient) repository.findAllById(Collections.singleton(patient.getId()));
        if (current==null)
        {
            current = patient;
        }
        else {
            current.setName(patient.getName());
            current.setAddress(patient.getAddress());
            current.setGender(patient.getGender());
            current.setPhoneNumb(patient.getPhoneNumb());
            current.setDateOfBirth(patient.getDateOfBirth());
        }
        return repository.save(current);
    }

    public Patient findById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public List<Patient> findByName(String name)
    {
        return repository.findByName(name);
    }


}
