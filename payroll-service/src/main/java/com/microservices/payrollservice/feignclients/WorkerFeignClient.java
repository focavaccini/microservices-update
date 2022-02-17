package com.microservices.payrollservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.payrollservice.response.Worker;

@Component
@FeignClient(name = "worker-service", path = "/worker-service")
public interface WorkerFeignClient {
	

	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable("id") Long id);
}
