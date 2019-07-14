package com.iceze.service;

import com.iceze.model.Basket;
import com.iceze.model.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class contains functionality to calculate discount for 3 identical items for a fixed price.
 * 
 * @author Miroslav
 */
public class ThreeForPriceDeduction extends TwoForPriceDeduction {

	public ThreeForPriceDeduction() {
		super(3);
	}
}
