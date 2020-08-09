package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.DeliverySlots;

@Repository
public interface DeliveryStols extends JpaRepository<DeliverySlots, String>{


	List<DeliverySlots> findByIsActive(Boolean isActive);
}
