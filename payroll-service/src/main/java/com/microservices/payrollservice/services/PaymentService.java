package com.microservices.payrollservice.services;

import org.springframework.stereotype.Service;

import com.microservices.payrollservice.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Persival", 250.0, days);
	}
	
}
