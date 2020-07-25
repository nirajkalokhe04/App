package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name = "orderdetail")
public class OrderDetail {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(columnDefinition = Constants.VARCHAR_32)
	private String id;
	@OneToOne
	private Item item;
	private double price;
	private double quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	private Orders order;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", order=" + "]";
	}

}
