package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Cart;
import com.ecommerce.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@GetMapping("/cart")
	public ResponseEntity<List<Cart>> getCartDetails(String userId){
		return new ResponseEntity<List<Cart>>(cartService.getCart(userId), HttpStatus.OK);
	}
	
	
	@PostMapping("/cart")
	public ResponseEntity<String> addCartDetails(@RequestBody Cart cart,String userId){
		return new ResponseEntity<String>(cartService.addCart(cart, userId), HttpStatus.OK);
	}
	
	@DeleteMapping("/cart")
	public ResponseEntity<String> deleteCartdetails(String itemId,String userId){
		return new ResponseEntity<String>(cartService.deleteCartItem(itemId, userId), HttpStatus.OK);
	}
	
}
