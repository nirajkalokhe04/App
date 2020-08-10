package com.ecommerce.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import com.ecommerce.util.Constants;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition =  Constants.VARCHAR_32)
	private String id;
	@Column(name = "ordernumber")
	private String orderNumber;
	
	@Column(name ="deliveryslot" , columnDefinition = Constants.VARCHAR_32)
	private String deliverySlot;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "isdeleted")
	private Integer isDeleted;
	
	@Column(name = "isdeletedfromcustomer")
	private Integer isDeletedFromCustomer;
	
	@Column(name = "totalamount")
	private Double totalAmount;
	
	
	@Column(name = "deliveryCharge")
	private Double deliveryCharge;
	

	@Column(name = "orderedon")
	private Date orderedOn;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	@Column(name = "address"  , columnDefinition = Constants.VARCHAR_255)
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "userid",insertable = false, updatable = false)
	private User deliveryBoy;
	
	@Column(name ="ordernumber",insertable = false, updatable = false)
	private String transaction_id;

	@Column(name ="totalamount",insertable = false, updatable = false)
	private Double orderAmount;
	
	@Column(name ="orderedon",insertable = false, updatable = false)
	private Date orderAt;
	
//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "order", referencedColumnName = "id", nullable = false)
//	private Set<OrderDetail> orderDetail;
	
//	public Set<OrderDetail> getOrderDetail() {
//		return orderDetail;
//	}
//
//	public void setOrderDetail(Set<OrderDetail> orderDetail) {
//		this.orderDetail = orderDetail;
//	}

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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDeliverySlot() {
		return deliverySlot;
	}

	public void setDeliverySlot(String deliverySlot) {
		this.deliverySlot = deliverySlot;
	}

	public User getDeliveryBoy() {
		return deliveryBoy;
	}

	public void setDeliveryBoy(User deliveryBoy) {
		this.deliveryBoy = deliveryBoy;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getOrderAt() {
		return orderAt;
	}

	public void setOrderAt(Date orderAt) {
		this.orderAt = orderAt;
	}

	public Double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(Double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	@Override
	public String toString() {
		return "{id=" + id + ", orderNumber=" + orderNumber + ", deliverySlot=" + deliverySlot + ", status="
				+ status + ", isDeleted=" + isDeleted + ", isDeletedFromCustomer=" + isDeletedFromCustomer
				+ ", totalAmount=" + totalAmount + ", deliveryCharge=" + deliveryCharge + ", orderedOn=" + orderedOn
				+ ", customer=" + customer + ", user=" + user + ", addressId=" + address + ", deliveryBoy="
				+ deliveryBoy + ", transaction_id=" + transaction_id + ", orderAmount=" + orderAmount + ", orderAt="
				+ orderAt + "}";
	}

}
