package com.project.cscb869.services;

import com.project.cscb869.data.entity.Car;
import com.project.cscb869.data.entity.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getClients();
    public Client getClient(long id);
    public Client createClient(Client client);
    public Client updateClient(Client client, long id);
    public void deleteClient(long id);
    public void CanScheduleService(long carId, long autoServiceId);
    List<Car> getCarsByClientId(long id);
}
