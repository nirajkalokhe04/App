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

	@Column(name="unitid",insertable = false, updatable = false)
	private String sizeText;
	
	@Column(name="quantity", columnDefinition = "DOUBLE")
	private Double quantity;
	
	@Column(name="price", columnDefinition = "DOUBLE")
	private Double price;
	@Column(name="id", insertable = false, updatable = false)
	private String size_id;
	
	@Column(name = "itemid")
	private String item;
	
	@Column(name="unitid", columnDefinition = Constants.VARCHAR_32)
	private String unitId;
	
    @Column(name = "unitmasterid")
    private String unitMaster;

	public String getItemUnitMappingId() {
		return itemUnitMappingId;
	}

	public void setItemUnitMappingId(String itemUnitMappingId) {
		this.itemUnitMappingId = itemUnitMappingId;
	}

	public String getSizeText() {
		return sizeText;
	}

	public void setSizeText(String sizeText) {
		this.sizeText = sizeText;
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

	public String getSize_id() {
		return size_id;
	}

	public void setSize_id(String size_id) {
		this.size_id = size_id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void setUnitMaster(String unitMaster) {
		this.unitMaster = unitMaster;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	@Override
	public String toString() {
		return "ItemUnitMapping [itemUnitMappingId=" + itemUnitMappingId + ", sizeText=" + sizeText + ", quantity="
				+ quantity + ", price=" + price + ", size_id=" + size_id + ", item=" + item + ", unitId=" + unitId
				+ ", unitMaster=" + unitMaster + "]";
	}

	
	
}
