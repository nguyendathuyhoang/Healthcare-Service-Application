package com.SpringBoot.MVC.demo1.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;

@Entity
@Table(name="benhnhan")
@Data
public class Patient {
    @Id
    @Column(name="mabn", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="tenbn")
    private String name;

    @Column(name="ngsinh")
    private Date dateOfBirth;

    @Column(name = "diachi")
    private String address;

    @Column(name="dthoai")
    private String phoneNumb;

    @Column(name="gioitinh")
    private int gender;

//    @OneToOne(mappedBy = "patient")
//    private MedicalExam medicalExam;



//    public String getDateOfBirth() {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        return df.format(dateOfBirth);
//    }

//    public String getPhoneNumb()
//    {
//        return "0"+phoneNumb;
//    }

//    public String getGender()
//    {
//        if (gender==1) return "Male";
//        return "Female";
//    }

    // check number is valid

    // check gmail is valid
}
