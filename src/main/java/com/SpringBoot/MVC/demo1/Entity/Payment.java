package com.SpringBoot.MVC.demo1.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "thuphi")
@Data
public class Payment {
    @Id
    @Column(name="makb")
    private Long idExam;

    @Id
    @Column(name = "madv")
    private Long idService;

    @Column(name="soluong")
    private int quantity;

    @Column(name="dongia")
    private Long price;

    @ManyToOne
    @JoinColumn(name="makb", insertable = false, updatable = false)
    private MedicalExam medicalExam;

    @ManyToOne
    @JoinColumn(name="madv", insertable = false,updatable = false)
    private HealthService healthService;
}
