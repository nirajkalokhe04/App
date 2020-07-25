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
		order = orderRepository.save(order);
		return order.getId();
	}

	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	public String updateOrder(String orderId, Orders order) {
		// TODO Updating order details with order id
		String returnStr = "Order updated sucessfully.";
		Orders orders = orderRepository.findById(orderId).get();
		orders.setId(orders.getId());
//		orderDetailRepository.deleteAll(orderDetailRepository.findAllById(orders.getId()));
		orderRepository.save(order);
		return returnStr;		
		
	}
}
