package com.SpringBoot.MVC.demo1.Repository;

import com.SpringBoot.MVC.demo1.Entity.HealthService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthServiceRepository extends JpaRepository<HealthService,Long> {

}
