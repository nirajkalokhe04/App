package com.ecommerce.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	
	@Column(name="description", insertable = false,updatable = false)
	private String description;
	
	
	@Column(name="price")
	private double regularPrice;
	
	@Column(name="price" , insertable = false, updatable = false)
	private double price;
	
	@Column(name="saleprice")
	private double salePrice;
	
	@Column(name="saleprice", insertable = false, updatable = false)
	private double offerPrice;
	
	@Column(name="quantity", columnDefinition = "INTEGER")
	private Integer quantity;
		
	@Column(name="isavailable", columnDefinition = "Boolean")
	private Integer isAvailable;
	
	@Column(name="isavailable", insertable = false, updatable = false)
	private Integer isExists;
	
	@Column(name="istaxable", columnDefinition = "Boolean")
	private Boolean isTaxable;
	
	@Column(name="isdashboard", columnDefinition = "Boolean")
	private Boolean isDashboard;
	
	@Column(name="isactive", columnDefinition = "Boolean")
	private Integer isActive; 
	
	@Column(name ="itemunit", columnDefinition =  Constants.VARCHAR_16)
	private String itemUnit;
	
	@Transient
	private String itemImages[];
	
	@OneToOne
	@JoinColumn(name = "subcategoryid")
	private SubCategory subCategory;
	
//	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
//    private Set<ItemUnitMapping> itemUnitMapping = new HashSet<>();
	
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
	public Integer getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Integer isAvailable) {
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
	
	public Boolean getIsDashboard() {
		return isDashboard;
	}
	public void setIsDashboard(Boolean isDashboard) {
		this.isDashboard = isDashboard;
	}
	
	public String[] getItemImages() {
		return itemImages;
	}
	public void setItemImages(String[] itemImages) {
		this.itemImages = itemImages;
	}
	
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public String getItemUnit() {
		return itemUnit;
	}
	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIsExists() {
		return isExists;
	}
	public void setIsExists(Integer isExists) {
		this.isExists = isExists;
	}
	public double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
//	public Set<ItemUnitMapping> getItemUnitMapping() {
//		return itemUnitMapping;
//	}
//	public void setItemUnitMapping(Set<ItemUnitMapping> itemUnitMapping) {
//		this.itemUnitMapping = itemUnitMapping;
//	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", description="
				+ description + ", regularPrice=" + regularPrice + ", price=" + price + ", salePrice=" + salePrice
				+ ", offerPrice=" + offerPrice + ", quantity=" + quantity + ", isAvailable=" + isAvailable
				+ ", isExists=" + isExists + ", isTaxable=" + isTaxable + ", isDashboard=" + isDashboard + ", isActive="
				+ isActive + ", itemUnit=" + itemUnit + ", itemImages=" + Arrays.toString(itemImages) + ", subCategory="
				+ subCategory + "]";
	}
	
}
