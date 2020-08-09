package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition =  Constants.VARCHAR_32)
	private String id;
	private String address;
	private String  AddressLine;
	private String landmark;
	private String area;
	private String userId;
	private Integer addressType;
	private Boolean isDefault;
	private Integer pinCode;
	private Integer Postalcode;
	@OneToOne
	private City city;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getAddressType() {
		return addressType;
	}

	public void setAddressType(Integer addressType) {
		this.addressType = addressType;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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

	public String getAddressLine() {
		return AddressLine;
	}

	public void setAddressLine(String addressLine) {
		AddressLine = addressLine;
	}

	public Integer getPostalcode() {
		return Postalcode;
	}

	public void setPostalcode(Integer postalcode) {
		Postalcode = postalcode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", AddressLine=" + AddressLine + ", landmark=" + landmark
				+ ", area=" + area + ", userId=" + userId + ", addressType=" + addressType + ", isDefault=" + isDefault
				+ ", pinCode=" + pinCode + ", Postalcode=" + Postalcode + ", city=" + city + "]";
	}

	

}
