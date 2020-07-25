package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name="offerdetails") 
public class OfferDetails {
	
	@Id	
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition =  Constants.VARCHAR_32 )
	private String id; 
	
	@Column(name="offerid",columnDefinition =  Constants.VARCHAR_32 )
	private String offerId; 
	
	@Column(name="itemid",columnDefinition =  Constants.VARCHAR_32)
	private String itemId;
	
	@Column(name="isactive",columnDefinition = "BOOLEAN")
	private Boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "OfferDetails [id=" + id + ", offerId=" + offerId + ", itemId=" + itemId + ", isActive=" + isActive
				+ "]";
	}

	
	
}
