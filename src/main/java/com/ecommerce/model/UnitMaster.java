package com.ecommerce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private String code;
	
	@Column(name="description", columnDefinition = Constants.VARCHAR_64)
	private String description;
	
	@Column(name = "isdeleted")
	private boolean isDeleted;

//	@OneToMany(mappedBy = "unitMaster", cascade = CascadeType.ALL)
//    private Set<ItemUnitMapping> itemUnitMapping = new HashSet<>();
	
	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

//	public Set<ItemUnitMapping> getItemUnitMapping() {
//		return itemUnitMapping;
//	}
//
//	public void setItemUnitMapping(Set<ItemUnitMapping> itemUnitMapping) {
//		this.itemUnitMapping = itemUnitMapping;
//	}

	@Override
	public String toString() {
		return "UnitMaster [unitId=" + unitId + ", code=" + code + ", description=" + description + ", isDeleted="
				+ isDeleted + "]";
	}
}
