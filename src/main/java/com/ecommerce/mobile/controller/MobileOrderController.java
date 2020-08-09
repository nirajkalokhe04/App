package com.ecommerce.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mobile.service.MobileOrderService;
import com.ecommerce.model.Address;
import com.ecommerce.model.Orders;

@RestController
public class MobileOrderController {

	@Autowired
	MobileOrderService orderService;
	
	@PutMapping("/CancelOrder/{Order_ID}")
	public ResponseEntity<String> updateOrderStatus(@PathVariable String Order_ID){
		return new ResponseEntity<String>(orderService.cancelOrder(Order_ID),HttpStatus.OK);
	}
	
	@GetMapping("userOrderList/{userId}")
	public ResponseEntity<List<Orders>> getUserOrderDetails(@PathVariable String userId){
		return new ResponseEntity<List<Orders>>(orderService.getAllUserOrders(userId),HttpStatus.OK);
	}
	
	@GetMapping("addressList/{UserId}")
	public ResponseEntity<List<Address>> getAddressList(@PathVariable String UserId){
		return new ResponseEntity<List<Address>>(orderService.getAddressList(UserId),HttpStatus.OK);
	}
}
