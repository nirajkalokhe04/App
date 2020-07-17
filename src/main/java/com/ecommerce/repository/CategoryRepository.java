package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.model.Categorys;

@ResponseBody
public interface CategoryRepository extends JpaRepository<Categorys, String>{

}
