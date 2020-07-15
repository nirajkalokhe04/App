package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
		Optional<User> userResponse =userRepository.findById(userId);
		User user = userResponse.get(); 
		return user;
		
	}
	
	public String addUser(User user) {
		String returnStr = "User added successfully.";
		userRepository.save(user);
		return returnStr;
	}
	
	public String updateUser(String userId,User user) {
		String returnStr = "User updated successfully.";
		userRepository.save(user);
		return returnStr;
	}
	
	public String deleteUser(String userId) {
		String returnStr = "User deleted successfully.";
		userRepository.deleteById(userId);;
		return returnStr;
	}
	
}
