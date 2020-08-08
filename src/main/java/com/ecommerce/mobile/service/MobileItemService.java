package com.ecommerce.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecommerce.mobile.repository.MobileCategoryRepository;
import com.ecommerce.mobile.repository.MobileItemRepository;
import com.ecommerce.model.Item;
import com.ecommerce.model.SubCategory;
@Service
public class MobileItemService {
	@Autowired
	MobileCategoryRepository mobileCategoryRepository;

	@Autowired
	MobileItemRepository mobileItemRepository;
	
	@Value("${item.images.path}")
	private String imagePath;
//	
	public List<SubCategory> getAllCategoriesForMobile() {
		// TODO Auto-generated method stub
		return mobileCategoryRepository.getSubcategoryByCategory();
	}

	public List<Item> getItemByCategory(String subcategoryId) {
		// TODO Auto-generated method stub
		return (List<Item>) mobileItemRepository.itemByCategory(subcategoryId);
	}

	public List<Item> searchItem(String searchText) {
		// TODO Auto-generated method stub
		List<Item> item = mobileItemRepository.searchByName(searchText);
		item.forEach(it -> it.setItemImages(mobileItemRepository.itemGalleryByIdPref(it.getId(),imagePath)));
		return item;
	}

}
