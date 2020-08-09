package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.UserNotFound;
import com.ecommerce.model.Customer;
import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User verifyLogin(String userData) {
		User user = null;
		try {
			JSONObject loginJson = new JSONObject(userData);
			String userName = loginJson.optString("userName");
			String password = loginJson.optString("password");
			
			List<User> userList = userRepository.findByUsername(userName);
			if(userList.size() > 0) {
				if(new BCryptPasswordEncoder().matches(password, userList.get(0).getPassword())) {
					user = userList.get(0);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return user;
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
			user.setDeleted(0);
			userRepository.save(user);
		});
		return returnStr = "User deleted.";
	}

	public List<User> getUserByRole(int role) {
		return userRepository.findUserByRole(role);
	}
	
}
