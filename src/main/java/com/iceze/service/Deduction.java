package com.iceze.service;

import java.math.BigDecimal;

import com.iceze.model.Basket;

/**
 * This interface contains the common functionality for applying discounts
 * 
 * @author Miroslav
 */
public interface Deduction {
	
	/**
	 * Discount the given amount for the given item in the basket
	 * 
	 * @param basket 
	 * 			Basket, represents shopping basket with items
	 * @param amount
	 * 			BigDecimal, represents amount to discount
	 * @param item
	 * 			String, represents item on which perform the discount
	 * @return
	 * 			BigDecimal, total discount amount
	 */
	BigDecimal deduction(final Basket basket, final BigDecimal amount, final String item);
}
