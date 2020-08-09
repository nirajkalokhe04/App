package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Address;

public interface AddddRepo extends JpaRepository<Address, String> {


		List<Address> findByUserId(String userId);
	
}
