package com.ecommerce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.model.Item;
import com.ecommerce.service.DashboardService;

@Controller
public class DashboardController {

	@Autowired
	DashboardService dashboardservice;
	
	@GetMapping("/vegetable-products")
	public ResponseEntity<List<Item>> getVegetableProducts(){
		return new ResponseEntity<List<Item>>(dashboardservice.getVegetables(),HttpStatus.OK);
	}
	
	@GetMapping("/fruits-products")
	public ResponseEntity<List<Item>> getFruitsProducts(){
		return new ResponseEntity<List<Item>>(dashboardservice.getFruits(),HttpStatus.OK);
	}
	
	@GetMapping("/offer-products")
	public ResponseEntity<List<Item>> getOfferProducts(){
		return new ResponseEntity<List<Item>>(dashboardservice.getOfferItems(),HttpStatus.OK);
	}
}
