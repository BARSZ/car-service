package com.project.cscb869.controllers.api;

import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.services.AutoServiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AutoServiceApiController {
    private final AutoServiceService autoServiceService;

    @GetMapping(value = "/api/services")
    public List<AutoService> getAutoServices(){
        return autoServiceService.getServices();
    }

    @RequestMapping("/api/services/{id}")
    public AutoService getAutoService(@PathVariable("id") long id){
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

    @GetMapping(value = "api/services/{name}")
    public AutoService getAutoServiceByName(@PathVariable("name") String name){
        return autoServiceService.getAutoServiceByName(name);
    }
}
