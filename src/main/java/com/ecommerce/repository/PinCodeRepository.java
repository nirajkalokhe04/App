package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.PinCode;
@Repository
public interface PinCodeRepository extends JpaRepository<PinCode, String> {

	@Query(" from PinCode it where it.pinCode =:pinCode")
	PinCode checkPincode(@Param("pinCode") Integer pinCode);

}
