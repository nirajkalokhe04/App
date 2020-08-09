package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Cart;
import com.ecommerce.model.CartDetails;
import com.ecommerce.model.DeliverySlots;
import com.ecommerce.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@GetMapping("/cart/{UserId}")
	public ResponseEntity<List<Cart>> getCartDetails(@PathVariable String UserId){
		return new ResponseEntity<List<Cart>>(cartService.getCart(UserId), HttpStatus.OK);
	}
	
	@PostMapping("/cart")
	public ResponseEntity<String> addCartDetails(@RequestBody Cart cart,String userId){
		return new ResponseEntity<String>(cartService.addCart(cart, userId), HttpStatus.OK);
	}
	
	@DeleteMapping("/cart")
	public ResponseEntity<String> deleteCartdetails(String itemId,String userId){
		return new ResponseEntity<String>(cartService.deleteCartItem(itemId, userId), HttpStatus.OK);
	}
	
	@PostMapping("/addCartItem")
	public ResponseEntity<String> addCartDetails(@RequestBody CartDetails cart){
		return new ResponseEntity<String>(cartService.addCart(cart), HttpStatus.OK);
	}
	
	@GetMapping("getCartCoutbyUserID/{userId}")
	public ResponseEntity<Integer> getCartCount(@PathVariable String userId){
		return new ResponseEntity<Integer>(cartService.getCartCount(userId), HttpStatus.OK);
	}
	
	@GetMapping("cartItems/{UserId}")
	public ResponseEntity<List<CartDetails>> getCartItemDetails(@PathVariable String UserId){
		return new ResponseEntity<List<CartDetails>>(cartService.getCartItemDetails(UserId), HttpStatus.OK);
	}

	@GetMapping("getDeliverySlots")
	public ResponseEntity<List<DeliverySlots>> getDeliverySlots(){
		return new ResponseEntity<List<DeliverySlots>>(cartService.getDeliverySlots(), HttpStatus.OK);
	}
}
