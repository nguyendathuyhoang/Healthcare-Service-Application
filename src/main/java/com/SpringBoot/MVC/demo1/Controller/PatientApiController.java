package com.SpringBoot.MVC.demo1.Controller;

import com.SpringBoot.MVC.demo1.Entity.Patient;
import com.SpringBoot.MVC.demo1.Repository.PatientRepository;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientApiController {
    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getPatientById(@PathVariable("id") long id) {
        Patient patient = patientService.findById(id);
        if (patient != null) {
            String patientInfo = "ID: " + patient.getId() + "<br>"
                    + "Tên: " + patient.getName() + "<br>"
                    + "Thông tin khác: ...";
            return ResponseEntity.ok(patientInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Các phương thức API khác
}
