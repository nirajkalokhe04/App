package com.ecommerce.exception;

import org.springframework.stereotype.Component;

@Component
public class CustomerNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;

	public CustomerNotFound() {}
	
	public CustomerNotFound(String message) {
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
