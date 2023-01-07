package com.project.cscb869.controllers.view;

import com.project.cscb869.data.dto.ClientDto;
import com.project.cscb869.data.entity.Client;
import com.project.cscb869.data.model.ClientModel;
import com.project.cscb869.services.ClientService;
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
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;
    private ModelMapper modelMapper;
    @GetMapping
    public String getClients(Model model){
        final List<ClientDto> clients = clientService.getClients()
                .stream()
                .map(client -> modelMapper.map(client, ClientDto.class))
                .toList();
        model.addAttribute("clients", clients);
        return "/client/showClients.html";
    }
    @GetMapping("/create-client")
    public String showCreateClientForm(Model model){
        model.addAttribute("client", new ClientModel());
        return "/client/create-client";
    }
    @PostMapping("/create")
    public String createClient(@Valid @ModelAttribute("client") ClientModel clientModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/client/create-client";
        }
        clientService.createClient(modelMapper.map(clientModel, Client.class));
        return "redirect:/client";
    }
    @GetMapping("/edit-client/{id}")
    public String showEditClientForm(Model model, @PathVariable long id){
        model.addAttribute("client", clientService.getClient(id));
        return "/client/edit-client";
    }
    @PostMapping("/update/{id}")
    public String editClient(Model model, @PathVariable long id, ClientModel clientModel){
        clientService.updateClient(modelMapper.map(clientModel, Client.class), id);
        return "redirect:/client";
    }
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
        return "redirect:/client";
    }
}
