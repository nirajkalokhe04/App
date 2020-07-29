package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Category;
import com.ecommerce.model.Item;
import com.ecommerce.model.SubCategory;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.SubCategoryRepository;

@Service
public class ItemService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	ItemRepository itemRepository;

	public String addCategory(Category category) {
		String returnStr = "Category added sucessfully.";
		categoryRepository.save(category);
		return returnStr;
	}
	
	public String updateCategory(String categoryId,Category category) {
		String returnStr = "Category updated sucessfully.";
		Category cat = categoryRepository.findById(categoryId).get();
		category.setId(cat.getId());
		categoryRepository.save(category);
		return returnStr;
				 
	}
	public String deleteCategory(String categoryId) {
		String returnStr = "Category updated sucessfully.";
		categoryRepository.deleteById(categoryId);;
		return returnStr;
	}
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public List<SubCategory> getAllSubCategories() {
		return subCategoryRepository.findAll();
	}
	public String addSubCategory(JSONObject subCategoryJson) {
		String returnStr = "Subcategory added sucessfully.";
		
		SubCategory subCategory = new SubCategory();
		subCategory.setSubcategotryName(subCategoryJson.optString("name"));
		System.out.println(subCategoryJson);
		Category category = categoryRepository.findById(subCategoryJson.optString("categoryId")).get();
		subCategory.setCategory(category);
		
		subCategoryRepository.save(subCategory);
		return returnStr;
	}
	
	public String updateSubCategory(String subCategoryId, JSONObject subCategoryJson) {
		String returnStr = "Subcategory updated sucessfully.";
		SubCategory subCategory = subCategoryRepository.findById(subCategoryId).get();
		subCategory.setSubcategotryName(subCategoryJson.optString("name"));
		Category category = categoryRepository.findById(subCategoryJson.optString("categoryId")).get();
		subCategory.setCategory(category);
		
		subCategoryRepository.save(subCategory);
		return returnStr;
	}
	
	public String deleteSubCategory(String subCategoryId) {
		String returnStr = "Subcategory deleted sucessfully.";
		subCategoryRepository.deleteById(subCategoryId);
		return returnStr;
	}
	
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
	
	public String addItem(JSONObject itemJson) {
		String returnStr = "Item added sucessfully.";
		
		Item item = new Item();
		item.setItemName(itemJson.optString("name"));
		item.setRegularPrice(itemJson.optDouble("price"));
		item.setSalePrice(itemJson.optDouble("salePrice"));
		SubCategory subCategory = subCategoryRepository.findById(itemJson.optString("subCategoryId")).get();
		item.setSubCategory(subCategory);
		
		itemRepository.save(item);
		return returnStr;
	}
	
	public String updateItem(String itemId, JSONObject itemJson) {
		String returnStr = "Item updated sucessfully.";
		
		Item item = itemRepository.findById(itemId).get();
		item.setItemName(itemJson.optString("name"));
		item.setRegularPrice(itemJson.optDouble("price"));
		SubCategory subCategory = subCategoryRepository.findById(itemJson.optString("subCategoryId")).get();
		item.setSubCategory(subCategory);
		
		itemRepository.save(item);
		return returnStr;
	}
	public String deleteItem(String itemId) {
		String returnStr = "Item updated sucessfully.";
		itemRepository.deleteById(itemId);
		return returnStr;
	}

	public List<Item> searchItem(String itemName) {
		return itemRepository.sarchByName(itemName);
	}
	
	public List<Item> getItemByCategory(String categoryId) {
		return itemRepository.ItemByCategory(categoryId);
	}
}
