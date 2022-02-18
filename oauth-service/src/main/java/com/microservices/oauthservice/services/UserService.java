package com.microservices.oauthservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.oauthservice.entities.User;
import com.microservices.oauthservice.feignclients.UserFeignClient;

@Service
public class UserService {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			throw new IllegalArgumentException("Email not found");
		}
		
		return user;
	}
}
