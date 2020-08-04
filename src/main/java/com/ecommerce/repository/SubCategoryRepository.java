package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, String>{

//	@Query("from SubCategory sub where sub.category =:categoryid")
//	public List<SubCategory> getSubcategoryByCategory( @Param("category") String categoryid);
	
	@Query("FROM  SubCategory t where t.category.id = :category") 
	List<SubCategory> getSubcategoryByCategory(@Param("category") String category);
}
