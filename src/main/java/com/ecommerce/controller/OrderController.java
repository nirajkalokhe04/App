package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Orders;
import com.ecommerce.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getAllOrders(){
		return new ResponseEntity<List<Orders>>(orderService.getAllOrders(),HttpStatus.OK);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<String> addOrder(@RequestBody String order){
		JSONObject orderJson;
		String responseStr = "";
		try {
			orderJson = new JSONObject(order);
			responseStr = orderService.addOrder(orderJson);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(responseStr,HttpStatus.CREATED);
	}
	
	@PutMapping("/orders/{orderId}")
	public ResponseEntity<String> updateOrder(@PathVariable String orderId, @RequestBody Orders order){
		return new ResponseEntity<String>(orderService.updateOrder(orderId, order),HttpStatus.OK);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable String orderId, @RequestParam String reason){
		return new ResponseEntity<String>(orderService.cancelOrder(orderId, reason),HttpStatus.OK);
	}
	
	@PutMapping("/orders/status/{orderId}/{status}")
	public ResponseEntity<String> updateOrderStatus(@PathVariable String orderId, @PathVariable int status){
		return new ResponseEntity<String>(orderService.updateOrderStatus(orderId, status),HttpStatus.OK);
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<String> getOrderById(@PathVariable String orderId){
		return new ResponseEntity<String>(orderService.getOrderById(orderId), HttpStatus.OK);
	}
	
	@GetMapping("/CheckAreaDeliverable/{Pincode}")
	public ResponseEntity<Integer> checkPinCode(@PathVariable Integer Pincode){
		return new ResponseEntity<Integer>(orderService.checkPinCode(Pincode), HttpStatus.OK);
	}
	
}
