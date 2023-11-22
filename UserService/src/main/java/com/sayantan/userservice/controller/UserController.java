package com.sayantan.userservice.controller;


import java.net.URISyntaxException;
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
	
	@GetMapping(path = "/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() throws RestClientException, URISyntaxException{
		
		return ResponseEntity.status(HttpStatus.FOUND).body(serv.getAllUsers());
		
	}

}
