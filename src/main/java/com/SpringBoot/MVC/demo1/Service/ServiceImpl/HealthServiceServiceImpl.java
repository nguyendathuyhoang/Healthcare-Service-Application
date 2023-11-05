package com.SpringBoot.MVC.demo1.Service.ServiceImpl;

import com.SpringBoot.MVC.demo1.Entity.HealthService;
import com.SpringBoot.MVC.demo1.Repository.HealthServiceRepository;
import com.SpringBoot.MVC.demo1.Service.HealthServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthServiceServiceImpl implements HealthServiceService {
    @Autowired
    HealthServiceRepository healthServiceRepository;

    public List<HealthService> getAllService()
    {
        return healthServiceRepository.findAll();
    }
}
