package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name="offers")
public class Offers {

	
	@Id	
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition =  Constants.VARCHAR_32 )
	private String id; 

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="itemId",columnDefinition = Constants.VARCHAR_16) private
	 * String itemId;
	 */
	
	@Column(name="name",columnDefinition = Constants.VARCHAR_32)
	private String offerName;
	
	@Column(name="type", columnDefinition = "INT")
	private Integer offerType;
	
	@Column(name="isactive",columnDefinition = "BOOLEAN")
	private Boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public Integer getOfferType() {
		return offerType;
	}

	public void setOfferType(Integer offerType) {
		this.offerType = offerType;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Offers [id=" + id + ", offerName=" + offerName + ", offerType=" + offerType + ", isActive=" + isActive
				+ "]";
	}
	
	
	
}
