package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {

	
	@Query("delete from Cart u where u.userId = :userId")
	void deleteInBulkByUserId(@Param("userId") String userId);
	
	  @Query("FROM  Cart t where t.userId = :userId") 
	    Cart findCartByUserId(@Param("userId") String userId);
	  
	  @Query("FROM  Cart t "
		  		+ "inner join CartDetails u on t.cartId = u.cartId where t.userId = :userId") 
		    List<Cart> findCartDetailsByUserId(@Param("userId") String userId);
}
