package com.project.cscb869.controllers;

import com.project.cscb869.data.dto.WorkerDto;
import com.project.cscb869.data.entity.Worker;
import com.project.cscb869.services.WorkerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(value = "http://localhost:3000/")
@RequestMapping("/api/worker")
public class WorkerApiController {
    private final static String ID = "/{id}";
    private final WorkerService workerService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<Worker> getWorkers(){
        return workerService.getWorkers();
    }
    @GetMapping(ID)
    public WorkerDto getWorker(@PathVariable("id") long id){
        return modelMapper.map(workerService.getWorker(id), WorkerDto.class);
    }
    @PostMapping
    public Worker addWorker(@RequestBody Worker worker){
        return workerService.addWorker(worker);
    }
    @PutMapping(ID)
    public Worker updateWorker(@PathVariable("id") long id, @RequestBody Worker worker){
        return workerService.updateWorker(id, worker);
    }
}
