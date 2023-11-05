package com.SpringBoot.MVC.demo1.Controller;

import com.SpringBoot.MVC.demo1.Entity.Doctor;
import com.SpringBoot.MVC.demo1.Entity.MedicalExam;
import com.SpringBoot.MVC.demo1.Entity.Patient;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.BookCheckImpl;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.DoctorServiceImpl;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.HealthServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DetailBookingController {
    @Autowired
    BookCheckImpl bookCheck;
    @Autowired
    DoctorServiceImpl doctorService;

    @Autowired
    HealthServiceServiceImpl healthServiceService;

    // get page's find BookSchedule through doctor's name
    @GetMapping("/searchBookSchedule")
    public String searchSchedule(Model model)
    {

        // get all doctors to add dropdown menu
        List<Doctor> doctors = doctorService.getAllDoctor();
        model.addAttribute("doctors",doctors);
        return"searchBookSchedule";
    }

    // get page's addDetailBooking
    @GetMapping("/addDetailBooking")
    public String getDetailBooking(Model model)
    {
        List<Doctor> doctors = doctorService.getAllDoctor();
        model.addAttribute("doctors",doctors);
       return "detailBookCheck";
    }

}
