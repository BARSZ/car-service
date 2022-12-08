package com.project.cscb869.services.implementations;

import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.entity.Car;
import com.project.cscb869.data.entity.Worker;
import com.project.cscb869.data.repository.AutoServiceRepository;
import com.project.cscb869.data.repository.WorkerRepository;
import com.project.cscb869.services.AutoServiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutoServiceImplementation  implements AutoServiceService {

    private final AutoServiceRepository autoServiceRepository;
    private final WorkerRepository workerRepository;

    @Override
    public List<AutoService> getServices() {
        return autoServiceRepository.findAll();
    }

    @Override
    public AutoService getService(long id) {
        return autoServiceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid auto service id: " + id));
    }

    @Override
    public AutoService createService(AutoService autoService) {
        return autoServiceRepository.save(autoService);
    }

    @Override
    public AutoService updateService(long id, AutoService autoService) {
        autoService.setId(id);
        return autoServiceRepository.save(autoService);
    }

    @Override
    public void deleteService(long id) {
        autoServiceRepository.deleteById(id);
    }

    @Override
    public AutoService getAutoServiceByName(String name){
        return autoServiceRepository.getAutoServiceByName(name);
    }
    @Override
    public AutoService serviceCar(Car car){
        return null;
    }
    @Override
    public AutoService addWorker(long serviceId, Worker worker){
        AutoService autoService = autoServiceRepository.findById(serviceId).orElseThrow(() -> new IllegalArgumentException("Invalid auto service id: " + serviceId));

        List<Worker> newWorkers = autoService.getWorkers();
        newWorkers.add(worker);

        autoService.setWorkers(newWorkers);
        worker.setAutoService(autoService);

        workerRepository.save(worker);
        autoServiceRepository.save(autoService);
        return autoService;
    }
}
