package com.ajitabh.assignment.retailsite.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DISCOUNT")
public class UserDiscount implements java.io.Serializable {

	private static final long serialVersionUID = 616647467466L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_DISCOUNT_ID", unique = true, nullable = false)
	private Long userDiscountId;

	@Column(name = "USER_TYPE", length = 20)
	private String userType;

	@Column(name = "DISCOUNT_TYPE", length = 20)
	private String discountType;

	@Column(name = "DISCOUNT_AMOUNT")
	private BigDecimal discountAmount;

	@Column(name = "STATUS", length = 1)
	private String status;
	
	public Long getUserDiscountId() {
		return userDiscountId;
	}

	public void setUserDiscountId(Long userDiscountId) {
		this.userDiscountId = userDiscountId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result + ((discountType == null) ? 0 : discountType.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userDiscountId == null) ? 0 : userDiscountId.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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
		UserDiscount other = (UserDiscount) obj;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (discountType == null) {
			if (other.discountType != null)
				return false;
		} else if (!discountType.equals(other.discountType))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userDiscountId == null) {
			if (other.userDiscountId != null)
				return false;
		} else if (!userDiscountId.equals(other.userDiscountId))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDiscount [userDiscountId=" + userDiscountId + ", userType=" + userType + ", discountType="
				+ discountType + ", discountAmount=" + discountAmount + ", status=" + status + "]";
	}
	
}