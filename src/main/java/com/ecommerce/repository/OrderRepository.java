package com.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, String>{

	@Query("SELECT max(orderNumber) from Orders")
	public Optional<String> findMaximumOrderNumber();
}
