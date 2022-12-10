package com.project.cscb869.data.repository;

import com.project.cscb869.data.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
