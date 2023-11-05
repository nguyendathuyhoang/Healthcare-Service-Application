package com.SpringBoot.MVC.demo1.Service.ServiceImpl;

import com.SpringBoot.MVC.demo1.Entity.Doctor;
import com.SpringBoot.MVC.demo1.Repository.DoctorRepository;
import com.SpringBoot.MVC.demo1.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public Optional<Doctor> findById(Long id)
    {
        return doctorRepository.findById(id);
    }

    public Doctor findByName(String name)
    {
        return doctorRepository.findByName(name);
    }

    public List<Doctor> getAllDoctor()
    {
        return doctorRepository.findAll();
    }
}
