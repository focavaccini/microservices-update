package com.microservices.workerservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.workerservice.entities.Worker;
import com.microservices.workerservice.services.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	@Autowired
	private WorkerService service;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		
		List<Worker> list = service.findAll();
		
		return ResponseEntity.
				ok(list);
	}
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id){
		
		Worker obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
}
