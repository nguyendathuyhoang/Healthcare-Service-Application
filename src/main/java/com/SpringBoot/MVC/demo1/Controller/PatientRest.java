package com.SpringBoot.MVC.demo1.Controller;

import com.SpringBoot.MVC.demo1.Entity.Patient;
import com.SpringBoot.MVC.demo1.Repository.PatientRepository;
import com.SpringBoot.MVC.demo1.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientRest {
    @Autowired
    PatientService patientService;

    @Autowired
    PatientRepository patientRepository;

    @GetMapping(value = "/getAllPatient")
    public List<Patient> getAllPatient()
    {
        return patientService.getAllPatient();
    }

    @GetMapping(value = "/getPatientByName/{name}")
    public Patient findByName(@PathVariable(name="name") String name)
    {
        return patientService.getPatientByName(name);
    }

//    @PostMapping(value = "/addPatient")
//    public ResponseEntity addPatient(@RequestBody Patient patient)
//    {
//        // check id if exist
//        Long checkId = patient.getId();
//
//        if (checkId!=null)
//        {
//            if (patientRepository.existsById(checkId))
//            {
//                return ResponseEntity.status(HttpStatus.CONFLICT).body("Id already exists");
//            }
//        }
//        patientService.addPatient(patient);
//        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
//    }
    @GetMapping(value = "/patients/{id}")
    public Patient findById(@PathVariable(name = "id") Long id)
    {
        return patientService.findById(id);
    }

    @DeleteMapping(value = "/deletePatient/{id}")
    public String deletePatient(@PathVariable(name = "id") Long id)
    {
        return patientService.deletePatient(id);
    }

    @PutMapping(value = "/update")
    public Patient updatePatient(@RequestBody Patient patient)
    {
        return patientService.updatePatient(patient);
    }
}
