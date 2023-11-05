package com.SpringBoot.MVC.demo1.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "khambenh")
@Data
public class MedicalExam {
    @Id
    @Column(name = "makb", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExam;

    @Column(name = "mabn")
    private Long idPatient;

    @Column(name = "mabs")
    private Long idDoctor;

    @Column(name = "ngaykham")
    private Date dayExam;

    @Column(name = "yeucaukham")
    private String RequireExam;

    @Column(name = "ketluan", nullable = true)
    private String conclusion;

    @Column(name="thanhtoan", nullable = true)
    private boolean payment;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "mabn", insertable = false, updatable = false)
    private Patient patient;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "mabs",insertable = false,updatable = false)
    private Doctor doctor;



}
