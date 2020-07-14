package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{

}
