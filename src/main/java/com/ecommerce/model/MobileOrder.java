package com.ecommerce.model;

import java.util.ArrayList;

/**
 * @author Niraj
 *
 */
public class MobileOrder {

	private String orderType;
//	private String OrderType;
	 private float orderAmount;
	 
	 private String UserId;
	 private String userId;
	 private float ItemAmount;
	 
	 private float TaxAmount;
	 private float DeliveryCharge;
	 private float TotalAmount;
	 private String OrderAddress;
	 private int Status;
	 private ArrayList<Item> Items ;
	 private String DeliverySlot;
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		orderType = orderType;
	}
	public float getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public float getItemAmount() {
		return ItemAmount;
	}
	public void setItemAmount(float itemAmount) {
		ItemAmount = itemAmount;
	}
	public float getTaxAmount() {
		return TaxAmount;
	}
	public void setTaxAmount(float taxAmount) {
		TaxAmount = taxAmount;
	}
	public float getDeliveryCharge() {
		return DeliveryCharge;
	}
	public void setDeliveryCharge(float deliveryCharge) {
		DeliveryCharge = deliveryCharge;
	}
	public float getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getOrderAddress() {
		return OrderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		OrderAddress = orderAddress;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public ArrayList<Item> getItems() {
		return Items;
	}
	public void setItems(ArrayList<Item> items) {
		Items = items;
	}
	public String getDeliverySlot() {
		return DeliverySlot;
	}
	public void setDeliverySlot(String deliverySlot) {
		DeliverySlot = deliverySlot;
	}
	
	@Override
	public String toString() {
		return "MobileOrder [OrderType=" + orderType + ", orderAmount=" + orderAmount + ", UserId=" + UserId
				+ ", ItemAmount=" + ItemAmount + ", TaxAmount=" + TaxAmount + ", DeliveryCharge=" + DeliveryCharge
				+ ", TotalAmount=" + TotalAmount + ", OrderAddress=" + OrderAddress + ", Status=" + Status + ", Items="
				+ Items + ", DeliverySlot=" + DeliverySlot + "]";
	}
	 
	 
	
}
