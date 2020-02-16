package com.ajitabh.assignment.retailsite.model;

import javax.persistence.CascadeType;
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
@Table(name = "USER_INFO")
public class UserDetails implements java.io.Serializable {

	private static final long serialVersionUID = 6663733847388L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "USER_TYPE", length = 20)
	private String userType;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "AFFILIATE_ID", referencedColumnName = "AFFILIATE_ID")
	private AffiliateDetails affiliate;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
	private CustomerDetails customer;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private EmployeeDetails employee;

	public UserDetails(Long id, String userType, AffiliateDetails affiliate, CustomerDetails customer,
			EmployeeDetails employee) {
		super();
		this.id = id;
		this.userType = userType;
		this.affiliate = affiliate;
		this.customer = customer;
		this.employee = employee;
	}
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public AffiliateDetails getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(AffiliateDetails affiliate) {
		this.affiliate = affiliate;
	}

	public CustomerDetails getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}

	public EmployeeDetails getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDetails employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affiliate == null) ? 0 : affiliate.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UserDetails other = (UserDetails) obj;
		if (affiliate == null) {
			if (other.affiliate != null)
				return false;
		} else if (!affiliate.equals(other.affiliate))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}

}