package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Cart;
import com.ecommerce.model.CartDetails;
import com.ecommerce.repository.CartDetailsRepository;
import com.ecommerce.repository.CartRepository;

import net.bytebuddy.utility.RandomString;

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
		CartDetails existingCartDetails = cartDetailsRepository.findCartDetails(cart.getCartId(), itemId);
		if(existingCartDetails.getItemId().equals(itemId)) {
			existingCartDetails.setItemQuantity(existingCartDetails.getItemQuantity()-1);
			existingCartDetails.setTotalPrice(existingCartDetails.getItemQuantity()*existingCartDetails.getItemPrice());
		}
		if(cart.getCartTotal()-existingCartDetails.getItemPrice()>0) {
			cart.setCartTotal(cart.getCartTotal()-existingCartDetails.getItemPrice());
			
		}
		else {
			cartRepository.delete(cart);
			cartDetailsRepository.deleteById(existingCartDetails.getCartDetailId());
			return returnMsg;
		}
		
		cartRepository.save(cart);
		cartDetailsRepository.deleteById(existingCartDetails.getCartDetailId());
		return returnMsg;
	}
	
	private Boolean checkCartForUser(String userId) {
		//TODO Check whether user is already having cart
		 return cartRepository.existsById(userId);
	}
	
	public String updateCartDetails(CartDetails cartDetails, String userId) {
		String returnMsg= "Cart updated successfully!!";
		cartDetails.setCartId(cartRepository.findCartByUserId(userId).getCartId());
		CartDetails existingCartDetails =checkItemInCart(cartDetails.getCartId(), cartDetails.getItemId());
		if(existingCartDetails!=null) {
			cartDetails.setItemQuantity(cartDetails.getItemQuantity()+existingCartDetails.getItemQuantity());
			cartDetails.setTotalPrice(cartDetails.getItemQuantity()*cartDetails.getItemPrice());
		}
		cartDetailsRepository.save(cartDetails);
		return returnMsg;
	}
	
	public List<Cart> getCart(String userId) {
		//TODO Check whether user is already having cart
		return cartRepository.findCartDetailsByUserId(userId);
		 
	}
	
	private CartDetails checkItemInCart(String cartId, String itemId) {
		CartDetails cd=cartDetailsRepository.findCartDetails(cartId, itemId);
		 cd.setApiKey(RandomString.make());
		 return cd;
	}

}
