package com.project.cscb869.data.repository;

import com.project.cscb869.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car getCarByName(String name);
    List<Car> getCarsByAutoServiceId(long id);
    List<Car> getCarsByClientId(long id);
}
