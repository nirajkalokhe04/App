package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Cart;
import com.ecommerce.model.CartDetails;
import com.ecommerce.repository.CartDetailsRepository;
import com.ecommerce.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartDetailsRepository cartDetailsRepository;
	
	public String addCart(Cart cart,String userId) {
		// TODO Auto-generated method stub
		String returnMsg= "Cart added successfully!!";
		if(!checkCartForUser(cart.getUserId())) {
//			addCartForUser(cart);
			cartRepository.save(cart);
			System.out.println(cart.getCartId());
			cartDetailsRepository.saveAll(cart.getCartDetails());
		}else {
			updateCartDetails((CartDetails)cart.getCartDetails(), userId);			
		}
		return returnMsg;
	}
	
	public String deleteCartItem(String itemId, String userId) {
		//TODO Check whether user is already having cart4
		String returnMsg = "Item removed successfully."; 
		Cart cart = cartRepository.findCartByUserId(userId);
		CartDetails cartDetails = cartDetailsRepository.findCartDetails(cart.getCartId(), itemId);
		if(cart.getCartTotal()-cartDetails.getItemPrice()>0) {
			
			cart.setCartTotal(cart.getCartTotal()-cartDetails.getItemPrice());
		}
		else {
			cartRepository.delete(cart);
			return returnMsg;
		}
		
		cartRepository.save(cart);
		cartDetailsRepository.deleteById(cartDetails.getCartDetailId());
		return returnMsg;
	}
	
	private Boolean checkCartForUser(String userId) {
		//TODO Check whether user is already having cart
		 return cartRepository.existsById(userId);
	}
	
	public String updateCartDetails(CartDetails cartDetails, String userId) {
		String returnMsg= "Cart updated successfully!!";
		cartDetails.setCartId(cartRepository.findCartByUserId(userId).getCartId());
		cartDetailsRepository.save(cartDetails);
		return returnMsg;
	}
	
	public List<Cart> getCart(String userId) {
		//TODO Check whether user is already having cart
		return cartRepository.findCartDetailsByUserId(userId);
		 
	}

}
