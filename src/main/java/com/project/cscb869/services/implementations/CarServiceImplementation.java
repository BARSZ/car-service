package com.project.cscb869.services.implementations;

import com.project.cscb869.data.entity.Car;
import com.project.cscb869.data.repository.CarRepository;
import com.project.cscb869.exceptions.NotFoundException;
import com.project.cscb869.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImplementation implements CarService {

    private final CarRepository carRepository;
    @Transactional
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Transactional
    @Override
    public Car getCar(long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Car with id "+id+" was not found!"));
    }
    @Transactional
    @Override
    public List<Car> getCarsByAutoServiceId(long id) {
        return carRepository.getCarsByAutoServiceId(id);
    }
    @Transactional
    @Override
    public List<Car> getCarsByClientId(long id) {
        return carRepository.getCarsByClientId(id);
    }
    @Transactional
    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }
    @Transactional
    @Override
    public Car updateCar(long id, Car car) {
        return carRepository.save(car);
    }

    @Transactional
    @Override
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }
}
