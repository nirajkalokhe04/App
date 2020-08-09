package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.CartDetails;

@Repository
public interface CartDetailsRepository extends JpaRepository<CartDetails, String>{

	
	@Query("delete from CartDetails u where u.cartId = :cartId")
	void deleteCartDetails(@Param("cartId") String cartId);
	
	@Query("FROM  CartDetails t where t.cartId = :cartId and t.itemId =:itemId") 
    CartDetails findCartDetails(@Param("cartId") String cartId, @Param("itemId") String itemId);
	
	List<CartDetails> findByCartId(String cartId);
	
	@Query("SELECT t, (SELECT Itm.itemName FROM Item Itm WHERE Itm.id= t.itemId) as itemName FROM  CartDetails t where t.userId = :userId")
	List<CartDetails>  findByUserId(String userId);
	
}
