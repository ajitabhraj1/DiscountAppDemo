package com.ajitabh.assignment.retailsite.model;

public enum OrderType {
	
	EMPLOYEE("E", "Employee"), AFFILIATE("A", "Affiliate"), CUSTOMER("C", "Customer");
	
	private String code;
	private String value;
	
	private OrderType(String code, String value) {
        this.code = code;
        this.value = value;
	}
	public String getCode() {
		return this.code;
	}
	public String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return getValue();
	}
	
}