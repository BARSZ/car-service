package com.project.cscb869.services.implementations;

import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.entity.Car;
import com.project.cscb869.data.entity.Worker;
import com.project.cscb869.data.repository.AutoServiceRepository;
import com.project.cscb869.data.repository.WorkerRepository;
import com.project.cscb869.exceptions.NotFoundException;
import com.project.cscb869.services.AutoServiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AutoServiceImplementation  implements AutoServiceService {

    private final AutoServiceRepository autoServiceRepository;
    private final WorkerRepository workerRepository;

    @Transactional
    @Override
    public List<AutoService> getServices() {
        return autoServiceRepository.findAll();
    }
    @Transactional
    @Override
    public AutoService getService(long id) {
        return autoServiceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Auto Service with id "+ id +" doesn't exist!"));
    }
    @Transactional
    @Override
    public AutoService createService(AutoService autoService) {
        return autoServiceRepository.save(autoService);
    }

    @Transactional
    @Override
    public AutoService updateService(long id, AutoService autoService) {
        if(autoServiceRepository.findById(id).isPresent()){
            autoService.setId(id);
            return autoServiceRepository.save(autoService);
        }else {
            throw new NotFoundException("Auto Service with id "+ id +" doesn't exist!");
        }
    }
    @Transactional
    @Override
    public void deleteService(long id) {
        if(autoServiceRepository.findById(id).isPresent()){
            autoServiceRepository.deleteById(id);
        }else{
            throw new NotFoundException("Auto Service with id "+ id +" doesn't exist!");
        }
    }
    @Transactional
    @Override
    public AutoService getAutoServiceByName(String name){
        if(autoServiceRepository.getAutoServiceByName(name) == null){
            throw new NotFoundException("Auto Service with name "+ name +" doesn't exist!");
        }
        return autoServiceRepository.getAutoServiceByName(name);
    }
    @Transactional
    @Override
    public AutoService serviceCar(Car car){
        return null;
    }
    @Transactional
    @Override
    public AutoService addWorker(long serviceId, Worker worker){
        AutoService autoService = autoServiceRepository.findById(serviceId).orElseThrow(() -> new NotFoundException("Auto Service with id "+ serviceId +" doesn't exist!"));

        List<Worker> newWorkers = autoService.getWorkers();
        newWorkers.add(worker);

        autoService.setWorkers(newWorkers);
        worker.setAutoService(autoService);

        workerRepository.save(worker);
        autoServiceRepository.save(autoService);
        return autoService;
    }
}
