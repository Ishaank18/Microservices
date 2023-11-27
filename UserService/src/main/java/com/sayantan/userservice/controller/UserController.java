package com.sayantan.userservice.controller;


import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.sayantan.userservice.pojo.User;
import com.sayantan.userservice.service.UserServ;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserServ serv;
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(path = "/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		log.info("username is : {}",user.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.saveUser(user));
		
	}
	
	@GetMapping(path = "/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id){
		
		return ResponseEntity.status(HttpStatus.FOUND).body(serv.getUserById(id));
		
	}
	// Along with the @CircuitBreaker, kindly check the @Retry and @RateLimiter functionality also
	@GetMapping(path = "/getAllUsers")
	@CircuitBreaker(name = "User_To_Rating_Service_Call",fallbackMethod = "userToRatingFallbackMethodCall")
	public ResponseEntity<List<User>> getAllUsers() throws RestClientException, URISyntaxException{		
		return ResponseEntity.status(HttpStatus.FOUND).body(serv.getAllUsers());		
	}

	// creating the fallback method for the circuit breaker
	//Condition for implementing circuit-breaker --> 1. in the fallback method, exception argument is mandatory and the arguments which are present in the main method from where the fallback method is called. 2. the
	// return type of the main method and the fallback method should be same
	public ResponseEntity<List<User>> userToRatingFallbackMethodCall(Exception ex) {	
		log.info("the fallback method is called due to the exception: {}",ex.getMessage());
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Collections.emptyList());		
	}
}
