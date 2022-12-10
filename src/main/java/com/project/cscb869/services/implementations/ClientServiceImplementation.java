package com.project.cscb869.services.implementations;

import com.project.cscb869.data.entity.*;
import com.project.cscb869.data.repository.AutoServiceRepository;
import com.project.cscb869.data.repository.CarRepository;
import com.project.cscb869.data.repository.ClientRepository;
import com.project.cscb869.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImplementation implements ClientService {
    private final ClientRepository clientRepository;
    private final AutoServiceRepository autoServiceRepository;
    private final CarRepository carRepository;
    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client, long id) {
        client.setId(id);
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void CanScheduleService(String autoServiceName, String carName){
        Car carToBeServiced = carRepository.getCarByName(carName);
        AutoService autoService = autoServiceRepository.getAutoServiceByName(autoServiceName);

        autoService.getCarsToBeServiced().add(carToBeServiced);
        carToBeServiced.setAutoService(autoService);

        autoServiceRepository.save(autoService);
        carRepository.save(carToBeServiced);
        /*for(Worker worker : autoService.getWorkers()){
            if(worker.getQualification() == serviceType){
                autoService.getCarsToBeServiced().add(carToBeServiced);
                carToBeServiced.setAutoService(autoService);

                carRepository.save(carToBeServiced);
                autoServiceRepository.save(autoService);
                return true;
            }
        }
        return false;*/
    }
}
