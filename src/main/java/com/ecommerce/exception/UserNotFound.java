package com.ecommerce.exception;

import org.springframework.stereotype.Component;

@Component
public class UserNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;

	public UserNotFound() {}
	
	public UserNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserNotFound [message=" + message + "]";
	}
	
}
