package com.ecommerce.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Orders;

@Repository
public interface  MobileOrderRepository extends JpaRepository<Orders, String>{

	@Query("from Orders orders where orders.user.id =:userId")
	List<Orders> getAllUserOrders(@Param("userId") String userId);

}
