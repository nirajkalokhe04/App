package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

	public List<Customer> findByMobile(String mobile);
	
	
}
