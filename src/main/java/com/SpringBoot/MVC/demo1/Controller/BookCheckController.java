package com.SpringBoot.MVC.demo1.Controller;

import com.SpringBoot.MVC.demo1.Entity.Doctor;
import com.SpringBoot.MVC.demo1.Entity.MedicalExam;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.BookCheckImpl;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.DoctorServiceImpl;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class BookCheckController {
    @Autowired
    BookCheckImpl bookCheck;

    @Autowired
    DoctorServiceImpl doctorService;

    @Autowired
    PatientServiceImpl patientService;

    // Get the page view of book form
    @GetMapping("/bookCheckExam")
    public String showBookForm(Model model)
    {
        List<Doctor> doctors = doctorService.getAllDoctor();
        model.addAttribute("doctors",doctors);
        model.addAttribute("medicalExam", new MedicalExam());
        return "book-form1";
    }

    // add booking medical exam
    @PostMapping("/book-checkExam")
    public String bookExam(@ModelAttribute MedicalExam medicalExam)
    {
        bookCheck.addBookCheck(medicalExam);
        return "hospital";
    }
}
