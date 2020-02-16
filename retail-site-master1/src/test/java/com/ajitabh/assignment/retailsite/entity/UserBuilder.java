package com.ajitabh.assignment.retailsite.entity;


import org.springframework.stereotype.Component;


@Component
public class UserBuilder {

	private String firstName;
	private String lastName;
	private String contactNo;
	private UserType userType;

	public UserBuilder() {

	}

	public UserBuilder firstName(String firstname) {
		this.firstName = firstname;
		return this;
	}

	public UserBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public UserBuilder contactNo(String contactNo) {
		this.contactNo = contactNo;
		return this;
	}

	public UserBuilder userType(UserType userType) {
		this.userType = userType;
		return this;
	}

	public User build() {
		return new User(firstName, lastName, contactNo, userType);
	}
}
