package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
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
		return new ResponseEntity<List<Category>>(itemService.getAllCategories(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/category")
	public ResponseEntity<String> addCategory(@RequestBody Category category){
		return  new ResponseEntity<String>(itemService.addCategory(category), HttpStatus.CREATED);
	}
	
	@PutMapping("/category/{categoryId}")
	public ResponseEntity<String> updateCategory(@PathVariable String categoryId, @RequestBody Category category){
		return new ResponseEntity<String>(itemService.updateCategory(categoryId, category),HttpStatus.OK);
	}
	
	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable String categoryId){
		return new ResponseEntity<String>(itemService.deleteCategory(categoryId),HttpStatus.OK);
	}
	
	// Sub-Category
	
	@GetMapping("/subcategory")
	public ResponseEntity<List<SubCategory>> getAllSubCategories(){
		return new ResponseEntity<List<SubCategory>>(itemService.getAllSubCategories(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/subcategory")
	public ResponseEntity<String> addSubCategory(@RequestBody String subCategoryJson){
		JSONObject jobj;
		String responseStr = "";
		try {
			jobj = new JSONObject(subCategoryJson);
			responseStr = itemService.addSubCategory(jobj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return  new ResponseEntity<String>(responseStr, HttpStatus.CREATED);
	}
	
	@PutMapping("/subcategory/{subCategoryId}")
	public ResponseEntity<String> updateSubCategory(@PathVariable String subCategoryId, @RequestBody String subCategoryJson){
		JSONObject jobj;
		String responseStr = "";
		try {
			jobj = new JSONObject(subCategoryJson);
			responseStr = itemService.updateSubCategory(subCategoryId, jobj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(responseStr,HttpStatus.OK);
	}
	
	@DeleteMapping("/subcategory/{subCategoryId}")
	public ResponseEntity<String> deleteSubCategory(@PathVariable String subCategoryId){
		return new ResponseEntity<String>(itemService.deleteCategory(subCategoryId),HttpStatus.OK);
	}
	
	// Item
	
	@GetMapping("/item")
	public ResponseEntity<List<Item>> getAllItems(){
		return new ResponseEntity<List<Item>>(itemService.getAllItems(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/item")
	public ResponseEntity<String> addItem(@RequestBody String itemJson){
		JSONObject jobj;
		String responseStr = "";
		try {
			jobj = new JSONObject(itemJson);
			responseStr = itemService.addItem(jobj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return  new ResponseEntity<String>(responseStr, HttpStatus.CREATED);
	}
	
	@PutMapping("/item/{itemId}")
	public ResponseEntity<String> updateItem(@PathVariable String itemId, @RequestBody String itemJson){
		JSONObject jobj;
		String responseStr = "";
		try {
			jobj = new JSONObject(itemJson);
			responseStr = itemService.updateItem(itemId, jobj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return  new ResponseEntity<String>(responseStr, HttpStatus.OK);
	}
	
	@DeleteMapping("/item/{itemId}")
	public ResponseEntity<String> deleteItem(@PathVariable String itemId){
		return new ResponseEntity<String>(itemService.deleteItem(itemId),HttpStatus.OK);
	}
}
