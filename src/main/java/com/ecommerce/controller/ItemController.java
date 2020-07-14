package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Category;
import com.ecommerce.model.Item;
import com.ecommerce.model.SubCategory;
import com.ecommerce.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAllCategories(){
		return null;
	}
	
	@PostMapping("/category")
	public ResponseEntity<String> addCategory(@RequestBody Category category){
		return null;
	}
	
	@PutMapping("/category/{categoryId}")
	public ResponseEntity<String> updateCategory(@PathVariable String categoryId, @RequestBody Category category){
		return null;
	}
	
	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable String categoryId){
		return null;
	}
	
	// Sub-Category
	
	@GetMapping("/subcategory")
	public ResponseEntity<List<SubCategory>> getAllSubCategories(){
		return null;
	}
	
	@PostMapping("/subcategory")
	public ResponseEntity<String> addSubCategory(@RequestBody Category category){
		return null;
	}
	
	@PutMapping("/subcategory/{subCategoryId}")
	public ResponseEntity<String> updateSubCategory(@PathVariable String subCategoryId, @RequestBody SubCategory subCategory){
		return null;
	}
	
	@DeleteMapping("/subcategory/{subCategoryId}")
	public ResponseEntity<String> deleteSubCategory(@PathVariable String subCategoryId){
		return null;
	}
	
	// Item
	
	@GetMapping("/item")
	public ResponseEntity<List<Item>> getAllItems(){
		return null;
	}
	
	@PostMapping("/item")
	public ResponseEntity<String> addItem(@RequestBody Item item){
		return null;
	}
	
	@PutMapping("/item/{itemId}")
	public ResponseEntity<String> updateItem(@PathVariable String itemId, @RequestBody Item item){
		return null;
	}
	
	@DeleteMapping("/item/{itemId}")
	public ResponseEntity<String> deleteItem(@PathVariable String itemId){
		return null;
	}
}
