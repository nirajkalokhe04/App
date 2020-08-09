package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.UnitMaster;
import com.ecommerce.service.ItemUnitService;

@RestController
public class ItemUnitController {
	
	@Autowired
	ItemUnitService itemUnitService;
	
	@GetMapping("/units")
	public ResponseEntity<List<UnitMaster>> getAllUnits(){
		return new ResponseEntity<List<UnitMaster>>(itemUnitService.getAllUnits(), HttpStatus.OK);
	}
	
	@GetMapping("/units/{unitId}")
	public ResponseEntity<UnitMaster> getUnitDetails(@PathVariable String unitId){
		return new ResponseEntity<UnitMaster>(itemUnitService.getUnitDetails(unitId), HttpStatus.OK);
	}
	
	@PostMapping("/units")
	public ResponseEntity<String> addUnit(@RequestBody UnitMaster unitMaster){
		return new ResponseEntity<String>(itemUnitService.addUnit(unitMaster), HttpStatus.OK);
	}
	
	@PutMapping("/units/{unitId}")
	public ResponseEntity<String> updateUnit(@PathVariable String unitId, @RequestBody UnitMaster unitMaster){
		return null;
	}
	
	@DeleteMapping("/units/{unitId}")
	public ResponseEntity<String> deleteUnit(@PathVariable String unitId){
		return null;
	}
}
