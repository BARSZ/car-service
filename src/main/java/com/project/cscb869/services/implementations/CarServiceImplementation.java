package com.project.cscb869.services.implementations;

import com.project.cscb869.data.entity.Car;
import com.project.cscb869.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImplementation implements CarService {
    @Transactional
    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Transactional
    @Override
    public Car getCar(long id) {
        return null;
    }

    @Transactional
    @Override
    public Car getCarByName(String name) {
        return null;
    }

    @Transactional
    @Override
    public Car addCar(Car car) {
        return null;
    }

    @Transactional
    @Override
    public Car updateCar(long id, Car car) {
        return null;
    }

    @Transactional
    @Override
    public void deleteCar(Car car) {

    }
}
