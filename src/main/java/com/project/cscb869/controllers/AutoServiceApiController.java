package com.project.cscb869.controllers;

import com.project.cscb869.data.dto.AutoServiceDto;
import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.entity.Worker;
import com.project.cscb869.data.model.AutoServiceModel;
import com.project.cscb869.services.AutoServiceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins={ "http://localhost:3000"})
@RequestMapping("/api/service")
public class AutoServiceApiController {
    private final static String ID = "/{id}";
    private final AutoServiceService autoServiceService;
    private final ModelMapper modelMapper;

    @GetMapping("/get-all")
    public List<AutoServiceDto> getAutoServices(){
        return autoServiceService.getServices()
                .stream()
                .map(this::convertToDto)
                .toList();
    }
    @GetMapping(ID)
    public AutoServiceDto getAutoService(@PathVariable("id") long id){
        return convertToDto(autoServiceService.getService(id));
    }
    @PostMapping
    public AutoServiceDto createAutoService(@RequestBody AutoServiceModel autoServiceModel){
        return convertToDto(autoServiceService.createService(convertToAutoService(autoServiceModel)));
    }

    @PutMapping(ID)
    public AutoService updateAutoService(@PathVariable("id") long id, @RequestBody AutoService autoService){
        return autoServiceService.updateService(id, autoService);
    }

    @DeleteMapping(ID)
    public void deleteAutoService(@PathVariable("id") long id){
        autoServiceService.deleteService(id);
    }

    @GetMapping(value = "/name/{name}")
    public AutoServiceDto getAutoServiceByName(@PathVariable("name") String name){
        return convertToDto(autoServiceService.getAutoServiceByName(name));
    }
    @PostMapping(value = "/{id}/add-worker")
    public AutoService addWorker(@PathVariable long id, @RequestBody Worker worker){
        return autoServiceService.addWorker(id, worker);
    }
    private AutoServiceDto convertToDto(AutoService autoService) {
        return modelMapper.map(autoService, AutoServiceDto.class);
    }
    private AutoService convertToAutoService(AutoServiceModel autoServiceModel){
        return modelMapper.map(autoServiceModel, AutoService.class);
    }
}
