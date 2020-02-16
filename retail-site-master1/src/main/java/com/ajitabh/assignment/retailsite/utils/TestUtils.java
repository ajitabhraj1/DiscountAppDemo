package com.ajitabh.assignment.retailsite.utils;

import java.math.BigDecimal;

public class TestUtils {
	
	public static final String USER_TYPE_EMP="Employee";
	public static final String USER_TYPE_AFFLT="Affiliate";
	public static final String USER_TYPE_CUST="Customer";
	public static final String USER_TYPE_DEFAULT="DefaultUser";
	public static final BigDecimal EMPLOYEE_DISCOUNT = BigDecimal.valueOf(30);//Employee's discount  
	public static final BigDecimal AFFILIATE_DISCOUNT = BigDecimal.valueOf(10);//Affiliate's Discount
	public static final BigDecimal CUSTOMER_OLDER_THAN_TWO_YEARS_DISCOUNT = BigDecimal.valueOf(5);//Loyal customer discounts          
	public static final BigDecimal FLAT_DISCOUNT_FOR_HUNDRED_AMOUNT = BigDecimal.valueOf(5);            
	public static final String ITEM_TYPE_GROCERY = "GROCERY";//GROCERY won't entertain any discounts    
	public static final String ITEM_TYPE_OTHER = "OTHERS";                                              
	                                                                                                    
}
