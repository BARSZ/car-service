package com.project.cscb869.controllers.view;

import com.project.cscb869.data.dto.AutoServiceDto;
import com.project.cscb869.data.dto.CarDto;
import com.project.cscb869.data.dto.WorkerDto;
import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.model.AutoServiceModel;
import com.project.cscb869.services.AutoServiceService;
import com.project.cscb869.services.CarService;
import com.project.cscb869.services.WorkerService;
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
@RequestMapping("/service")
public class AutoServiceController {
    private AutoServiceService autoService;
    private WorkerService workerService;
    private CarService carService;
    private ModelMapper modelMapper;
    @GetMapping
    public String getServices(Model model){
        final List<AutoServiceDto> services = autoService.getServices()
                .stream()
                .map(autoService -> modelMapper.map(autoService, AutoServiceDto.class))
                .toList();
        model.addAttribute("services", services);
        return "/service/services.html";
    }
    @GetMapping("/create-service")
    public String showCreateServiceForm(Model model){
        model.addAttribute("service", new AutoServiceModel());
        return "/service/create-service";
    }
    @PostMapping("/create")
    public String createService(@Valid @ModelAttribute("service") AutoServiceModel autoServiceModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/service/create-service";
        }
        autoService.createService(modelMapper.map(autoServiceModel, AutoService.class));
        return "redirect:/service";
    }
    @GetMapping("/edit-service/{id}")
    public String showEditServiceForm(Model model, @PathVariable long id){
        model.addAttribute("service", autoService.getService(id));
        return "/service/edit-service";
    }
    @PostMapping("/update/{id}")
    public String editService(Model model, @PathVariable long id, AutoService autoService){
        this.autoService.updateService(id, autoService);
        return "redirect:/service";
    }
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable long id){
        autoService.deleteService(id);
        return "redirect:/service";
    }
    @GetMapping("/get-workers/{id}")
    public String getWorkersForService(@PathVariable long id, Model model){
        final List<WorkerDto> workers = workerService.getWorkersForAutoService(id)
                .stream()
                .map(worker -> modelMapper.map(worker, WorkerDto.class))
                .toList();
        model.addAttribute("workers", workers);
        return "/worker/showWorkers";
    }
    @GetMapping("/get-cars/{id}")
    public String getCarsForService(@PathVariable long id, Model model){
        final List<CarDto> cars = carService.getCarsByAutoServiceId(id)
                .stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .toList();
        model.addAttribute("cars", cars);
        return "/car/showCars";
    }
}
