package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Item;
import com.ecommerce.repository.ItemRepository;

@Service
public class DashboardService {
	@Autowired
	ItemRepository itemRepository;
	
	
	public List<Item> getVegetables() {
		
		return itemRepository.VegetableItemsForDashboard();
		
	}

	public List<Item> getFruits() {
		// TODO Auto-generated method stub
		return itemRepository.VegetableItemsForDashboard();
	}

	public List<Item> getOfferItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
