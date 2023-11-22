package com.sayantan.userservice.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sayantan.userservice.exception.UserNotFoundException;
import com.sayantan.userservice.pojo.User;

@Service
public class UserServ {
	
	@Autowired
	private RestTemplate restTemplate;
	
	Logger log = LoggerFactory.getLogger(UserServ.class);
	
	
	public User saveUser(User user) {
		return user;
	}


	public List<User> getAllUsers() throws RestClientException, URISyntaxException {
		ResponseEntity<List> ratingResponse = restTemplate.getForEntity(new URI("http://RATINGMICROSERVICE/rating/getAllRatings"), List.class);
		log.info("Rating servic response: {}",ratingResponse.getBody());
		User  us1 = new User("1", "Sanu", "sanu@gmail.com", "Hard-Working");
		User  us2 = new User("2", "Kdc", "kdc@gmail.com", "good");
		User  us3 = new User("3", "Chiru", "chiru@gmail.com", "patience");
		User  us4 = new User("4", "Sonai", "sonai@gmail.com", "smart");
		return  Arrays.asList(us1,us2,us3,us4);
	}

	public User getUserById(String id) {
		User  us1 = new User("1", "Sanu", "sanu@gmail.com", "Hard-Working");
		User  us2 = new User("2", "Kdc", "kdc@gmail.com", "good");
		User  us3 = new User("3", "Chiru", "chiru@gmail.com", "patience");
		User  us4 = new User("4", "Sonai", "sonai@gmail.com", "smart");
		if(id.equals("1")) {
			return us1;
		}
		else if(id.equals("2")) {
			return us2;
		}
		else if(id.equals("3")) {
			return us3;
		}
		else if(id.equals("4")) {
			return us4;
		}
	else {
		throw new UserNotFoundException("User is not present in the DB");
	}
	}

}
