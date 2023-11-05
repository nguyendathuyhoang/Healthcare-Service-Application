package com.SpringBoot.MVC.demo1.Controller;

import com.SpringBoot.MVC.demo1.Entity.MedicalExam;
import com.SpringBoot.MVC.demo1.Entity.Patient;
import com.SpringBoot.MVC.demo1.Repository.BookCheckRepository;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.BookCheckImpl;
import com.SpringBoot.MVC.demo1.Service.ServiceImpl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookCheckRest {
    @Autowired
    BookCheckImpl bookCheck;
    @Autowired
    PatientServiceImpl patientService;



//    @GetMapping(value = "/check/{id}")
//    public Optional<MedicalExam> getInfo(@PathVariable(name = "id") Long id)
//    {
//        return bookCheck.getInfo(id);
//    }

//    @GetMapping(value = "check/{checkId}")
//    public ResponseEntity getInfoById(@PathVariable(name = "checkId") Long id)
//    {
//        Optional<MedicalExam> medicalExam = bookCheck.findById(id);
//        if (medicalExam.isPresent())
//        {
////
//            return ResponseEntity.ok(medicalExam.get());
//
//        }
//        return ResponseEntity.notFound().build();
//    }

    @GetMapping(value = "check/{checkId}")
    public MedicalExam getInfoById(@PathVariable(name = "checkId") Long id)
    {
        Optional<MedicalExam> medicalExam = bookCheck.findById(id);
        if (medicalExam.isPresent())
        {
//
            return medicalExam.get();

        }
        return null;
    }

    @GetMapping("/findDoctorAndDay/{idDoctor}/{dayExam}/{idPatient}")
    public List<MedicalExam> findByDoctorAndDay(@PathVariable("idDoctor") Long idDoctor,
                                                @PathVariable("dayExam") String dayExam,
                                                @PathVariable("idPatient") Long idPatient)
    {
        List<MedicalExam> result =  bookCheck.findByDoctorAndDay(idDoctor, Date.valueOf(dayExam), idPatient);
        if (result!=null)
        {
            return result;
        }
        return null;
    }

    @GetMapping("/DoctorDayExam/{idDoctor}/{dayExam}/{idPatient}")
    public List<Patient> getPatientsByDoctor(@PathVariable("idDoctor") Long idDoctor,
                                             @PathVariable("dayExam") String dayExam,
                                             @PathVariable("idPatient") Long idPatient)
    {
        List<MedicalExam> medicalExams = bookCheck.findByDoctorAndDay(idDoctor,Date.valueOf(dayExam), idPatient);
        List<Patient> patientList = new ArrayList<>();
        for(MedicalExam medicalExam:medicalExams)
        {
            patientList.add(medicalExam.getPatient());
        }
        return patientList;

    }
}
