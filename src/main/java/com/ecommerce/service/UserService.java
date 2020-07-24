package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.UserNotFound;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public HttpStatus verifyLogin(String userData) {
		if(Boolean.TRUE)
			return HttpStatus.FOUND;
		else
			return HttpStatus.EXPECTATION_FAILED;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(String userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound("Requested user is not available."));
		return user;
	}
	
	public String addUser(User user) {
		String returnStr = "User added successfully.";
		userRepository.save(user);
		return returnStr;
	}
	
	public String updateUser(String userId, User user) {
		String returnStr = "User updated successfully.";
		userRepository.findById(userId).map(userObj -> { user.setId(userId); return userRepository.save(user);})
				.orElseThrow(() -> new UserNotFound("User not found."));
		return returnStr;
	}
	
	public String deleteUser(String userId) {
		String returnStr = "";
		userRepository.findById(userId).ifPresent(user -> {
			user.setDeleted(true);
			userRepository.save(user);
		});
		return returnStr = "User deleted.";
	}
	
}
