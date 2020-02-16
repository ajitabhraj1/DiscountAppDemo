package com.ajitabh.assignment.retailsite.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_INFO")
public class EmployeeDetails implements java.io.Serializable {

	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 4910225916550731443L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID", unique = true, nullable = false)
	private Long empId;

	@Column(name = "FIRST_NAME", length = 30)
	private String firstname;

	@Column(name = "LAST_NAME", length = 30)
	private String lastname;

	@Column(name = "DESIGNATION", length = 30)
	private String designation;

	@Column(name = "SALARY")
	private Integer salary;

	@Column(name = "JOINING_DATE")
	private Date joiningDate;
	
	@Column(name = "MOBILE_NUMBER", length = 15)
	private Long mobileNumber;
	
	@Column(name = "ADDRESS", length = 150)
	private String address;
	
	@Column(name = "STATUS", length = 1)
	private String status;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
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
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((joiningDate == null) ? 0 : joiningDate.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		EmployeeDetails other = (EmployeeDetails) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (joiningDate == null) {
			if (other.joiningDate != null)
				return false;
		} else if (!joiningDate.equals(other.joiningDate))
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
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", designation=" + designation + ", salary=" + salary + ", joiningDate=" + joiningDate
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + ", status=" + status + "]";
	}

	public EmployeeDetails(Long empId, String firstname, String lastname, String designation, Integer salary,
			Date joiningDate, Long mobileNumber, String address, String status) {
		super();
		this.empId = empId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.designation = designation;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.status = status;
	}

}