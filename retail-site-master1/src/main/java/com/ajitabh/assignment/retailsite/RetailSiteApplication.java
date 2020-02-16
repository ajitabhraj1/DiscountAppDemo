package com.ajitabh.assignment.retailsite;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ajitabh.assignment.retailsite.model.AffiliateDetails;
import com.ajitabh.assignment.retailsite.model.CustomerDetails;
import com.ajitabh.assignment.retailsite.model.EmployeeDetails;
import com.ajitabh.assignment.retailsite.model.OrderDetails;
import com.ajitabh.assignment.retailsite.model.UserDetails;
import com.ajitabh.assignment.retailsite.model.UserDiscount;
import com.ajitabh.assignment.retailsite.repository.AffiliateDetailsRepository;
import com.ajitabh.assignment.retailsite.repository.CustomerDetailsRepository;
import com.ajitabh.assignment.retailsite.repository.EmployeeDetailsRepository;
import com.ajitabh.assignment.retailsite.repository.OrderDetailsRepository;
import com.ajitabh.assignment.retailsite.repository.UserDetailsRepository;
import com.ajitabh.assignment.retailsite.repository.UserDiscountRepository;
import com.ajitabh.assignment.retailsite.utils.TestUtils;

@SpringBootApplication
public class RetailSiteApplication implements CommandLineRunner {

	@SuppressWarnings("unused")
	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;

	@SuppressWarnings("unused")
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;

	@SuppressWarnings("unused")
	@Autowired
	private AffiliateDetailsRepository affiliateDetailsRepository;

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private UserDiscountRepository userDiscountRepository;

