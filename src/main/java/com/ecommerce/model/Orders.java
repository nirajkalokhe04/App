package com.ecommerce.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition =  Constants.VARCHAR_32)
	private String id;
	private String orderNumber;
	private Integer status;
	private Integer isDeleted;
	private Integer isDeletedFromCustomer;
	private Double totalAmount;
	private Date orderedOn;
	@ManyToOne
	private User userId;
	@ManyToOne
	private Address addressId;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "order", referencedColumnName = "id", nullable = false)
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
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
