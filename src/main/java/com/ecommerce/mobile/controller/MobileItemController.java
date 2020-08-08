package com.ecommerce.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.mobile.service.MobileItemService;
import com.ecommerce.model.Item;
import com.ecommerce.model.SubCategory;


@RestController
public class MobileItemController {
	@Autowired
	MobileItemService itemService;

	@GetMapping("getCategory")
	public ResponseEntity<List<SubCategory>> getAllCategories() {
		return new ResponseEntity<List<SubCategory>>(itemService.getAllCategoriesForMobile(), HttpStatus.ACCEPTED);
	}
	
	/*
	 * @GetMapping("itemByCatId/{CategoryId}") public ResponseEntity<List<?>>
	 * getItemByCategory(@PathVariable String CategoryId)) { return new
	 * ResponseEntity<List<?>>(itemService.getAllCategoriesForMobile(),
	 * HttpStatus.ACCEPTED); }
	 */
	
	@GetMapping("itemByCatId/{CategoryId}")
	public ResponseEntity<List<Item>> getItemByCategory(@PathVariable String CategoryId){
		return new ResponseEntity<List<Item>>(itemService.getItemByCategory(CategoryId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/itemBySearchText/{SearchText}")
	public ResponseEntity<List<Item>> SearchItem(@PathVariable String SearchText){
		return new ResponseEntity<List<Item>>(itemService.searchItem(SearchText),HttpStatus.ACCEPTED);
	}
}
