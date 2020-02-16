package com.ajitabh.assignment.retailsite.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails implements java.io.Serializable {

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 6665916550731444L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID", unique = true, nullable = false)
	private Long orderId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID", referencedColumnName = "ID")
	private UserDetails user;
	
	@Column(name = "DESCRIPTION", length = 50)
	private String description;

	@Column(name = "ORDER_TYPE", length = 20)
	private String orderType;

	@Column(name = "QUANTITY", length = 5)
	private int qunatity;
	
	@Column(name = "PRICE", length = 5)
	private BigDecimal price;
	
	@Column(name = "UNIT", length = 10)
	private String unit;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public int getQunatity() {
		return qunatity;
	}

	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderType == null) ? 0 : orderType.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + qunatity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderType == null) {
			if (other.orderType != null)
				return false;
		} else if (!orderType.equals(other.orderType))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (qunatity != other.qunatity)
			return false;
		if (unit != other.unit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", user=" + user + ", description=" + description + ", orderType="
				+ orderType + ", qunatity=" + qunatity + ", price=" + price + ", unit=" + unit + "]";
	}
	
	public OrderDetails(Long orderId, UserDetails user, String description, String orderType, int qunatity,
			BigDecimal price, String unit) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.description = description;
		this.orderType = orderType;
		this.qunatity = qunatity;
		this.price = price;
		this.unit = unit;
	}

}