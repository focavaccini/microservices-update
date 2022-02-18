package com.microservices.oauthservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.oauthservice.entities.User;

@Component
@FeignClient(name = "user-service", path="/user-service")
public interface UserFeignClient {
	
	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);
}
