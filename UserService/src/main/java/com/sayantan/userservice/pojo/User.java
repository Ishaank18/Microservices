package com.sayantan.userservice.pojo;

import java.util.List;

import com.sayantan.ratingservice.pojo.Rating;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "User_Id")
	private int uid;
	@Column(name = "User_Name")
	private String name;
	@Column(name = "User_Email")
	private String email;
	@Column(name = "User_About")
	private String about;
	@Column(name = "User_RatingList")
	private List<Rating> ratingList;
	
	public User(int uid, String name, String email, String about) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.about = about;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
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

	public User(int uid, String name, String email, String about, List<Rating> ratingList) {
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
