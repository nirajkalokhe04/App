package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name="itemunitmapping")
public class ItemUnitMapping {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="id", columnDefinition = Constants.VARCHAR_32)
	private String itemUnitMappingId;
	
//	@Column(name="itemid", columnDefinition = Constants.VARCHAR_32)
//	private String itemId;
//	
//	@Column(name="unitid", columnDefinition = Constants.VARCHAR_32)
//	private String unitId;
	
	@Column(name="quantity", columnDefinition = "DOUBLE")
	private Double quantity;
	
	@Column(name="price", columnDefinition = "DOUBLE")
	private Double price;
	
	@ManyToOne
    @JoinColumn(name = "itemid")
    private Item item;
	
	@ManyToOne
    @JoinColumn(name = "unitmasterid")
    private UnitMaster unitMaster;

	public String getItemUnitMappingId() {
		return itemUnitMappingId;
	}

	public void setItemUnitMappingId(String itemUnitMappingId) {
		this.itemUnitMappingId = itemUnitMappingId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public UnitMaster getUnitMaster() {
		return unitMaster;
	}

	public void setUnitMaster(UnitMaster unitMaster) {
		this.unitMaster = unitMaster;
	}
	
}
