package com.iceze.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.iceze.model.Basket;
import com.iceze.model.Item;

/**
 * The class contains functionality to calculate discount for 2 identical items for a fixed price.
 * 
 * @author Miroslav
 */
public class TwoForPriceDeduction implements Deduction {
	protected final int numberOfItems;

	public TwoForPriceDeduction() {
		this.numberOfItems = 2;
	}

	public TwoForPriceDeduction(final int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal deduction(final Basket basket, final BigDecimal amount, final String item) {
		List<Item> items = basket.getItems();
		
		List<Item> discountItems = items.stream().filter(i -> i.getName().equals(item)).collect(Collectors.toList());

		if(discountItems.size() < numberOfItems) {
			return new BigDecimal(0);
		}

		if(discountItems.size() % numberOfItems != 0) {
			discountItems.remove(0);
		} 
		
		BigDecimal totalPrice = discountItems.stream().map(Item::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
		BigDecimal totalDiscountPrice = amount.multiply(new BigDecimal(discountItems.size() / numberOfItems));
		BigDecimal discount = totalPrice.subtract(totalDiscountPrice);
		
		return discount;
	}
}
