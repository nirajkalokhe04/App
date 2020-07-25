package com.ecommerce.repository;

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
}
