package com.SpringBoot.MVC.demo1.Service;

import com.SpringBoot.MVC.demo1.Entity.Doctor;

import java.util.List;
import java.util.Optional;


public interface DoctorService {
    Doctor findByName(String name);
    Optional<Doctor> findById(Long id);

    List<Doctor> getAllDoctor();
}
