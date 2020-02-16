package com.ajitabh.assignment.retailsite;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ajitabh.assignment.retailsite.entity.Bill;
import com.ajitabh.assignment.retailsite.entity.BillBuilder;
import com.ajitabh.assignment.retailsite.entity.RetailSiteBill;
import com.ajitabh.assignment.retailsite.entity.ShoppingCategory;
import com.ajitabh.assignment.retailsite.entity.ShoppingItem;
import com.ajitabh.assignment.retailsite.entity.UserBuilder;
import com.ajitabh.assignment.retailsite.entity.UserType;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RetailSiteApplicationTests {

	@Mock
	Bill userBill;

	@Autowired
	UserBuilder userBilder;

	@Autowired
	BillBuilder billBilder;

	@Mock
	List<ShoppingItem> shoopingItemList;

	@InjectMocks
	RetailSiteBill retailSite;

	@Before
	public void before() {
		System.out.println("Before");

		shoopingItemList = new ArrayList<ShoppingItem>();

		ShoppingItem item = new ShoppingItem();
		item.setItemName("Cat Food");
		item.setItemCost(300.50);
		item.setCount(1);
		item.setCategory(ShoppingCategory.NONVEG);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("Jeans");
		item.setItemCost(100.00);
		item.setCount(1);
		item.setCategory(ShoppingCategory.CLOTHS);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("Frutes VEG");
		item.setItemCost(50.00);
		item.setCount(1);
		item.setCategory(ShoppingCategory.GROCERIES);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("TILD RICE 10KG");
		item.setItemCost(250.00);
		item.setCount(1);
		item.setCategory(ShoppingCategory.GROCERIES);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("Tomoto 1KG");
		item.setItemCost(20.00);
		item.setCount(1);
		item.setCategory(ShoppingCategory.GROCERIES);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("Iphone 6 plus");
		item.setItemCost(1200.999);
		item.setCount(1);
		item.setCategory(ShoppingCategory.ELECTRONICS);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("steck of wood");
		item.setItemCost(0.5);
		item.setCount(1);
		item.setCategory(ShoppingCategory.OTHER);
		shoopingItemList.add(item);

		item = new ShoppingItem();
		item.setItemName("Matt for BMW");
		item.setItemCost(30.5);
		item.setCount(1);
		item.setCategory(ShoppingCategory.BIKE_ACCESSORIES);
		shoopingItemList.add(item);

		userBill = billBilder.totalBill(0.0).shoopingItemList(shoopingItemList).totalBillAfterUserTypeDiscount(0.0)
				.finalbillCost(0.0).Build();

	}

	@Test
	public void contextLoads() {
		System.out.println("---------- Context Loaded ----------");

	}

	@Test
	public void main() {
		RetailSiteApplication.main(new String[] {});
	}

	@Test
	// 30 % Discount
	public void testEmployeeSegmentDicount() {

		retailSite.collectUserInfo(userBilder.firstName("Singh").lastName("Ajitabh").contactNo("91 8826435704")
				.userType(UserType.EMOLOYEE).build());

		final Double billCost = retailSite.collectPurchasedItems(shoopingItemList);

		final Double billCostAfterDiscount = retailSite.userTypeDiscountApply(billCost);

		final Double deductionAmount = (billCost - retailSite.getGroceriedItemCost(shoopingItemList));

		assertEquals(new Double(billCost - new Double((deductionAmount * 30) / 100)), billCostAfterDiscount);
	}

	@Test
	// 20 % Discount
	public void testAffelinateSegmentDicount() {
		retailSite.collectUserInfo(userBilder.firstName("Singh").lastName("Ajitabh").contactNo("91 8826435704")
				.userType(UserType.AFFILIATE).build());

		final Double billCost = retailSite.collectPurchasedItems(shoopingItemList);

		final Double billCostAfterDiscount = retailSite.userTypeDiscountApply(billCost);

		final Double deductionAmount = (billCost - retailSite.getGroceriedItemCost(shoopingItemList));

		assertEquals(new Double(billCost - new Double((deductionAmount * 10) / 100)), billCostAfterDiscount);
	}

	@Test
	// 10% Discount
	public void testOldCustomerSegmentDicount() {
		retailSite.collectUserInfo(userBilder.firstName("Singh").lastName("Ajitabh").contactNo("91 8826435704")
				.userType(UserType.OLD_CUSTOMER).build());

		final Double billCost = retailSite.collectPurchasedItems(shoopingItemList);

		final Double billCostAfterDiscount = retailSite.userTypeDiscountApply(billCost);

		final Double deductionAmount = (billCost - retailSite.getGroceriedItemCost(shoopingItemList));

		assertEquals(new Double(billCost - new Double((deductionAmount * 5) / 100)), billCostAfterDiscount);
	}

	@Test
	public void testCollectPurchasedItems() {

		final Double billCost = retailSite.collectPurchasedItems(shoopingItemList);
		assertEquals(new Double(1952.499), billCost);
	}

	@Test
	public void testFinalDicount() {

		retailSite.collectUserInfo(userBilder.firstName("Singh").lastName("Ajitabh").contactNo("91 8826435704")
				.userType(UserType.OLD_CUSTOMER).build());

		final Double billCost = retailSite.collectPurchasedItems(shoopingItemList);

		final Double billCostAfterDiscount = retailSite.userTypeDiscountApply(billCost);
		final Double billCostAfterFinalDiscount = retailSite.totalBillDiscountApply(billCostAfterDiscount);

		final Double expectedValue = billCostAfterDiscount - (Math.floor(Math.floor(billCostAfterDiscount) / 100) * 5);

		assertEquals(expectedValue, billCostAfterFinalDiscount);

	}

	@Test
	public void testOLD_CustomerUserType() {
		assertEquals(UserType.OLD_CUSTOMER, UserType.valueOf("OLD_CUSTOMER"));
	}
	
	public void testCustomerTypesValues() {
		assertEquals(3, UserType.values().length);
	}
	
	@Test
	public void testShoppingItemCategory() {
		assertEquals(ShoppingCategory.GROCERIES, ShoppingCategory.valueOf("GROCERIES"));
	}
	
	public void testShopingCategoryValues() {
		assertEquals(6, ShoppingCategory.values().length);
	}

	

}
