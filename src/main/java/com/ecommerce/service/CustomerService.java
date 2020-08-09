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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public Integer addCustomer(Customer customer) {
		String returnStr = "Customer added successfully.";
		String pass = new BCryptPasswordEncoder().encode(customer.getPassword());
		customer.setPassword(pass);
		customer = customerRepository.save(customer);
		return 100;
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

	public Customer loginCustomer(String mobile, String password) {
		JSONObject returnJobj = new JSONObject();
		long isValid = 0;
		Customer customer = null;
		List<Customer> customerList = customerRepository.findByMobile(mobile);
		if(customerList.size() > 0) {
			if(new BCryptPasswordEncoder().matches(password, customerList.get(0).getPassword())) {
				isValid = 1;
				customer = customerList.get(0);
			}
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			returnJobj.put("isValid", isValid);
			returnJobj.put("message", isValid > 0 ? "Valid customer" : "Invalid customer");
			returnJobj.put("data", mapper.writeValueAsString(customer));
			returnJobj.put("id", customer.getId());
		} catch (JSONException | JsonProcessingException e) {
			e.printStackTrace();
		}
		return customer;
	}

	public Integer sendOtp(String mobileNumber) {
		// TODO Auto-generated method stub
		return 111111;
	}

	public Integer verifyOtp(String mobileNumber, String otp) {
		// TODO Auto-generated method stub
		return 1;
	}
}
