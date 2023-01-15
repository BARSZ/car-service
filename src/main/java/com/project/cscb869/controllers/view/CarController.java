package com.project.cscb869.controllers.view;

import com.project.cscb869.data.dto.CarDto;
import com.project.cscb869.data.entity.Car;
import com.project.cscb869.data.model.CarModel;
import com.project.cscb869.services.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/car")
public class CarController {
    private CarService carService;
    private ModelMapper modelMapper;

    @GetMapping
    public String getCars(Model model){
        final List<CarDto> cars = carService.getAllCars()
                .stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .toList();
        model.addAttribute("cars", cars);
        return "/car/showCars";
    }
    @GetMapping("/create-car")
    public String showCreateCarForm(Model model){
        model.addAttribute("car", new CarModel());
        return "/car/create-car";
    }
    @PostMapping("/create")
    public String createCar(@Valid @ModelAttribute("car") CarModel carModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/car/create-car";
        }
        carService.addCar(modelMapper.map(carModel, Car.class));
        return "redirect:/car";
    }
    @GetMapping("/edit-car/{id}")
    public String showEditCarForm(Model model, @PathVariable long id){
        model.addAttribute("car", carService.getCar(id));
        return "/car/edit-car";
    }
    @PostMapping("/update/{id}")
    public String editCar(Model model, @PathVariable long id, Car car){
        carService.updateCar(id, car);
        return "redirect:/car";
    }
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable long id){
        carService.deleteCar(id);
        return "redirect:/car";
    }
}





















