package com.SpringBoot.MVC.demo1.Controller;

import com.SpringBoot.MVC.demo1.Entity.Patient;
import com.SpringBoot.MVC.demo1.Repository.PatientRepository;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping("/search1")
    public Patient search(@RequestParam("id") Long id) {
        // Tìm kiếm bệnh nhân theo ID
        Patient patient = patientService.findById(id);
        return patient;
    }

//    @GetMapping("/search-form")
//    public String searchForm()
//    {
//        return "search";
//    }
}
