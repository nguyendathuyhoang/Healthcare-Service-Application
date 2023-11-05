package com.SpringBoot.MVC.demo1.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bacsi")
@Data
public class Doctor {
    @Id
    @Column(name = "mabs", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tenbs")
    private String name;

//    @OneToOne(mappedBy = "doctor")
//    private MedicalExam medicalExam;
}
