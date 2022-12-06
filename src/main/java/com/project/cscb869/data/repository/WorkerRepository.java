package com.project.cscb869.data.repository;

import com.project.cscb869.data.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
