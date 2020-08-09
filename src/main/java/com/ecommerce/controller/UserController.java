package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<User> verifyLogin(@RequestBody String requestData){
		return new ResponseEntity<User>(userService.verifyLogin(requestData),HttpStatus.OK);
	}
	
	@PostMapping("/forgotpassword")
	public ResponseEntity<String> forgotPassword(@RequestBody String requestData){
		return null;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<String> addUser(@RequestBody User user){
		return new ResponseEntity<String>(userService.addUser(user),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody User user){
		return new ResponseEntity<String>(userService.updateUser(userId, user),HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.OK);
	}
	
	@GetMapping("/users/role/{role}")
	public ResponseEntity<List<User>> getUserByRole(@PathVariable int role){
		return new ResponseEntity<List<User>>(userService.getUserByRole(role), HttpStatus.ACCEPTED.OK);
		
	}
}
