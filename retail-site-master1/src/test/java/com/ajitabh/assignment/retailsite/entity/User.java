package com.ajitabh.assignment.retailsite.entity;

import java.util.Date;

/**
 * @author AjitabhRaj
 *
 */

public class User {

	private String firstName;
	private String lastName;
	private String contactNo;
	private UserType userType;
	private String address;
	private Date firstShoppingDate;
	private Date lastShoppingDate;
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getFirstShoppingDate() {
		return firstShoppingDate;
	}

	public void setFirstShoppingDate(Date firstShoppingDate) {
		this.firstShoppingDate = firstShoppingDate;
	}

	public Date getLastShoppingDate() {
		return lastShoppingDate;
	}

	public void setLastShoppingDate(Date lastShoppingDate) {
		this.lastShoppingDate = lastShoppingDate;
	}

	public User(String firstName, String lastName, String contactNo, UserType userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.userType = userType;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param contactNo
	 * @param userType
	 * @param address
	 * @param firstShoppingDate
	 * @param lastShoppingDate
	 */
	public User(String firstName, String lastName, String contactNo, UserType userType,String address,Date firstShoppingDate,Date lastShoppingDate ) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setContactNo(contactNo);
		setUserType(userType);
		setAddress(address);
		setFirstShoppingDate(new Date());
		setLastShoppingDate(new Date());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public UserType getUserType() {
		return userType;
	}

	@Override
	public String toString() {
		return "[firstName=" + getFirstName() + ", lastName=" + getLastName() + ", telephone=" + getContactNo()
				+ ", userType=" + getUserType() + "]";
	}

}
