package com.ajitabh.assignment.retailsite.entity;

import java.util.List;


/**
 * @author Ajitabh Raj
 *
 */
public interface BillOperations {

	public void collectUserInfo(User user);

	public Double getGroceriedItemCost(List<ShoppingItem> shoopingItemList);

	public Double collectPurchasedItems(List<ShoppingItem> shoopingItemList);

	public Double userTypeDiscountApply(Double cost);

	public Double totalBillDiscountApply(Double cost);
	
	public String printBillDetails(Bill bill);

}