	public static void main(String[] args) {

		SpringApplication.run(RetailSiteApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		saveUserandOrderData();
		Map<String, BigDecimal> mapofpayableamounts = calcNetAmountPayableAfterDisc();// Check net amount payable for
																						// Employee type
		System.out.println(mapofpayableamounts);
		
	}

	public void saveUserandOrderData() {
		CustomerDetails customerDetails1 = new CustomerDetails();
		customerDetails1.setFirstName("Ajitabh");
		customerDetails1.setLastName("Raj");
		customerDetails1.setAddress("Pune,Maharastra");
		customerDetails1.setBirthDate(new Date());
		customerDetails1.setCustomerType(TestUtils.USER_TYPE_CUST);
		customerDetails1.setMobileNumber(882643570L);
		customerDetails1.setStartDate(new Date());
		customerDetails1.setStatus("Y");

		CustomerDetails customerDetails2 = new CustomerDetails();
		customerDetails2.setFirstName("Anand Sharma");
		customerDetails2.setLastName("Raj");
		customerDetails2.setAddress("Pune,Maharastra");
		customerDetails2.setBirthDate(new Date());
		customerDetails2.setCustomerType(TestUtils.USER_TYPE_CUST);
		customerDetails2.setMobileNumber(882643570L);
		customerDetails2.setStartDate(new Date());
		customerDetails2.setStatus("Y");

		EmployeeDetails employeeDetails1 = new EmployeeDetails();
		employeeDetails1.setDesignation("Manager");
		employeeDetails1.setFirstname("Abhimanyu");
		employeeDetails1.setAddress("Pune,Maharastra");
		employeeDetails1.setJoiningDate(new Date());
		employeeDetails1.setLastname("Pandey");
		employeeDetails1.setMobileNumber(8826435704L);
		employeeDetails1.setSalary(10000);
		employeeDetails1.setStatus("Y");

		EmployeeDetails employeeDetails2 = new EmployeeDetails();
		employeeDetails2.setDesignation("Clerk");
		employeeDetails2.setFirstname("Abhimanyu");
		employeeDetails2.setAddress("Pune,Maharastra");
		employeeDetails2.setJoiningDate(new Date());
		employeeDetails2.setLastname("Singh");
		employeeDetails2.setMobileNumber(8826435704L);
		employeeDetails2.setSalary(15000);
		employeeDetails2.setStatus("Y");

		AffiliateDetails affiliateDetails1 = new AffiliateDetails();
		affiliateDetails1.setAffiliateType(TestUtils.USER_TYPE_AFFLT);
		affiliateDetails1.setAddress("Pune,maharastra");
		affiliateDetails1.setStartDate(new Date());
		affiliateDetails1.setFirstname("Rounak");
		affiliateDetails1.setStatus("Y");
		affiliateDetails1.setMobileNumber(8826435704L);
		affiliateDetails1.setLastname("Singh");

		AffiliateDetails affiliateDetails2 = new AffiliateDetails();
		affiliateDetails2.setAffiliateType(TestUtils.USER_TYPE_AFFLT);
		affiliateDetails2.setAddress("nashik,maharastra");
		affiliateDetails2.setStartDate(new Date());
		affiliateDetails2.setFirstname("Rounak");
		affiliateDetails2.setStatus("Y");
		affiliateDetails2.setMobileNumber(8826435704L);
		affiliateDetails2.setLastname("Raj");

		// Adding two customers,one Affiliate and one Employee
		UserDetails userDetails1 = new UserDetails();
		userDetails1.setCustomer(customerDetails1);
		userDetails1.setUserType(customerDetails1.getCustomerType());
		userDetailsRepository.save(userDetails1);

		UserDetails userDetails2 = new UserDetails();
		userDetails2.setCustomer(customerDetails2);
		userDetails2.setUserType(customerDetails2.getCustomerType());
		userDetailsRepository.save(userDetails2);

		UserDetails userDetails3 = new UserDetails();
		userDetails3.setAffiliate(affiliateDetails1);
		userDetails3.setUserType(affiliateDetails1.getAffiliateType());
		userDetailsRepository.save(userDetails3);

		UserDetails userDetails4 = new UserDetails();
		userDetails4.setEmployee(employeeDetails1);
		userDetails4.setUserType(TestUtils.USER_TYPE_EMP);
		userDetailsRepository.save(userDetails4);

		// Create four orders for 1st costumer
		OrderDetails orderDetails1 = new OrderDetails();
		orderDetails1.setUser(userDetails1);
		orderDetails1.setUnit("$");
		orderDetails1.setDescription("orderdetail1 desc-Fruits");
		orderDetails1.setQunatity(10);
		orderDetails1.setPrice(new BigDecimal(100));
		orderDetails1.setOrderType(TestUtils.ITEM_TYPE_OTHER);
		orderDetailsRepository.save(orderDetails1);

		OrderDetails orderDetails2 = new OrderDetails();
		orderDetails2.setUser(userDetails1);
		orderDetails2.setUnit("$");
		orderDetails2.setDescription("orderdetail1 desc-Grocery");
		orderDetails2.setQunatity(20);
		orderDetails2.setPrice(new BigDecimal(100));
		orderDetails2.setOrderType(TestUtils.ITEM_TYPE_GROCERY);
		orderDetailsRepository.save(orderDetails2);

		OrderDetails orderDetails3 = new OrderDetails();
		orderDetails3.setUser(userDetails1);
		orderDetails3.setUnit("$");
		orderDetails3.setDescription("orderdetail1 desc-Grocery");
		orderDetails3.setQunatity(30);
		orderDetails3.setPrice(new BigDecimal(100));
		orderDetails3.setOrderType(TestUtils.ITEM_TYPE_GROCERY);
		orderDetailsRepository.save(orderDetails3);

		OrderDetails orderDetails4 = new OrderDetails();
		orderDetails4.setUser(userDetails1);
		orderDetails4.setUnit("$");
		orderDetails4.setDescription("orderdetail1 desc-Vegetables");
		orderDetails4.setQunatity(50);
		orderDetails4.setPrice(new BigDecimal(100));
		orderDetails4.setOrderType(TestUtils.ITEM_TYPE_OTHER);
		orderDetailsRepository.save(orderDetails4);

		OrderDetails orderDetails5 = new OrderDetails();
		orderDetails5.setUser(userDetails3);
		orderDetails5.setUnit("$");
		orderDetails5.setDescription("orderdetail1 desc-Vegetables");
		orderDetails5.setQunatity(50);
		orderDetails5.setPrice(new BigDecimal(100));
		orderDetails5.setOrderType(TestUtils.ITEM_TYPE_GROCERY);
		orderDetailsRepository.save(orderDetails5);

		OrderDetails orderDetails6 = new OrderDetails();
		orderDetails6.setUser(userDetails3);
		orderDetails6.setUnit("$");
		orderDetails6.setDescription("orderdetail1 desc-Vegetables");
		orderDetails6.setQunatity(50);
		orderDetails6.setPrice(new BigDecimal(100));
		orderDetails6.setOrderType(TestUtils.ITEM_TYPE_OTHER);
		orderDetailsRepository.save(orderDetails6);

		OrderDetails orderDetails7 = new OrderDetails();
		orderDetails7.setUser(userDetails4);
		orderDetails7.setUnit("$");
		orderDetails7.setDescription("orderdetail1 desc-Vegetables");
		orderDetails7.setQunatity(50);
		orderDetails7.setPrice(new BigDecimal(100));
		orderDetails7.setOrderType(TestUtils.ITEM_TYPE_GROCERY);
		orderDetailsRepository.save(orderDetails7);

		OrderDetails orderDetails8 = new OrderDetails();
		orderDetails8.setUser(userDetails4);
		orderDetails8.setUnit("$");
		orderDetails8.setDescription("orderdetail1 desc-Vegetables");
		orderDetails8.setQunatity(50);
		orderDetails8.setPrice(new BigDecimal(100));
		orderDetails8.setOrderType(TestUtils.ITEM_TYPE_OTHER);
		orderDetailsRepository.save(orderDetails8);

		UserDiscount userDiscount1 = new UserDiscount();
		userDiscount1.setUserType(TestUtils.USER_TYPE_EMP);
		userDiscount1.setDiscountType("Employee Discount");
		userDiscount1.setDiscountAmount(new BigDecimal(30));
		userDiscount1.setStatus("Y");

		UserDiscount userDiscount2 = new UserDiscount();
		userDiscount2.setUserType(TestUtils.USER_TYPE_CUST);
		userDiscount2.setDiscountType("Customer Discount");
		userDiscount2.setDiscountAmount(new BigDecimal(5));
		userDiscount2.setStatus("Y");

		UserDiscount userDiscount3 = new UserDiscount();
		userDiscount3.setUserType(TestUtils.USER_TYPE_AFFLT);
		userDiscount3.setDiscountType("Affiliate Discount");
		userDiscount3.setDiscountAmount(new BigDecimal(10));
		userDiscount3.setStatus("Y");
		userDiscountRepository.save(userDiscount1);
		userDiscountRepository.save(userDiscount2);
		userDiscountRepository.save(userDiscount3);

		// Three types of discounts applied

	}

	public void saveorderData() {

	}

	public Map<String, BigDecimal> calcNetAmountPayableAfterDisc() {

		// Find Net amount to be paid for customer with customer discount if any

		Iterable<OrderDetails> orderDetails = orderDetailsRepository.findAll();
		List<OrderDetails> orderDetailsList = StreamSupport.stream(orderDetails.spliterator(), false)
				.collect(Collectors.toList());
		// System.out.println(orderdetails.get(0));
		List<OrderDetails> employeeOrders = orderDetailsList.stream()
				.filter(order -> order.getUser().getEmployee() != null).collect(Collectors.toList());
		List<OrderDetails> affiliateOrders = orderDetailsList.stream()
				.filter(order -> order.getUser().getAffiliate() != null).collect(Collectors.toList());
		List<OrderDetails> customerOrders = orderDetailsList.stream()
				.filter(order -> order.getUser().getCustomer() != null).collect(Collectors.toList());

		BigDecimal amountPayable;
		Map<String, BigDecimal> orderPriceCustomer = new HashMap<>();// Put all cumulative bills in a map based on
																		// grocery and others expenses
		Map<String, BigDecimal> orderPriceEmployee = new HashMap<>();
		Map<String, BigDecimal> orderPriceAffiliate = new HashMap<>();

		if (!employeeOrders.isEmpty()) {
			for (OrderDetails order : employeeOrders) {
				if (TestUtils.ITEM_TYPE_GROCERY.equalsIgnoreCase(order.getOrderType())) {
					orderPriceEmployee.put(TestUtils.ITEM_TYPE_GROCERY,
							orderPriceEmployee.get(TestUtils.ITEM_TYPE_GROCERY) == null
									? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))
									: orderPriceEmployee.get(TestUtils.ITEM_TYPE_GROCERY)
											.add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				} else {
					orderPriceEmployee.put(TestUtils.ITEM_TYPE_OTHER,
							orderPriceEmployee.get(TestUtils.ITEM_TYPE_OTHER) == null
									? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))
									: orderPriceEmployee.get(TestUtils.ITEM_TYPE_OTHER)
											.add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				}
			}
		}
		if (!affiliateOrders.isEmpty()) {
			for (OrderDetails order : affiliateOrders) {
				if (TestUtils.ITEM_TYPE_GROCERY.equalsIgnoreCase(order.getOrderType())) {
					orderPriceAffiliate.put(TestUtils.ITEM_TYPE_GROCERY,
							orderPriceAffiliate.get(TestUtils.ITEM_TYPE_GROCERY) == null
									? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))
									: orderPriceAffiliate.get(TestUtils.ITEM_TYPE_GROCERY)
											.add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				} else {
					orderPriceAffiliate.put(TestUtils.ITEM_TYPE_OTHER,
							orderPriceAffiliate.get(TestUtils.ITEM_TYPE_OTHER) == null
									? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))
									: orderPriceAffiliate.get(TestUtils.ITEM_TYPE_OTHER)
											.add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				}
			}
		}
		if (!customerOrders.isEmpty()) {
			for (OrderDetails order : customerOrders) {
				if (TestUtils.ITEM_TYPE_GROCERY.equalsIgnoreCase(order.getOrderType())) {
					orderPriceCustomer.put(TestUtils.ITEM_TYPE_GROCERY,
							orderPriceCustomer.get(TestUtils.ITEM_TYPE_GROCERY) == null
									? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))
									: orderPriceCustomer.get(TestUtils.ITEM_TYPE_GROCERY)
											.add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				} else {
					orderPriceCustomer.put(TestUtils.ITEM_TYPE_OTHER,
							orderPriceCustomer.get(TestUtils.ITEM_TYPE_OTHER) == null
									? order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))
									: orderPriceCustomer.get(TestUtils.ITEM_TYPE_OTHER)
											.add(order.getPrice().multiply(BigDecimal.valueOf(order.getQunatity()))));
				}
			}
		}

		// Calculate the amount excluding grocery type as all other percentage based
		// discounts are based on conditions
		System.out.println("amountPayable");
		Map<String, BigDecimal> billPayableMap = new HashMap<String, BigDecimal>();
		if (orderPriceCustomer != null) {
			BigDecimal amountExcludingGrocery = orderPriceCustomer.get(TestUtils.ITEM_TYPE_OTHER);
			BigDecimal amountIncludingGrocery = orderPriceCustomer.get(TestUtils.ITEM_TYPE_OTHER)
					.add(orderPriceCustomer.get(TestUtils.ITEM_TYPE_GROCERY));
			BigDecimal amountGrocery = orderPriceCustomer.get(TestUtils.ITEM_TYPE_GROCERY);

			System.out.println("amountExcludingGrocery" + amountExcludingGrocery);
			System.out.println("amountIncludingGrocery" + amountIncludingGrocery);
			System.out.println("amountGrocery" + amountGrocery);

			String userType = TestUtils.USER_TYPE_CUST;

			// Case statement for user type
			switch (userType) {
			case TestUtils.USER_TYPE_EMP:
				amountPayable = calcTotalDiscount(amountExcludingGrocery, amountIncludingGrocery,
						TestUtils.EMPLOYEE_DISCOUNT);
				break;
			case TestUtils.USER_TYPE_AFFLT:
				amountPayable = calcTotalDiscount(amountExcludingGrocery, amountIncludingGrocery,
						TestUtils.AFFILIATE_DISCOUNT);
				break;
			case TestUtils.USER_TYPE_CUST:

				amountPayable = calcTotalDiscount(amountExcludingGrocery, amountIncludingGrocery,
						TestUtils.CUSTOMER_OLDER_THAN_TWO_YEARS_DISCOUNT);
				break;
			default:
				amountPayable = calcDefaultAmountDiscount(amountIncludingGrocery);
			}
			billPayableMap.put("Net Amount Payable for " + employeeOrders.get(0).getUser().getId(), amountPayable);

		}

		if (orderPriceAffiliate != null) {
			BigDecimal amountExcludingGrocery = orderPriceAffiliate.get(TestUtils.ITEM_TYPE_OTHER);
			BigDecimal amountIncludingGrocery = orderPriceAffiliate.get(TestUtils.ITEM_TYPE_OTHER)
					.add(orderPriceAffiliate.get(TestUtils.ITEM_TYPE_GROCERY));
			BigDecimal amountGrocery = orderPriceAffiliate.get(TestUtils.ITEM_TYPE_GROCERY);

			System.out.println("amountExcludingGrocery" + amountExcludingGrocery);
			System.out.println("amountIncludingGrocery" + amountIncludingGrocery);
			System.out.println("amountGrocery" + amountGrocery);
			String userType = TestUtils.USER_TYPE_AFFLT;
			// Case statement for user type
			switch (userType) {
			case TestUtils.USER_TYPE_EMP:
				amountPayable = calcTotalDiscount(amountExcludingGrocery, amountIncludingGrocery,
						TestUtils.EMPLOYEE_DISCOUNT);
				break;
			case TestUtils.USER_TYPE_AFFLT:
				amountPayable = calcTotalDiscount(amountExcludingGrocery, amountIncludingGrocery,
						TestUtils.AFFILIATE_DISCOUNT);
				break;
			case TestUtils.USER_TYPE_CUST:

				amountPayable = calcTotalDiscount(amountExcludingGrocery, amountIncludingGrocery,
						TestUtils.CUSTOMER_OLDER_THAN_TWO_YEARS_DISCOUNT);
				break;
			default:
				amountPayable = calcDefaultAmountDiscount(amountIncludingGrocery);

			}
			billPayableMap.put("Net Amount Payable for " + affiliateOrders.get(0).getUser().getId(), amountPayable);

		}

		if (orderPriceEmployee != null) {

			BigDecimal amountExcludingGrocery = orderPriceEmployee.get(TestUtils.ITEM_TYPE_OTHER);
			BigDecimal amountIncludingGrocery = orderPriceEmployee.get(TestUtils.ITEM_TYPE_OTHER)
					.add(orderPriceEmployee.get(TestUtils.ITEM_TYPE_GROCERY));
			BigDecimal amountGrocery = orderPriceEmployee.get(TestUtils.ITEM_TYPE_GROCERY);

			System.out.println("amountExcludingGrocery" + amountExcludingGrocery);
			System.out.println("amountIncludingGrocery" + amountIncludingGrocery);
			System.out.println("amountGrocery" + amountGrocery);
			String userType = TestUtils.USER_TYPE_EMP;

			// Case statement for user type
			switch (userType) {
			case TestUtils.USER_TYPE_EMP:
				amountPayable = calcTotalDiscount(amountExcludingGrocery, amountIncludingGrocery,
						TestUtils.EMPLOYEE_DISCOUNT);
				break;
			case TestUtils.USER_TYPE_AFFLT:
				amountPayable = calcTotalDiscount(amountExcludingGrocery, amountIncludingGrocery,
						TestUtils.AFFILIATE_DISCOUNT);
				break;
			case TestUtils.USER_TYPE_CUST:

				amountPayable = calcTotalDiscount(amountExcludingGrocery, amountIncludingGrocery,
						TestUtils.CUSTOMER_OLDER_THAN_TWO_YEARS_DISCOUNT);
				break;
			default:
				amountPayable = calcDefaultAmountDiscount(amountIncludingGrocery);
			}
			billPayableMap.put("Net Amount Payable for " + customerOrders.get(0).getUser().getId(), amountPayable);

		}
		return billPayableMap;
	}

//This method calculates the default discount of 5$ per 100$ spent and returns net amount payable after this
	private static BigDecimal calcDefaultAmountDiscount(BigDecimal amount) {
		BigDecimal discount = BigDecimal.ZERO;
		if (amount.compareTo(BigDecimal.valueOf(100)) > 0 && amount != null) {
			discount = amount.divide(BigDecimal.valueOf(100)).setScale(0, RoundingMode.DOWN)
					.multiply(TestUtils.FLAT_DISCOUNT_FOR_HUNDRED_AMOUNT);
		}
		return amount.subtract(discount);
	}

//This method accepts total bill,grocery bill and type to recalculate if any % conditional discounts to be given on top of above default disc
	private static BigDecimal calcTotalDiscount(BigDecimal amount, BigDecimal totalAmountBill,
			BigDecimal discountPercentage) {
		BigDecimal discount = BigDecimal.ZERO;
		BigDecimal afterDefaultDiscount = BigDecimal.ZERO;
		afterDefaultDiscount = calcDefaultAmountDiscount(totalAmountBill);
		discount = discount.add(amount.multiply(discountPercentage).divide(BigDecimal.valueOf(100)));
		return afterDefaultDiscount.subtract(discount);
	}

}
