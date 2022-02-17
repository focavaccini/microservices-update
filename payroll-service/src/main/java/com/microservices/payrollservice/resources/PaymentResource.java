package com.microservices.payrollservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.payrollservice.entities.Payment;
import com.microservices.payrollservice.services.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Payroll endpoint")
@RestController
@RequestMapping("/payroll-service")
public class PaymentResource {
	

	@Autowired
	private PaymentService service;
	
	@Operation(summary ="Find worker pay by ID")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
}
