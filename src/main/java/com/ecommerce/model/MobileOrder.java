
package com.ecommerce.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MobileOrder {

	@SerializedName("deliveryCharge")
	@Expose
	private Integer deliveryCharge;
	@SerializedName("deliverySlot")
	@Expose
	private String deliverySlot;
	@SerializedName("itemAmount")
	@Expose
	private Integer itemAmount;
	@SerializedName("items")
	@Expose
	private List<Item> items = null;
	@SerializedName("orderAddress")
	@Expose
	private String orderAddress;
	@SerializedName("orderAmount")
	@Expose
	private Integer orderAmount;
	@SerializedName("orderType")
	@Expose
	private String orderType;
	@SerializedName("status")
	@Expose
	private Integer status;
	@SerializedName("taxAmount")
	@Expose
	private Integer taxAmount;
	@SerializedName("totalAmount")
	@Expose
	private Double totalAmount;
	@SerializedName("userId")
	@Expose
	private String userId;	

	public Integer getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(Integer deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public String getDeliverySlot() {
		return deliverySlot;
	}

	public void setDeliverySlot(String deliverySlot) {
		this.deliverySlot = deliverySlot;
	}

	public Integer getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(Integer itemAmount) {
		this.itemAmount = itemAmount;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Integer taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "{deliveryCharge=" + deliveryCharge + ", deliverySlot=" + deliverySlot + ", itemAmount="
				+ itemAmount + ", items=" + items + ", orderAddress=" + orderAddress + ", orderAmount=" + orderAmount
				+ ", orderType=" + orderType + ", status=" + status + ", taxAmount=" + taxAmount + ", totalAmount="
				+ totalAmount + ", userId=" + userId + "}";
	}





}