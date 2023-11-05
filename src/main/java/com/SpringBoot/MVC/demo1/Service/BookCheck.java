package com.SpringBoot.MVC.demo1.Service;

import com.SpringBoot.MVC.demo1.Entity.MedicalExam;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface BookCheck {
    Optional<MedicalExam> getInfo(Long id);
    Optional<MedicalExam> findById(Long id);

    MedicalExam addBookCheck(MedicalExam medicalExam);

    List<MedicalExam> findByDoctorAndDay(Long idDoctor, Date dayExam, Long idPatient);

    List<MedicalExam> findByDoctor_Id(Long idDoctor);

}
