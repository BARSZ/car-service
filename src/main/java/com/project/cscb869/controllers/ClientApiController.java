package com.project.cscb869.controllers;

import com.project.cscb869.data.entity.Client;
import com.project.cscb869.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins={ "http://localhost:3000"})
@RequestMapping("/api/client")
public class ClientApiController {
    private final static String ID = "/{id}";
    private final ClientService clientService;
    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }
    @GetMapping(ID)
    public Client getClient(@PathVariable long id){
        return clientService.getClient(id);
    }
    @PostMapping
    public Client getClient(@RequestBody Client client){
        return clientService.createClient(client);
    }
    @PutMapping(ID)
    public Client updateClient(@RequestBody Client client, @PathVariable long id){
        return clientService.updateClient(client, id);
    }
    @DeleteMapping(ID)
    public void deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
    }
    @PostMapping(value = "/schedule-service/{id}")
    public boolean scheduleService(@PathVariable long id, @RequestBody long carId){
        clientService.CanScheduleService(carId, id);
        return true;
    }
}
