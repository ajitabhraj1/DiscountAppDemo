package com.ajitabh.assignment.retailsite.entity;

/**
 * @author AjitabhRaj
 *
 */
public class ShoppingItem {

	private String itemName;
	private Double itemCost;
	private int count;
	private ShoppingCategory category;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemCost() {
		return itemCost;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ShoppingCategory getCategory() {
		return category;
	}

	public void setCategory(ShoppingCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "[itemName=" + getItemName() + ", itemCost=" + getItemCost() + ", count=" + getCount() + ", category="
				+ getCategory() + "]";
	}

}
