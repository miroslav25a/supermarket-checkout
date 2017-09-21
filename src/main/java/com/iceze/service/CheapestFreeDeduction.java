package com.iceze.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;

import com.iceze.model.Basket;
import com.iceze.model.Item;
/**
 * This class implements the cheapest free discount functionality 
 * for 3 items of the same type.
 * 
 * @author Miroslav
 */
public class CheapestFreeDeduction implements Deduction {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal deduction(Basket basket, BigDecimal amount, String item) {
		List<Item> items = basket.getItems();
		BigDecimal totalDiscount = new BigDecimal(0);
		
		List<Item> discountItems = items.stream().filter(i -> i.getType().equals(item))
												 .sorted((i1, i2) -> {
													 	return i1.getPrice().compareTo(i2.getPrice());
												 	})
												 .collect(Collectors.toList());
		
		int numberOfItemsFree = discountItems.size() / 3;
		
		if(numberOfItemsFree > 0) {
			List<Item> freeItems = (numberOfItemsFree == 1) ? Lists.newArrayList(discountItems.get(0)) : 
															  discountItems.subList(0, numberOfItemsFree);
			totalDiscount = freeItems.stream().map(Item::getPrice)
											  .reduce(BigDecimal.ZERO, BigDecimal::add);
		}
		
		return totalDiscount;
	}
}
