package com.project.cscb869.controllers.view;

import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.services.AutoServiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/services")
public class AutoServiceController {
    private AutoServiceService autoService;

    @GetMapping
    public String getServices(Model model){
        final List<AutoService> services = autoService.getServices();
        model.addAttribute("services", services);
        return "/services/services.html";
    }
    @GetMapping("/create-service")
    public String showCreateServiceForm(Model model){
        model.addAttribute("service", new AutoService());
        return "/services/create-service";
    }
    @PostMapping("/create")
    public String createService(@ModelAttribute AutoService autoService){
        this.autoService.createService(autoService);
        return "redirect:/services";
    }

    @GetMapping("/edit-service/{id}")
    public String showEditServiceForm(Model model, @PathVariable long id){
        model.addAttribute("service", autoService.getService(id));
        return "/services/edit-service";
    }
    @PostMapping("/update/{id}")
    public String editService(Model model, @PathVariable long id, AutoService autoService){
        this.autoService.updateService(id, autoService);
        return "redirect:/services";
    }
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable long id){
        autoService.deleteService(id);
        return "redirect:/services";
    }
}
