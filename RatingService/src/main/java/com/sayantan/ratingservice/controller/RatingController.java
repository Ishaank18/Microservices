package com.sayantan.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sayantan.ratingservice.pojo.Rating;
import com.sayantan.ratingservice.service.RatingServ;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	
	@Autowired
	private RatingServ serv;
	
	@GetMapping("/getAllRatings")
	public ResponseEntity<List<Rating>> getAllRatings(){
		return ResponseEntity.status(HttpStatus.OK).body(serv.getAllRatings());
	}
	
	@GetMapping("/getRatingByRatingId/{ratingId}")
	public ResponseEntity<Rating> getRatingByRatingId(@PathVariable String ratingId){
		return ResponseEntity.status(HttpStatus.OK).body(serv.getRatingById(ratingId));
	}
	
	@GetMapping("/getRatingByUserId/{uid}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String uid){
		return ResponseEntity.status(HttpStatus.OK).body(serv.getRatingByUserId(uid));
	}

}
