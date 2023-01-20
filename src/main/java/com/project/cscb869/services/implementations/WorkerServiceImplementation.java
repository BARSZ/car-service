package com.project.cscb869.services.implementations;

import com.project.cscb869.data.entity.Worker;
import com.project.cscb869.data.repository.WorkerRepository;
import com.project.cscb869.exceptions.NotFoundException;
import com.project.cscb869.services.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerServiceImplementation implements WorkerService {

    private final WorkerRepository workerRepository;
    @Transactional
    @Override
    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    @Transactional
    @Override
    public Worker getWorker(long id) {
        return workerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invalid worker id: " + id));
    }

    @Transactional
    @Override
    public List<Worker> getWorkersForAutoService(long id) {
        return workerRepository.getWorkersByAutoServiceId(id);
    }

    @Transactional
    @Override
    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    @Transactional
    @Override
    public Worker updateWorker(long id, Worker worker) {
        worker.setId(id);
        return workerRepository.save(worker);
    }
    @Transactional
    @Override
    public void deleteWorker(long id) {
        workerRepository.deleteById(id);
    }
}
