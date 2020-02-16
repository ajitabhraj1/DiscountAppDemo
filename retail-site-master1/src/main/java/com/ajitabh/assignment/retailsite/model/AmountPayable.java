package com.ajitabh.assignment.retailsite.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.ajitabh.assignment.retailsite.utils.TestUtils;

public class AmountPayable {


	public static void main(String args[]) {

		// Assume the userType is Affliate
		String userType = "Affiliate";
		BigDecimal amountPayable = calcPayableAmount(userType);
		System.out.println("Final amount payable is :" + String.valueOf(amountPayable));
	}

	@SuppressWarnings("deprecation")
	public static BigDecimal calcPayableAmount(String userType) {

		List<OrderDetails> orders = new ArrayList<>();
		EmployeeDetails emp1 = new EmployeeDetails(Long.valueOf("1"), "Ajitabh", "Raj", "Sales Agent", Integer.valueOf("25000"), new Date("23-JUN-17"), Long.valueOf("441234567890"), "Dubai", "A");
		UserDetails user1 = new UserDetails(100L, "Employee", null, null, emp1);

		EmployeeDetails emp2 = new EmployeeDetails(Long.valueOf("2"), "Ajitabh", "Raj", "Sales Agent", Integer.valueOf("50000"), new Date("2-OCT-15"), Long.valueOf("551234567890"), "Sharjah", "A");
		UserDetails user2 = new UserDetails(101L, "Employee", null, null, emp2);

		EmployeeDetails emp3 = new EmployeeDetails(Long.valueOf("3"), "Ajitabh", "Raj", "Sales Agent", Integer.valueOf("42000"), new Date("25-JAN-16"), Long.valueOf("661234567890"), "Al AIN", "A");
		UserDetails user3 = new UserDetails(102L, "Employee", null, null, emp3);

		// Add all the orders in a list
		OrderDetails order1 = new OrderDetails(1L, user1, "Veg1", "Grocery", 2, BigDecimal.valueOf(20), "KG");
		OrderDetails order2 = new OrderDetails(2L, user2, "Rice", "Grocery", 2, BigDecimal.valueOf(35), "KG");
		OrderDetails order3 = new OrderDetails(3L, user3, "Mobile", "Electronic", 2, BigDecimal.valueOf(435), "Per Peice");
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);

		List<OrderDetails> employeeOrders = orders.stream().filter(order -> order.getUser().getEmployee() != null).collect(Collectors.toList());
		List<OrderDetails> affiliateOrders = orders.stream().filter(order -> order.getUser().getAffiliate() != null).collect(Collectors.toList());
		List<OrderDetails> customerOrders = orders.stream().filter(order -> order.getUser().getCustomer() != null).collect(Collectors.toList());

		BigDecimal amountPayable;
		Map<String, BigDecimal> orderPrice = new HashMap<>();

		if(!employeeOrders.isEmpty()) {
			for(OrderDetails order : employeeOrders) {
				if(TestUtils.ITEM_TYPE_GROCERY.equalsIgnoreCase(order.getOrderType())) {
					orderPrice.put(TestUtils.ITEM_TYPE_GROCERY, orderPrice.get(TestUtils.ITEM_TYPE_GROCERY) == null ? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity())) : orderPrice.get(TestUtils.ITEM_TYPE_GROCERY).add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				} else {
					orderPrice.put(TestUtils.ITEM_TYPE_OTHER, orderPrice.get(TestUtils.ITEM_TYPE_OTHER) == null ? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity())) : orderPrice.get(TestUtils.ITEM_TYPE_OTHER).add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				}
			}
		} else if(!affiliateOrders.isEmpty()) {
			for(OrderDetails order : affiliateOrders) {
				if(TestUtils.ITEM_TYPE_GROCERY.equalsIgnoreCase(order.getOrderType())) {
					orderPrice.put(TestUtils.ITEM_TYPE_GROCERY, orderPrice.get(TestUtils.ITEM_TYPE_GROCERY) == null ? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity())) : orderPrice.get(TestUtils.ITEM_TYPE_GROCERY).add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				} else {
					orderPrice.put(TestUtils.ITEM_TYPE_OTHER, orderPrice.get(TestUtils.ITEM_TYPE_OTHER) == null ? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity())) : orderPrice.get(TestUtils.ITEM_TYPE_OTHER).add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				}
			}
		} else if(!customerOrders.isEmpty()) {
			for(OrderDetails order : customerOrders) {
				if(TestUtils.ITEM_TYPE_GROCERY.equalsIgnoreCase(order.getOrderType())) {
					orderPrice.put(TestUtils.ITEM_TYPE_GROCERY, orderPrice.get(TestUtils.ITEM_TYPE_GROCERY) == null ? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity())) : orderPrice.get(TestUtils.ITEM_TYPE_GROCERY).add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				} else {
					orderPrice.put(TestUtils.ITEM_TYPE_OTHER, orderPrice.get(TestUtils.ITEM_TYPE_OTHER) == null ? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity())) : orderPrice.get(TestUtils.ITEM_TYPE_OTHER).add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				}
			}
		}
		// Calculate the amount excluding grocery type as all other percentage based discounts are based on conditions
		BigDecimal amountExcludingGrocery = orderPrice.get(TestUtils.ITEM_TYPE_OTHER);

		// Case statement for user type
		switch (userType) {
		case TestUtils.USER_TYPE_EMP:
			amountPayable = calcTotalDiscount(amountExcludingGrocery, TestUtils.EMPLOYEE_DISCOUNT);
			break;
		case TestUtils.USER_TYPE_AFFLT:
			amountPayable = calcTotalDiscount(amountExcludingGrocery, TestUtils.AFFILIATE_DISCOUNT);
			break;
		case TestUtils.USER_TYPE_CUST:
			amountPayable = calcTotalDiscount(amountExcludingGrocery, TestUtils.CUSTOMER_OLDER_THAN_TWO_YEARS_DISCOUNT);
			break;
		default:
			amountPayable = calcDefaultAmountDiscount(amountExcludingGrocery);
		}
		return amountPayable;
	}

	private static BigDecimal calcDefaultAmountDiscount(BigDecimal amount) {
		BigDecimal discount = BigDecimal.ZERO;
		if(amount.compareTo(BigDecimal.valueOf(100)) > 0) {
			discount = amount.divide(BigDecimal.valueOf(100)).setScale(0, RoundingMode.DOWN).multiply(TestUtils.FLAT_DISCOUNT_FOR_HUNDRED_AMOUNT);
		}
		return amount.subtract(discount);
	}

	private static BigDecimal calcTotalDiscount(BigDecimal amount, BigDecimal discountPercentage) {
		BigDecimal discount = BigDecimal.ZERO;
		amount = calcDefaultAmountDiscount(amount);
		discount = discount.add(amount.multiply(discountPercentage).divide(BigDecimal.valueOf(100)));
		return amount.subtract(discount);
	}

}