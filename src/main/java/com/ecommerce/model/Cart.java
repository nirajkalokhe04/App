package com.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;


@Entity
@Table(name="usercart")
public class Cart {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="id", columnDefinition = Constants.VARCHAR_32)
	private String cartId;
	
	@Column(name="userid", columnDefinition = Constants.VARCHAR_32)
	private String userId;

	@Column(name="isactive", columnDefinition = "BOOLEAN")
	private Boolean isActive;

	@Column(name="total", columnDefinition = Constants.DOUBLE)
	private Double cartTotal;
	
	@OneToMany
    @JoinColumn(name = "cartid", referencedColumnName = "id")
    private List<CartDetails> cartDetails;

	
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
	public List<CartDetails> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetails> cartDetails) {
		this.cartDetails = cartDetails;
	}

	
	public Double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(Double cartTotal) {
		this.cartTotal = cartTotal;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", isActive=" + isActive + ", cartTotal=" + cartTotal
				+ ", cartDetails=" + cartDetails + "]";
	}
	
	

}
