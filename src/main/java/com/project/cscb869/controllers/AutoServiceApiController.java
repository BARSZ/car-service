package com.project.cscb869.controllers;

import com.project.cscb869.data.dto.AutoServiceDto;
import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.entity.Worker;
import com.project.cscb869.services.AutoServiceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins={ "http://localhost:3000"})
public class AutoServiceApiController {
    private final AutoServiceService autoServiceService;

    private final ModelMapper modelMapper;

    @GetMapping(value = "/api/services")
    public List<AutoService> getAutoServices(){
        return autoServiceService.getServices();
    }
    @GetMapping("/api/services/{id}")
    public AutoService getAutoService(@PathVariable("id") long id){
        //return convertToDto(autoServiceService.getService(id));
        return autoServiceService.getService(id);
    }
    @PostMapping(value = "/api/services")
    public AutoService createAutoService(@RequestBody AutoService autoService){
        return autoServiceService.createService(autoService);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/services/{id}")
    public AutoService updateAutoService(@PathVariable("id") long id, @RequestBody AutoService autoService){
        return autoServiceService.updateService(id, autoService);
    }

    @DeleteMapping(value = "/api/services/{id}")
    public void deleteAutoService(@PathVariable("id") long id){
        autoServiceService.deleteService(id);
    }

    @GetMapping(value = "/api/services/name/{name}")
    public AutoServiceDto getAutoServiceByName(@PathVariable("name") String name){
        return convertToDto(autoServiceService.getAutoServiceByName(name));
    }
    @PostMapping(value = "/api/services/{id}/add-worker")
    public AutoService addWorker(@PathVariable long id, @RequestBody Worker worker){
        return autoServiceService.addWorker(id, worker);
    }
    private AutoServiceDto convertToDto(AutoService autoService) {
        return modelMapper.map(autoService, AutoServiceDto.class);
    }
}
