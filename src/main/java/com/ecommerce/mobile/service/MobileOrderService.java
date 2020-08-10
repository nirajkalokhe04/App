package com.ecommerce.mobile.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.CustomerNotFound;
import com.ecommerce.mobile.repository.MobileOrderRepository;
import com.ecommerce.model.Address;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Item;
import com.ecommerce.model.MobileOrder;
import com.ecommerce.model.OrderDetail;
import com.ecommerce.model.Orders;
import com.ecommerce.repository.AddddRepo;
import com.ecommerce.repository.CartDetailsRepository;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.OrderDetailRepository;
import com.ecommerce.service.OrderService;
import com.ecommerce.util.Constants;

@Service
public class MobileOrderService {
	@Autowired
	MobileOrderRepository orderRepository;

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	AddddRepo er;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CartDetailsRepository cartDetailsRepository;
	
	public String cancelOrder(String order_ID) {
		// TODO Auto-generated method stub
		String returnStr = "Order status updated sucessfully.";

		Optional<Orders> order = orderRepository.findById(order_ID).map(orders -> {
			orders.setStatus(Constants.ORDER_CANCEL_STATUS);
			return orderRepository.save(orders);
		});

		if (order.isPresent()) {
			returnStr = "Order status updated sucessfully.";
		} else {
			returnStr = "Order status not updated. Please try again.";
		}
		return returnStr;

	}

	public List<Orders> getAllUserOrders(String userId) {
		return orderRepository.getAllUserOrders(userId);
	}

	public List<Address> getAddressList(String userId) {
		// TODO Auto-generated method stub
		return er.findByUserId(userId);
	}
	
	
	public Integer addAddress(Address address) {
		// TODO Auto-generated method stub
		if(address.getId()==null) {
			er.save(address);
			
		}else {
			Address add= er.findById(address.getId()).get();
			er.save(add);
			
		}
		 return 1;
	}
	
	public String placeOrder(MobileOrder mobileOrder) {
		
//		generateOrderId();
		
		int isDeleted = 0;
		int isDeletedFromCustomer = 0;
		
		String cartId = cartRepository.findCartByUserId(mobileOrder.getUserId()).getCartId();
		
		Date orderedOn = new Date();
		String orderNumber = "";

		
			Orders order = new Orders();
//			order.setOrderNumber(orderNumber);
			order.setTotalAmount(mobileOrder.getTotalAmount());
			order.setIsDeleted(isDeleted);
			order.setIsDeletedFromCustomer(isDeletedFromCustomer);
			order.setOrderedOn(orderedOn);
			order.setAddress(mobileOrder.getOrderAddress());

			Customer customer = customerRepository.findById(mobileOrder.getUserId()).orElseThrow(() -> new CustomerNotFound("Customer not found."));
			order.setCustomer(customer);
			
//			User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFound("User not found."));
//			order.setUser(user);

			order = orderRepository.save(order);

			List<Item> orderDetailsJson = mobileOrder.getItems();

			for (int ind = 0; ind < orderDetailsJson.size(); ind++) {
			
//				JSONObject orderDetailJobj = orderDetailsJson.optJSONObject(ind);
//				String itemId = orderDetailJobj.optString("itemId");
//				double quantity = orderDetailJobj.optDouble("quantity");
//				double price = orderDetailJobj.optDouble("price");
//
				Item item = itemRepository.findById(orderDetailsJson.get(ind).getId()).orElseThrow(() -> new RuntimeException("Item not found."));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setItem(item);
				orderDetail.setQuantity(orderDetailsJson.get(ind).getQuantity());
				orderDetail.setPrice(item.getPrice());
				orderDetail.setOrder(order);

				orderDetailRepository.save(orderDetail);
			}
			synchronized (this) {
				orderNumber = orderService.generateOrderNumber();
				order.setOrderNumber(orderNumber);
				orderRepository.save(order);
			}
			if(!cartId.equals("")){
//				cartDetailsRepository.findByUserId(cartId).forEach(cartDetails -> cartDetailsRepository.delete(cartDetails));
				 cartDetailsRepository.deleteCartDetails(cartId);
				cartRepository.deleteById(cartId);
			}
		return orderNumber;
		
		
		
	}
}
