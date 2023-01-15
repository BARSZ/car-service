package com.project.cscb869.services;

import com.project.cscb869.data.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    Car getCar(long id);
    Car addCar(Car car);
    Car updateCar(long id, Car car);
    void deleteCar(long id);
}
