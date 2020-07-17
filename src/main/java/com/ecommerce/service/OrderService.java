package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Orders;
import com.ecommerce.repository.OrderDetailRepository;
import com.ecommerce.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;

	public String addOrder(Orders order) {
		// TODO Auto-generated method stub
		order = orderRepository.save(order);
		return order.getId();
	}

	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		
		return orderRepository.findAll();
	}
}
