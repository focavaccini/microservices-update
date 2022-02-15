package com.microservices.payrollservice.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.payrollservice.entities.Payment;
import com.microservices.payrollservice.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResource {
	
private static Logger logger = LoggerFactory.getLogger(PaymentResource.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = service.getPayment(workerId, days);
		logger.info("PORT = " + env.getProperty("local.server.port"));
		return ResponseEntity.ok(payment);
	}
}
