package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
