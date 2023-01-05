package com.project.cscb869.controllers.view;

import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.model.AutoServiceModel;
import com.project.cscb869.services.AutoServiceService;
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
    private ModelMapper modelMapper;
    @GetMapping
    public String getServices(Model model){
        final List<AutoService> services = autoService.getServices();
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
}
