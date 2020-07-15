package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Orders;
import com.ecommerce.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getAllOrders(){
		return null;
	}
	
	@PostMapping("/orders")
	public ResponseEntity<String> addOrder(@RequestBody Orders order){
		return null;
	}
	
	@PutMapping("/orders/{orderId}")
	public ResponseEntity<String> updateOrder(@PathVariable String orderId, @RequestBody Orders order){
		return null;
	}
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable String orderId){
		return null;
	}
	
	@PutMapping("/orders/status/{orderId}/{status}")
	public ResponseEntity<String> updateOrderStatus(@PathVariable String orderId, @PathVariable String status){
		return null;
	}
}
