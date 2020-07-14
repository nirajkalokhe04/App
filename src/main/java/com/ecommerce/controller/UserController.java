package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.User;
import com.ecommerce.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<String> verifyLogin(@RequestBody String requestData){
		return null;
	}
	
	@PostMapping("/forgotpassword")
	public ResponseEntity<String> forgotPassword(@RequestBody String requestData){
		return null;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return null;
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		return null;
	}
	
	@PostMapping("/users")
	public ResponseEntity<String> addUser(@RequestBody User user){
		return null;
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody User user){
		return null;
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		return null;
	}
}
