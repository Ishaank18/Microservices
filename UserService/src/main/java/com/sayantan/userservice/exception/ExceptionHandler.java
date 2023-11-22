package com.sayantan.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sayantan.userservice.pojo.ApiResponse;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> userNotFoundExceptionHandler(UserNotFoundException uex){
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(uex.getMessage());
		apiResponse.setStatus(HttpStatus.NOT_FOUND);
		apiResponse.setSuccess(false);
		apiResponse.setResponse("User Not Found in the DB");
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
