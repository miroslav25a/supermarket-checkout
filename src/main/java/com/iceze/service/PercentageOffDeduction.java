package com.iceze.service;

import java.math.BigDecimal;
import java.util.List;

import com.iceze.model.Basket;
import com.iceze.model.Item;

/**
 * This Class contains the functionality for the percentage off discount
 * 
 * @author Miroslav
 */
public class PercentageOffDeduction implements Deduction {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal deduction(final Basket basket, final BigDecimal amount, final String item) {
		List<Item> items = basket.getItems();
		
		BigDecimal amountForDiscount = items.stream().filter(i -> i.getName().equals(item))
													 .map(Item::getPrice)
													 .reduce(BigDecimal.ZERO, BigDecimal::add);
															
		BigDecimal totalDiscount = amountForDiscount.multiply(amount).divide(new BigDecimal(100));
		
		return totalDiscount;
	}
}
