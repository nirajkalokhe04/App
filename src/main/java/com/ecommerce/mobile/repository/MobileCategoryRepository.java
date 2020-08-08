package com.ecommerce.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Item;
import com.ecommerce.model.SubCategory;

@Repository
public interface MobileCategoryRepository extends JpaRepository<SubCategory, String>{

//	@Query("from SubCategory sub where sub.category =:categoryid")
//	public List<SubCategory> getSubcategoryByCategory( @Param("category") String categoryid);
	
	
//	SELECT it from Item it inner join SubCategory sub on sub.id = it.subCategory inner join Category cat on sub.category =cat.id where it.isDashboard=1 and cat.categoryName like '%veg%'
	@Query("from SubCategory sub inner join Category cat on sub.category =cat.id where cat.categoryName like '%veg%' or cat.categoryName  like '%fruit%'") 
	List<SubCategory> getSubcategoryByCategory();
	
	

	
}
