package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name="cartdetails")
public class CartDetails {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="id", columnDefinition = Constants.VARCHAR_32)
	private String cartDetailId;
	
	@Column(name="cartid",columnDefinition = Constants.VARCHAR_32)
	private String cartId;
	
	@Column(name="itemid",columnDefinition = Constants.VARCHAR_32)
	private String itemId;
	
	@Column(name="price",columnDefinition = Constants.DOUBLE)
	private Double itemPrice;
	

	@Column(name="isactive",columnDefinition = "BOOLEAN")
	private Boolean isActive;

	public String getCartDetailId() {
		return cartDetailId;
	}

	public void setCartDetailId(String cartDetailId) {
		this.cartDetailId = cartDetailId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
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

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "CartDetails [cartDetailId=" + cartDetailId + ", cartId=" + cartId + ", itemId=" + itemId
				+ ", itemPrice=" + itemPrice + ", isActive=" + isActive + "]";
	}
	
	
	
}
