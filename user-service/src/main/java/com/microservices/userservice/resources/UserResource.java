package com.microservices.userservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.userservice.entities.User;
import com.microservices.userservice.repositories.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User endpoint")
@RestController
@RequestMapping("/user-service")
public class UserResource {
	
	@Autowired
	private UserRepository repository;
	
	@Operation(summary = "Find user by id")
	@GetMapping(value = "/{id}")
	ResponseEntity<User> findById(@PathVariable Long id){
		User obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	@Operation(summary = "Find user by email")
	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email){
		User obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
}
