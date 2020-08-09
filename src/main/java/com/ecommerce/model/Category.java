package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition =  Constants.VARCHAR_32)
	private String id;
	
	@Column(name="name", columnDefinition = Constants.VARCHAR_64)
	private String categoryName;
	
	@Column(name ="description", columnDefinition = Constants.VARCHAR_255)
	private String categoryDescription;
	
	@Column(name = "isactive" , columnDefinition = "BOOLEAN")
	private Boolean isActive;
	
	@Column(name="subcategory_id")
	private String subCategory;
	
	@Column(name="imagename")
	private String imageName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", categoryDescription=" + categoryDescription
				+ ", isActive=" + isActive + ", subCategory=" + subCategory + ", imageName=" + imageName + "]";
	}
		
}
