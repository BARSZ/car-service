package com.project.cscb869.data.repository;

import com.project.cscb869.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
