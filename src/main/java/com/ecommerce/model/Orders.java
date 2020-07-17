package com.ecommerce.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Orders implements Serializable {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="id")
	private String id;
	private String userId;
	private Integer status;
	private Integer isDeleted;
	private Integer isDeletedFromCustomer;
	private Double totalAmount;
	private Date orderedOn;
//	@OneToOne
//	private Address addressId;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetail;

	
	public Set<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getIsDeletedFromCustomer() {
		return isDeletedFromCustomer;
	}

	public void setIsDeletedFromCustomer(Integer isDeletedFromCustomer) {
		this.isDeletedFromCustomer = isDeletedFromCustomer;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderedOn() {
		return orderedOn;
	}

	public void setOrderedOn(Date orderedOn) {
		this.orderedOn = orderedOn;
	}

//	public Address getAddressId() {
//		return addressId;
//	}
//
//	public void setAddressId(Address addressId) {
//		this.addressId = addressId;
//	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", status=" + status + ", isDeleted=" + isDeleted
				+ ", isDeletedFromCustomer=" + isDeletedFromCustomer + ", totalAmount=" + totalAmount + ", orderedOn="
				+ orderedOn + ", orderDetail=" + orderDetail + "]";
	}

}
