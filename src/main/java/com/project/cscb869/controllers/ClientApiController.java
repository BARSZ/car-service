package com.project.cscb869.controllers;

import com.project.cscb869.data.entity.Client;
import com.project.cscb869.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientApiController {
    private final ClientService clientService;

    @GetMapping(value = "/api/clients")
    public List<Client> getClients(){
        return clientService.getClients();
    }
    @GetMapping(value = "/api/clients/{id}")
    public Client getClient(@PathVariable long id){
        return clientService.getClient(id);
    }
    @PostMapping(value = "/api/clients")
    public Client getClient(@RequestBody Client client){
        return clientService.createClient(client);
    }
    @RequestMapping(value = "/api/clients/{id}", method = RequestMethod.PUT)
    public Client updateClient(@RequestBody Client client, @PathVariable long id){
        return clientService.updateClient(client, id);
    }
    @DeleteMapping(value = "/api/clients/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
    }
    @PostMapping(value = "/api/clients/schedule-service/{id}")
    public boolean scheduleService(@PathVariable long id, @RequestBody long carId){
        clientService.CanScheduleService(carId, id);
        return true;
    }
}
