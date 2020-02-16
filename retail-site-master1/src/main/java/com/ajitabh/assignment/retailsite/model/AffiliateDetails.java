package com.ajitabh.assignment.retailsite.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AFFILIATE_INFO")
public class AffiliateDetails implements java.io.Serializable {

	private static final long serialVersionUID = 4910225916550731441L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AFFILIATE_ID", unique = true, nullable = false)
	private Long affiliateId;

	@Column(name = "AFFILIATE_TYPE", length = 25,nullable=false)
	private String affiliateType;
	
	@Column(name = "FIRST_NAME", length = 30)
	private String firstname;

	@Column(name = "LAST_NAME", length = 30)
	private String lastname;

	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "MOBILE_NUMBER", length = 15)
	private Long mobileNumber;
	
	@Column(name = "ADDRESS", length = 200)
	private String address;

	@Column(name = "STATUS", length = 1)
	private String status;
	
	public Long getAffiliateId() {
		return affiliateId;
	}

	public void setAffiliateId(Long affiliateId) {
		this.affiliateId = affiliateId;
	}

	public String getAffiliateType() {
		return affiliateType;
	}

	public void setAffiliateType(String affiliateType) {
		this.affiliateType = affiliateType;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((affiliateId == null) ? 0 : affiliateId.hashCode());
		result = prime * result + ((affiliateType == null) ? 0 : affiliateType.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		AffiliateDetails other = (AffiliateDetails) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (affiliateId == null) {
			if (other.affiliateId != null)
				return false;
		} else if (!affiliateId.equals(other.affiliateId))
			return false;
		if (affiliateType == null) {
			if (other.affiliateType != null)
				return false;
		} else if (!affiliateType.equals(other.affiliateType))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AffiliateDetails [affiliateId=" + affiliateId + ", affiliateType=" + affiliateType + ", firstname="
				+ firstname + ", lastname=" + lastname + ", startDate=" + startDate + ", mobileNumber=" + mobileNumber
				+ ", address=" + address + ", status=" + status + "]";
	}

}