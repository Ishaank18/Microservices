package com.sayantan.ratingservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sayantan.ratingservice.pojo.Rating;

@Service
public class RatingServ {
	
	Rating rating1 = new Rating("r1", "1", "hl", "****", "Good");
	Rating rating2 = new Rating("r2", "1", "h2", "****", "Semi-good");
	Rating rating3 = new Rating("r3", "2", "h3", "****", "Average");
	Rating rating4 = new Rating("r4", "2", "h4", "****", "Bad");
	List<Rating> ratingList = Arrays.asList(rating1,rating2,rating3,rating4);

	public List<Rating> getAllRatings(){
		return ratingList;
	}
	
	public Rating getRatingById(String id) {
		
		for(Rating rating: ratingList) {
			if(id.equals(rating.getRatingId())) {
				return rating;
			}
		}
		return null;
	}
	
	public List<Rating> getRatingByUserId(String uid){
		List<Rating> ratings = new ArrayList<>();
		for (Rating rating : ratingList) {
			if(uid.equals(rating.getUid())) {
				ratings.add(rating);
			}
		}
		return ratings;
	}

}
