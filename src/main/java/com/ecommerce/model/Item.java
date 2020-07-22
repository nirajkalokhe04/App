package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition =  Constants.VARCHAR_32)
	private String id;
	@Column(name="name", columnDefinition = Constants.VARCHAR_64)
	private String itemName;
	@Column(name="description", columnDefinition = Constants.VARCHAR_255)
	private String itemDescription;
	@Column(name="price")
	private double regularPrice;
	@Column(name="saleprice")
	private double salePrice;
	@Column(name="isavailable", columnDefinition = "Boolean")
	private Boolean isAvailable;
	@Column(name="istaxable", columnDefinition = "Boolean")
	private Boolean isTaxable;
	@OneToOne
	@JoinColumn(name = "subcategoryid")
	private SubCategory subCategory;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public double getRegularPrice() {
		return regularPrice;
	}
	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Boolean getIsTaxable() {
		return isTaxable;
	}
	public void setIsTaxable(Boolean isTaxable) {
		this.isTaxable = isTaxable;
	}
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", regularPrice="
				+ regularPrice + ", salePrice=" + salePrice + ", isAvailable=" + isAvailable + ", isTaxable="
				+ isTaxable + ", subCategory=" + subCategory + "]";
	}

	
}
