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
@Table(name = "subcategory")
public class SubCategory {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition =  Constants.VARCHAR_32)
	private String id;
	
	@Column(name ="name", columnDefinition =  Constants.VARCHAR_64)
	private String subcategotryName;
	
	@Column(name ="name", insertable = false, updatable = false)
	private String categoryName; 
	
	@Column(name ="logo", insertable = false, updatable = false)
	private String categoryLogo; 
	
	@Column(name ="description", columnDefinition = "TEXT")
	private String subcategoryDescription;
	
	@Column(name ="isactive", columnDefinition = "BOOLEAN")
	private String isActive;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubcategotryName() {
		return subcategotryName;
	}

	public void setSubcategotryName(String subcategotryName) {
		this.subcategotryName = subcategotryName;
	}

	public String getSubcategoryDescription() {
		return subcategoryDescription;
	}

	public void setSubcategoryDescription(String subcategoryDescription) {
		this.subcategoryDescription = subcategoryDescription;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryLogo() {
		return categoryLogo;
	}

	public void setCategoryLogo(String categoryLogo) {
		this.categoryLogo = categoryLogo;
	}

	@Override
	public String toString() {
		return "SubCategory [id=" + id + ", subcategotryName=" + subcategotryName + ", categoryName=" + categoryName
				+ ", categoryLogo=" + categoryLogo + ", subcategoryDescription=" + subcategoryDescription
				+ ", isActive=" + isActive + ", category=" + category + "]";
	}
	

}
