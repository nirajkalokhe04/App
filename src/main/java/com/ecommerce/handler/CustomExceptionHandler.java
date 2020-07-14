package com.ecommerce.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.exception.UserNotFound;

@RestControllerAdvice
public class CustomExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<String> userNotFoundException(UserNotFound ex){
		logger.info(ex.getMessage());
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
