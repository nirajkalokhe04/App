package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, String>{

}
