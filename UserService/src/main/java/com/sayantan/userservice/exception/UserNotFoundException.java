package com.sayantan.userservice.exception;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 7701301935387574556L;

	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
		super("User not found!");
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}


}
