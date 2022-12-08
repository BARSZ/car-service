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
public class WorkerApiController {
    private final WorkerService workerService;

    private final ModelMapper modelMapper;
    @GetMapping(value = "/api/workers")
    public List<Worker> getWorkers(){
        return workerService.getWorkers();
    }
    @GetMapping(value = "/api/workers/{id}")
    public WorkerDto getWorker(@PathVariable("id") long id){
        return modelMapper.map(workerService.getWorker(id), WorkerDto.class);
    }
    @PostMapping(value = "/api/workers")
    public Worker addWorker(@RequestBody Worker worker){
        return workerService.addWorker(worker);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/api/workers/{id}")
    public Worker updateWorker(@PathVariable("id") long id, @RequestBody Worker worker){
        return workerService.updateWorker(id, worker);
    }
    /*
    @PostMapping(value = "/api/workers/{worker-id}/add-service")
    public Worker addAutoService(@PathVariable("worker-id") long workerId, @RequestBody AutoService autoService){
        return workerService.assignAutoService(workerId, autoService);
    }
    */
}
