package com.project.cscb869.controllers.view;

import com.project.cscb869.data.dto.WorkerDto;
import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.entity.Worker;
import com.project.cscb869.data.model.WorkerModel;
import com.project.cscb869.services.AutoServiceService;
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
@RequestMapping("/worker")
public class WorkerController {
    private WorkerService workerService;
    private ModelMapper modelMapper;
    private AutoServiceService autoService;
    @GetMapping
    public String getWorkers(Model model){
        final List<WorkerDto> workers = workerService.getWorkers()
                .stream()
                .map(worker -> modelMapper.map(worker, WorkerDto.class))
                .toList();
        model.addAttribute("workers", workers);
        return "/worker/showWorkers";
    }
    @GetMapping("/create-worker")
    public String showCreateWorkerForm(Model model){
        model.addAttribute("worker", new WorkerModel());
        return "/worker/create-worker";
    }
    @PostMapping("/create")
    public String createWorker(@Valid @ModelAttribute("worker") WorkerModel workerModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/worker/create-worker";
        }
        workerService.addWorker(modelMapper.map(workerModel, Worker.class));
        return "redirect:/worker";
    }
    @GetMapping("/delete/{id}")
    public String deleteWorker(@PathVariable long id){
        workerService.deleteWorker(id);
        return "redirect:/worker";
    }
    @GetMapping("/edit-worker/{id}")
    public String showEditWorkerForm(Model model, @PathVariable long id){
        model.addAttribute("worker", workerService.getWorker(id));
        return "/worker/edit-worker";
    }
    @PostMapping("/update/{id}")
    public String editWorker(Model model, @PathVariable long id, Worker worker){
        AutoService autoServiceFound = new AutoService();
        for (AutoService autoService1 : autoService.getServices())
        {
            for (Worker worker1 : autoService1.getWorkers())
            {
                if(worker1.getId() == id){
                    autoServiceFound = autoService1;
                }
            }
        }
        worker.setAutoService(autoServiceFound);
        workerService.updateWorker(id, worker);
        return "redirect:/worker";
    }
}
