package com.project.cscb869.services.implementations;

import com.project.cscb869.data.entity.Car;
import com.project.cscb869.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImplementation implements CarService {
    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public Car getCar(long id) {
        return null;
    }

    @Override
    public Car getCarByName(String name) {
        return null;
    }

    @Override
    public Car addCar(Car car) {
        return null;
    }

    @Override
    public Car updateCar(long id, Car car) {
        return null;
    }

    @Override
    public void deleteCar(Car car) {

    }
}
