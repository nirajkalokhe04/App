package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Categorys;
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

	public String addCategory(Categorys category) {
		String returnStr = "Category added sucessfully.";
		categoryRepository.save(category);
		return returnStr;
	}
	
	public String updateCategory(String categoryId,Categorys category) {
		String returnStr = "Category updated sucessfully.";
		 categoryRepository.save(category);
		 return returnStr;
				 
	}
	public String deleteCategory(String categoryId) {
		String returnStr = "Category updated sucessfully.";
		 categoryRepository.deleteById(categoryId);;
		 return returnStr;
	}
	
	public List<Categorys> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public List<SubCategory> getAllSubCategories() {
		return subCategoryRepository.findAll();
	}
	public String addSubCategory(SubCategory subCategory) {
		String returnStr = "Subcategory added sucessfully.";
		subCategoryRepository.save(subCategory);
		return returnStr;
	}
	
	public String updateSubCategory(SubCategory subCategory) {
		String returnStr = "Subcategory updated sucessfully.";
		subCategoryRepository.save(subCategory);
		return returnStr;
	}
	
	public String deleteSubCategory(String subCategoryId) {
		String returnStr = "Subcategory deleted sucessfully.";
		subCategoryRepository.deleteById(subCategoryId);
		return returnStr;
	
	}
	
	
	public String addItem(Item item) {
		String returnStr = "Item added sucessfully.";
		itemRepository.save(item);
		return returnStr;
	}
	
	public String updateItem(String itemId,Item item) {
		String returnStr = "Item updated sucessfully.";
		itemRepository.save(item);
		 return returnStr;
				 
	}
	public String deleteItem(String itemId) {
		String returnStr = "Item updated sucessfully.";
		itemRepository.deleteById(itemId);;
		 return returnStr;
	}
	
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
}
