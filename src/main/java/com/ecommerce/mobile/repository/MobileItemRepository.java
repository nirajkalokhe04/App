package com.ecommerce.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Item;
import com.ecommerce.model.SubCategory;

@Repository
public interface MobileItemRepository extends JpaRepository<Item, String>{

	
	@Query("SELECT it FROM Item it where it.itemName  like CONCAT('%',:ItemName,'%')")
	List<Item> searchByName(@Param("ItemName") String ItemName);

	/*
	 * @Query("SELECT it.id, it.itemName as itemName, '' as itemImage,it.regularPrice as price,it.isAvailable as isExists,"
	 * +
	 * "it.isActive as isActive, 100 as quantity, it.itemDescription as description, it.itemUnit, it.salePrice as offerPrice,"
	 * +
	 * " it.subCategory.id as categoryId, '' as categoryName,'' as previousQuantity, '' as updateAt from Item it where it.subCategory.id =:subcategoryId "
	 * ) List<Item> itemByCategory(@Param("subcategoryId") String subcategoryId);
	 */

	
	@Query("SELECT it, '' as itemImage,"
			+ " 100 as quantity, it.itemUnit, "
			+ " it.subCategory.id as categoryId, it.subCategory.subcategotryName as categoryName,'' as previousQuantity, '' as updateAt from Item it where it.subCategory.id =:subcategoryId ")
	List<Item> itemByCategory(@Param("subcategoryId") String subcategoryId);

	
	@Query(value ="SELECT concat(:imagePath,ig.galleryPath) as galleryPath FROM ItemGallery ig where ig.itemId =:itemId and ig.preference=1")
	public String[] itemGalleryByIdPref(@Param("itemId")String itemId, @Param("imagePath")String imagePath);
}
