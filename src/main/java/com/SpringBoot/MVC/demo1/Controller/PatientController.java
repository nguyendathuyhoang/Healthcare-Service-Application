package com.SpringBoot.MVC.demo1.Controller;

import com.SpringBoot.MVC.demo1.Entity.Doctor;
import com.SpringBoot.MVC.demo1.Entity.Patient;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.DoctorServiceImpl;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientServiceImpl patientService;

    @Autowired
    DoctorServiceImpl doctorService;

    // get homePage view
    @GetMapping(value = "/homePage")
    public String getHomePage()
    {
        return "hospital";
    }

    // get patient-form view
    @GetMapping(value = "/patient-form")
    public String showPatientForm(Model model)
    {
        model.addAttribute("patient",new com.SpringBoot.MVC.demo1.Entity.Patient());
        return "patient-add-form";
    }


    // Process adding patient
    @PostMapping(value = "/add-Patient")
    public String addPatient(@ModelAttribute com.SpringBoot.MVC.demo1.Entity.Patient patient)
    {
        patientService.addPatient(patient);
        return "hospital";
    }

    // get book-form view
    @GetMapping(value = "/book-form")
    public String showBookForm(Model model)
    {
        List<Doctor> doctor = doctorService.getAllDoctor();
        //Patient patient = patientService.findById(id);
        //model.addAttribute("medicalExam", new MedicalExam());
        //model.addAttribute("patient", new Patient());
        model.addAttribute("doctors",doctor);
        return "book-form1";
    }

    // Process find patient by id
    @PostMapping(value = "/searchByName")
    public String findById(@RequestParam("name") String name, Model model)
    {
//        Patient patient = patientService.findById(id);
        List<Patient> patients = patientService.findByName(name);
        model.addAttribute("patients", patients);
        return"patients-info";
    }

//    @GetMapping("/getPatientName")
//    @ResponseBody
//    public String getPatientName(@RequestParam("patientId") String patientId) {
//        // Logic để lấy tên bệnh nhân từ ID, ví dụ:
//        String patientName = patientService.findById(Long.parseLong(patientId)).getName();
//        return patientName;
//    }

    // get patient-form-search view
    @GetMapping("/search")
    public String showFormSearch()
    {
        return "patient-search-form";
    }

//    @PostMapping("/bookCheckExam")
//    public String getNameById(@RequestParam("patientId") String patientId, Model model)
//    {
//        Patient patient = patientService.findById(Long.parseLong(patientId));
//        model.addAttribute("patient",patient);
//        return "book-form";
//    }
}
