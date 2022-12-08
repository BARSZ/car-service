package com.project.cscb869.services;

import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.entity.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> getWorkers();

    Worker getWorker(long id);

    Worker addWorker(Worker worker);

    Worker updateWorker(long id, Worker worker);

    void deleteWorker(long id);

    Worker addAutoService(long workerId, AutoService autoService);
}
