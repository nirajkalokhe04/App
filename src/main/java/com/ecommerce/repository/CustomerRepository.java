package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

	public List<Customer> findByMobile(String mobile);
	
	Optional<Customer> findByEmail(String mailId);
	
	Optional<Customer> findByResetToken(String resetToken);
	
}
