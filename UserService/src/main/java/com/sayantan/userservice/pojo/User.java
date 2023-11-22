package com.sayantan.userservice.pojo;

import java.util.List;

import com.sayantan.ratingservice.pojo.Rating;

public class User {
	
	private String uid;
	private String name;
	private String email;
	private String about;
	private List<Rating> ratingList;
	
	public User(String uid, String name, String email, String about) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.about = about;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

	public User(String uid, String name, String email, String about, List<Rating> ratingList) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.about = about;
		this.ratingList = ratingList;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	  

}
