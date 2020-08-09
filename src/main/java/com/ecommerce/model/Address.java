package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition =  Constants.VARCHAR_32)
	@SerializedName("id")
	private String id;
	@Column(name ="addressline", columnDefinition =  Constants.VARCHAR_255)
	@SerializedName("addline")
	private String addressline;
	
	@Column(name ="landmark", columnDefinition =  Constants.VARCHAR_255)
	@SerializedName("landmark")
	private String landmark;
	
	@Column(name ="area", columnDefinition =  Constants.VARCHAR_255)
	@SerializedName("area")
	private String area;
	
	@Column(name ="city", columnDefinition =  Constants.VARCHAR_255)
	@SerializedName("city")
	private String city;
	
	@Column(name ="pincode", columnDefinition ="INTEGER")
	@SerializedName("pincode")
	private String pincode;
	
	@Column(name ="userid", columnDefinition =   Constants.VARCHAR_32)
	@SerializedName("userId")
	private String userId;
	
	@Column(name ="addresstype", columnDefinition =  Constants.VARCHAR_32)
	@SerializedName("addresstype")
	private String addresstype;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return addressline;
	}

	public void setAddress(String address) {
		this.addressline = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressline=" + addressline + ", landmark=" + landmark + ", area=" + area + ", city="
				+ city + ", pincode=" + pincode + ", userId=" + userId + ", addresstype=" + addresstype + "]";
	}
	

	

}
