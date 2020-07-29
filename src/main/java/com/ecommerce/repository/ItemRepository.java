package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>{

	@Query("SELECT it FROM Item it where it.itemName =:ItemName")
	List<Item> sarchByName(@Param("ItemName")String ItemName);
	
	@Query("SELECT it from Item it inner join SubCategory sub on it.subCategory.id=sub.id where sub.category.id=:categoryId")
	List<Item> ItemByCategory(@Param("categoryId")String categoryId);


}
