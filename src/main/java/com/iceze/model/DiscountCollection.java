package com.iceze.model;

import java.util.List;

public class DiscountCollection {
	private List<Discount> discounts;

	public DiscountCollection(List<Discount> discounts) {
		super();
		this.discounts = discounts;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}
}
