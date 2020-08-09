package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.UnitMaster;
import com.ecommerce.repository.UnitMasterRepository;

@Service
public class ItemUnitService {

	@Autowired
	UnitMasterRepository itemUnitRepository;
	
	public List<UnitMaster> getAllUnits() {
		return itemUnitRepository.findAll();
	}

	public UnitMaster getUnitDetails(String unitId) {
		return itemUnitRepository.findById(unitId).orElseThrow(() -> new RuntimeException("Unit not found."));
	}

	public String deleteUnit(String unitId) {
		itemUnitRepository.findById(unitId).ifPresent(unit -> {
			unit.setDeleted(true);
			itemUnitRepository.save(unit);
		});
		return "Unit deleted.";
	}

	public String addUnit(UnitMaster unitMaster) {
		itemUnitRepository.save(unitMaster);
		return "Unit added.";
	}

}
