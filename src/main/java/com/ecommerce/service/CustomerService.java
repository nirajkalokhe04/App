package com.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.CustomerNotFound;
import com.ecommerce.exception.UserNotFound;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	public Customer getCustomerDetails(String customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFound("Customer not exist."));
	}
	
	public String addCustomer(Customer customer) {
		String returnStr = "Customer added successfully.";
		String pass = new BCryptPasswordEncoder().encode(customer.getPassword());
		customer.setPassword(pass);
		customer = customerRepository.save(customer);
		return returnStr;
	}
	
	public String updateCustomer(String customerId, Customer customer) {
		String returnStr = "Customer updated successfully.";
		customerRepository.findById(customerId).map(customerObj -> {
			customer.setId(customerId);
			customer.setPassword(customerObj.getPassword());
			return customerRepository.save(customer);
		}).orElseThrow(() -> new CustomerNotFound("Customer not found."));
		return returnStr;
	}
	
	public String deleteCustomer(String customerId) {
		customerRepository.findById(customerId).ifPresent(customer -> {
			customer.setDeleted(true);
			customerRepository.save(customer);
		});
		return "Customer deleted.";
	}

	public String loginCustomer(String mobile, String password) {
		JSONObject returnJobj = new JSONObject();
		long isValid = 0;
		List<Customer> customerList = customerRepository.findByMobile(mobile);
		if(customerList.size() > 0) {
			if(new BCryptPasswordEncoder().matches(password, customerList.get(0).getPassword())) {
				isValid = 1;
			}
		}
		try {
			returnJobj.put("isValid", isValid);
			returnJobj.put("message", isValid > 0 ? "Valid customer" : "Invalid customer");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return returnJobj.toString();
	}
}
