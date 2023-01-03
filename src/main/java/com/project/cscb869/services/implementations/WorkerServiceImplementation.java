package com.project.cscb869.services.implementations;

import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.entity.Worker;
import com.project.cscb869.data.repository.WorkerRepository;
import com.project.cscb869.exceptions.NotFoundException;
import com.project.cscb869.services.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerServiceImplementation implements WorkerService {

    private final WorkerRepository workerRepository;
    @Override
    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker getWorker(long id) {
        return workerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invalid worker id: " + id));
    }

    @Override
    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public Worker updateWorker(long id, Worker worker) {
        worker.setId(id);
        return workerRepository.save(worker);
    }

    @Override
    public void deleteWorker(long id) {
        workerRepository.deleteById(id);
    }

    @Override
    public Worker addAutoService(long workerId, AutoService autoService) {
        Worker worker = workerRepository.findById(workerId).orElseThrow();
        worker.setAutoService(autoService);
        workerRepository.save(worker);
        return worker;
    }
}
