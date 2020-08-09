package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Cart;
import com.ecommerce.model.CartDetails;
import com.ecommerce.model.DeliverySlots;
import com.ecommerce.repository.CartDetailsRepository;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.DeliveryStols;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartDetailsRepository cartDetailsRepository;
	
	@Autowired
	DeliveryStols deliveryStols;
	
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
			existingCartDetails.setQuantity(existingCartDetails.getQuantity()-1);
			existingCartDetails.setTotalPrice(existingCartDetails.getQuantity()*existingCartDetails.getItemPrice());
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
		CartDetails existingCartDetails = checkItemInCart(cartDetails.getCartId(), cartDetails.getItemId());
		if(existingCartDetails!=null) {
			existingCartDetails.setQuantity(cartDetails.getQuantity()+existingCartDetails.getQuantity());
			existingCartDetails.setTotalPrice(existingCartDetails.getQuantity()*cartDetails.getItemPrice());
		} else {
			existingCartDetails = cartDetails;
			existingCartDetails.setTotalPrice(existingCartDetails.getQuantity()*cartDetails.getItemPrice());
		}
		cartDetailsRepository.save(existingCartDetails);
		
		return returnMsg;
	}
	
	public List<Cart> getCart(String userId) {
		//TODO Check whether user is already having cart
		return cartRepository.findCartDetailsByUserId(userId);
		 
	}
	
	private CartDetails checkItemInCart(String cartId, String itemId) {
		CartDetails cd=cartDetailsRepository.findCartDetails(cartId, itemId);
		 
		 return cd;
	}

	public String addCart(CartDetails cartDetails) {
//		Cart cart = getCart(cartDetails.getUserId());
		Cart cart = cartRepository.findByUserId(cartDetails.getUserId());
		String cartid=null;
		if(null == cart) {
			cart = createcartForUser(cartDetails);
		}
		cartid = cart.getCartId();
		cartDetails.setCartId(cartid);
		updateCartDetails(cartDetails, cartDetails.getUserId());
		
		return cartid;
		
	}
	private Cart createcartForUser(CartDetails cartDetails) {
		Cart cart= new Cart();
		cart.setCartTotal(cartDetails.getItemPrice()*cartDetails.getQuantity());
		cart.setUserId(cartDetails.getUserId());
		cart.setIsActive(Boolean.TRUE);
		cartRepository.save(cart);
		return cart;
	}
	
	public Integer getCartCount(String userid) {
		return cartDetailsRepository.findByUserId(userid).size();
		
	}
	
	public List<CartDetails> getCartItemDetails(String userid) {
		return cartDetailsRepository.findByUserId(userid);
		
	}
	
	public List<DeliverySlots> getDeliverySlots () {
		return deliveryStols.findByIsActive(Boolean.TRUE);
		
	}
}
