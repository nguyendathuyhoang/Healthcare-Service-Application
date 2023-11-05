package com.SpringBoot.MVC.demo1.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "dichvu")
public class HealthService {
    @Id
    @Column(name="madv")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idService;

    @Column(name = "tendv")
    private String nameService;

    @Column(name = "dongia")
    private Long price;


}
