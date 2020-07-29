package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.OrderDetail;
import com.ecommerce.model.Orders;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{

	public List<OrderDetail> findAllByOrder(Orders order); 
}
