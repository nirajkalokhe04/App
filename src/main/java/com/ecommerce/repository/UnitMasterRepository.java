package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.UnitMaster;

@Repository
public interface UnitMasterRepository extends JpaRepository<UnitMaster, String>{

}
