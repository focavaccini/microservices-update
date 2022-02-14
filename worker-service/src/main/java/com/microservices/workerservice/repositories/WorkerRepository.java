package com.microservices.workerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.workerservice.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
