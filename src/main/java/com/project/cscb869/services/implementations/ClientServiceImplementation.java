package com.project.cscb869.services.implementations;

import com.project.cscb869.data.entity.*;
import com.project.cscb869.data.repository.AutoServiceRepository;
import com.project.cscb869.data.repository.CarRepository;
import com.project.cscb869.data.repository.ClientRepository;
import com.project.cscb869.exceptions.NotFoundException;
import com.project.cscb869.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImplementation implements ClientService {
    private final ClientRepository clientRepository;
    private final AutoServiceRepository autoServiceRepository;
    private final CarRepository carRepository;

    @Transactional
    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Transactional
    @Override
    public Client getClient(long id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with id "+ id +" doesn't exist!"));
    }

    @Transactional
    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    @Override
    public Client updateClient(Client client, long id) {
        if(clientRepository.findById(id).isPresent()){
            client.setId(id);
            return clientRepository.save(client);
        }else{
            throw new NotFoundException("Client with id " + id + "doesn't exist!");
        }
    }

    @Transactional
    @Override
    public void deleteClient(long id) {
        if(clientRepository.findById(id).isPresent()){
            clientRepository.deleteById(id);
        }else{
            throw new NotFoundException("Client with id " + id + "doesn't exist!");
        }
    }

    @Transactional
    @Override
    public void CanScheduleService(long carId, long serviceId){
        if(carRepository.findById(carId).isPresent()){
            throw new NotFoundException("Car with id " + carId + "doesn't exist!");
        }
        if(autoServiceRepository.findById(serviceId).isEmpty()){
            throw new NotFoundException("Auto Service with id " + serviceId + "doesn't exist!");
        }
        Car carToBeServiced = carRepository.findById(carId).orElseThrow(() -> new NotFoundException("Car with id " + carId + "doesn't exist!"));
        AutoService autoService = autoServiceRepository.findById(serviceId).orElseThrow(() -> new NotFoundException("Auto Service with id " + serviceId + "doesn't exist!"));

        autoService.getCarsToBeServiced().add(carToBeServiced);
        autoServiceRepository.save(autoService);

        carToBeServiced.setAutoService(autoService);
        carRepository.save(carToBeServiced);
    }
}
