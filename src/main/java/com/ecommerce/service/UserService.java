package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
}
