package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.repository.OrderDetailRepository;
import com.ecommerce.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
}
