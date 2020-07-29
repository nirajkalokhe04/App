package com.ecommerce.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Address;
import com.ecommerce.model.Item;
import com.ecommerce.model.OrderDetail;
import com.ecommerce.model.Orders;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.OrderDetailRepository;
import com.ecommerce.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderService {

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;

	public String addOrder(JSONObject orderJson) {
		String customerId = orderJson.optString("customerId");
		double totalAmount = orderJson.optDouble("totalAmount");
		int isDeleted = orderJson.optInt("isDeleted");
		int isDeletedFromCustomer = orderJson.optInt("isDeletedFromCustomer");
		String addressId = orderJson.optString("addressId");
		Date orderedOn = new Date();
		String orderNumber = "";

		synchronized (this) {
			orderNumber = this.generateOrderNumber();
			Orders order = new Orders();
			order.setOrderNumber(orderNumber);
			order.setTotalAmount(totalAmount);
			order.setIsDeleted(isDeleted);
			order.setIsDeletedFromCustomer(isDeletedFromCustomer);
			order.setOrderedOn(orderedOn);

//			Customer customer = customerRepository.findById(customerId);
//			order.setCustomer(customer);

			order = orderRepository.save(order);

			JSONArray orderDetailsJson = orderJson.optJSONArray("orderDetails");

			for (int ind = 0; ind < orderDetailsJson.length(); ind++) {
				JSONObject orderDetailJobj = orderDetailsJson.optJSONObject(ind);
				String itemId = orderDetailJobj.optString("itemId");
				double quantity = orderDetailJobj.optDouble("quantity");
				double price = orderDetailJobj.optDouble("price");

				Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found."));

				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setItem(item);
				orderDetail.setQuantity(quantity);
				orderDetail.setPrice(price);
				orderDetail.setOrder(order);

				orderDetailRepository.save(orderDetail);
			}
		}
		return orderNumber;
	}
	
	public String generateOrderNumber() {
		String nextOrderNumber = "ORD";
		
		Optional<String> orderNo = orderRepository.findMaximumOrderNumber();
		if(orderNo.isPresent()) {
			String current = orderNo.get();
			nextOrderNumber += (Integer.parseInt(current.replace("ORD", "")) + 1);
		} else {
			nextOrderNumber += 1;
		}
		
		return nextOrderNumber;
	}

	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	public String updateOrder(String orderId, Orders order) {
		String returnStr = "Order updated sucessfully.";
		Orders orders = orderRepository.findById(orderId).get();
		orders.setId(orders.getId());
//		orderDetailRepository.deleteAll(orderDetailRepository.findAllById(orders.getId()));
		orderRepository.save(order);
		return returnStr;
	}

	public String cancelOrder(String orderId, String reason) {
		String returnStr = "Order cancelled sucessfully.";
		Optional<Orders> order = orderRepository.findById(orderId).map(orders -> {
			orders.setIsDeleted(1);
			orders.setIsDeletedFromCustomer(1);
			return orderRepository.save(orders);
		});
		
		if(order.isPresent()) {
			returnStr = "Order cancelled sucessfully.";
		} else {
			returnStr = "Order cancellation failed. Please try again.";
		}
		return returnStr;
	}

	public String updateOrderStatus(String orderId, int status) {
		String returnStr = "Order status updated sucessfully.";
		
		Optional<Orders> order = orderRepository.findById(orderId).map(orders -> {
			orders.setStatus(status);
			return orderRepository.save(orders);
		});
		
		if(order.isPresent()) {
			returnStr = "Order status updated sucessfully.";
		} else {
			returnStr = "Order status not updated. Please try again.";
		}
		return returnStr;
	}

	public String getOrderById(String orderId) {
		String returnStr = null;
		
		Orders order = orderRepository.findById(orderId).get();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			returnStr = mapper.writeValueAsString(order);
			System.out.println(returnStr);
			JSONObject jobj = new JSONObject(returnStr);
			List<OrderDetail> orderDetails = orderDetailRepository.findAllByOrder(order);
			System.out.println(orderDetails.size());
			
			JSONArray orderDetailArr = new JSONArray();
			for(int ind = 0; ind < orderDetails.size(); ind++) {
				String details = mapper.writeValueAsString(orderDetails.get(ind));
				orderDetailArr.put(new JSONObject(details));
			}
			
			jobj.put("orderDetails", orderDetailArr);
			returnStr = jobj.toString();
		} catch (JSONException | JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return returnStr;
	}
}
