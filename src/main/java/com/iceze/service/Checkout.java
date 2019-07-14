package com.iceze.service;

import com.iceze.model.Basket;
import com.iceze.model.DeductionCollection;

/**
 * The interface that contains common functionality for a shopping basket checkout.
 * 
 * @author Miroslav
 */
public interface Checkout {
	
	/**
	 * Process checkout for the given basket and apply discounts with the given deduction collection
	 * 
	 * @param basket
	 * 				Basket, represents a shopping basket
	 * @param deductionCollection
	 * 				DeductionCollection, represents discounts to apply
	 * 
	 * @return String
	 * 				checkout result
	 */
    String checkout(Basket basket, DeductionCollection deductionCollection);
}
