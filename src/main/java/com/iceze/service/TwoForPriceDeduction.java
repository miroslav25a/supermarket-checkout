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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal deduction(Basket basket, BigDecimal amount, String item) {
		List<Item> items = basket.getItems();
		BigDecimal discount = new BigDecimal(0);
		
		List<Item> discountItems = items.stream().filter(i -> i.getName().equals(item)).collect(Collectors.toList());
		
		if(discountItems.size() % 2 != 0) {
			discountItems.remove(0);
		} 
		
		BigDecimal totalPrice = discountItems.stream().map(Item::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
		BigDecimal totalDiscountPrice = amount.multiply(new BigDecimal(discountItems.size() / 2));
		discount = totalPrice.subtract(totalDiscountPrice);
		
		return discount;
	}
}
