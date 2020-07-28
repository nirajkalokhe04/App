package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name="unit")
public class UnitMaster {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="id", columnDefinition = Constants.VARCHAR_32)
	private String unitId;
	
	@Column(name="code", columnDefinition = Constants.VARCHAR_32)
	private String unitCode;
	
	@Column(name="description", columnDefinition = Constants.VARCHAR_64)
	private String unitDescription;

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitDescription() {
		return unitDescription;
	}

	public void setUnitDescription(String unitDescription) {
		this.unitDescription = unitDescription;
	}

	@Override
	public String toString() {
		return "UnitMaster [unitId=" + unitId + ", unitCode=" + unitCode + ", unitDescription=" + unitDescription + "]";
	}
	
	
}
