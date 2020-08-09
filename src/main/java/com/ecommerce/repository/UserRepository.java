package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{


	List<User> findByUsername(String username);

	@Query("SELECT user from User user where user.role=:role")
	List<User> findUserByRole(@Param("role")int role);
	
}
