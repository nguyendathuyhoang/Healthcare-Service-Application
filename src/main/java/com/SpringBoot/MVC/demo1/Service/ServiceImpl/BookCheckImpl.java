package com.SpringBoot.MVC.demo1.Service.ServiceImpl;

import com.SpringBoot.MVC.demo1.Entity.MedicalExam;
import com.SpringBoot.MVC.demo1.Repository.BookCheckRepository;
import com.SpringBoot.MVC.demo1.Service.BookCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookCheckImpl implements BookCheck {
    @Autowired
    BookCheckRepository bookCheckRepository;


    public Optional<MedicalExam> getInfo(Long id)
    {
        return bookCheckRepository.findById(id);
    }

    public Optional<MedicalExam> findById(Long id)
    {
        return bookCheckRepository.findById(id);
    }

    public MedicalExam addBookCheck(MedicalExam medicalExam)
    {
        return bookCheckRepository.save(medicalExam);
    }

    @Override
    public List<MedicalExam> findByDoctorAndDay(Long idDoctor, Date dayExam, Long idPatient) {
        return bookCheckRepository.findByDoctor_IdAndAndDayExamAndIdPatient(idDoctor, dayExam, idPatient);
    }

    @Override
    public List<MedicalExam> findByDoctor_Id(Long idDoctor) {
        return bookCheckRepository.findByDoctor_Id(idDoctor);
    }

//    public List<MedicalExam> findByDoctorAndDay(Long idDoctor, Date dayExam) {
//        return bookCheckRepository.findByDoctorAndDay(idDoctor,dayExam);
//    }



}
