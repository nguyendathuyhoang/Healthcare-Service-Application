package com.SpringBoot.MVC.demo1.Repository;

import com.SpringBoot.MVC.demo1.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor findByName(String name);
}
