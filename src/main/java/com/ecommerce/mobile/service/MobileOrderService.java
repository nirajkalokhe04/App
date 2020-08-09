package com.ecommerce.mobile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.mobile.repository.MobileOrderRepository;
import com.ecommerce.model.Address;
import com.ecommerce.model.Orders;
import com.ecommerce.repository.AddddRepo;
import com.ecommerce.util.Constants;

@Service
public class MobileOrderService {
	@Autowired
	MobileOrderRepository orderRepository;

	@Autowired
	AddddRepo er;
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
}
