package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.model.Customer;
import com.ecommerce.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/Customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/Customers/{customerId}")
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable String customerId){
		return new ResponseEntity<Customer>(customerService.getCustomerDetails(customerId),HttpStatus.OK);
	}
	
	@PostMapping("/Customers")
	public ResponseEntity<Integer> addCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Integer>(customerService.addCustomer(customer), HttpStatus.OK);
	}
	
	@PutMapping("/Customers/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer){
		return new ResponseEntity<String>(customerService.updateCustomer(customerId, customer),HttpStatus.OK);
	}
	
	@DeleteMapping("/Customers/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String customerId){
		return new ResponseEntity<String>(customerService.deleteCustomer(customerId),HttpStatus.OK);
	}
	
	@PostMapping("/Customers/login")
	public ResponseEntity<Customer> loginCustomer(@RequestBody String loginData){// @RequestParam String mobile, @RequestParam String password){
		return new ResponseEntity<Customer>(customerService.loginCustomer(loginData), HttpStatus.OK);
	}
	
	@PostMapping("sendOtp/{MobileNumber}")
	public ResponseEntity<Integer> sendOtp(@PathVariable String MobileNumber){
		return new ResponseEntity<Integer>(customerService.sendOtp(MobileNumber), HttpStatus.OK);
	}
	
	@PostMapping("verifyOtp/{MobileNumber}/{Otp}")
	public ResponseEntity<Integer> verifyOtp(@PathVariable String MobileNumber,@PathVariable String Otp){
		return new ResponseEntity<Integer>(customerService.verifyOtp(MobileNumber,Otp), HttpStatus.OK);
	}
}
