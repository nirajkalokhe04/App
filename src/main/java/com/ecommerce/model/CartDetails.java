package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@Column(name="cartid",insertable = false, updatable = false)
	private String id;
	
	@Column(name="itemid",columnDefinition = Constants.VARCHAR_32)
	private String itemId;
	
	@Column(name="size",columnDefinition = Constants.VARCHAR_32)
	private String size;
	
	@Column(name="price",columnDefinition = Constants.DOUBLE)
	private Double itemPrice;
	
	@Column(name="quantity",columnDefinition = "Integer Default 1")
	private Integer quantity;
	
	@Column(name="stocks",columnDefinition = "Integer Default 100")
	private Integer stocks;
	
	@Column(name="totalprice",columnDefinition = Constants.DOUBLE)
	private Double totalPrice;

	@Column(name="isactive",columnDefinition = "BOOLEAN")
	private Boolean isActive;
	
	private String itemName;
	
	private String apiKey;
	
	private String userId;

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getStocks() {
		return stocks;
	}

	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}

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

	@Override
	public String toString() {
		return "CartDetails [cartDetailId=" + cartDetailId + ", cartId=" + cartId + ", id=" + id + ", itemId=" + itemId
				+ ", size=" + size + ", itemPrice=" + itemPrice + ", quantity=" + quantity + ", stocks=" + stocks
				+ ", totalPrice=" + totalPrice + ", isActive=" + isActive + ", itemName=" + itemName + ", apiKey="
				+ apiKey + ", userId=" + userId + "]";
	}


	

	
}
