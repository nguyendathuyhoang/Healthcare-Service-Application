package com.SpringBoot.MVC.demo1.Repository;

import com.SpringBoot.MVC.demo1.Entity.MedicalExam;
import com.SpringBoot.MVC.demo1.Entity.Patient;
import lombok.experimental.PackagePrivate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.util.List;

@Repository
public interface BookCheckRepository extends JpaRepository<MedicalExam,Long> {

//    @Query("select a from MedicalExam a where a.idDoctor=:idDoctor and a.dayExam=:dayExam")
//    List<MedicalExam> findByDoctorAndDay(@Param("idDoctor") Long idDoctor,
//                                         @Param("dayExam") Date dayExam);
//    List<MedicalExam> findByDoctorAndDay(Long idDoctor, Date dayExam);

    List<MedicalExam> findByDoctor_Id(Long idDoctor);

    //List<MedicalExam> findByDoctor_IdAndAndDayExam(Long Id, Date dayExam, Long idPatient);

    List<MedicalExam> findByDoctor_IdAndAndDayExamAndIdPatient(Long idDoctor, Date dayExam, Long idPatient);



}
