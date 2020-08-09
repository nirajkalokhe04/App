package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.repository.UserRepository;
import com.ecommerce.serviceimpl.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userrepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		com.ecommerce.model.User user = userrepository.findByUsername(username).get(0);
		
		if(user==null) {
			throw new UsernameNotFoundException("user 404");
		}else {
			
		}
		return new UserPrincipal(user);
	}

}
