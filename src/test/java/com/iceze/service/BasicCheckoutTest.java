package com.iceze.service;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.junit.Before;
import org.junit.Test;

import com.iceze.model.Basket;
import com.iceze.model.DeductionCollection;
import com.iceze.model.Discount;
import com.iceze.model.DiscountCollection;
import com.iceze.model.DiscountType;
import com.iceze.model.Item;
import com.iceze.model.DeductionCollection.DeductionCollectionBuilder;
import com.iceze.service.BasicCheckout;
import com.iceze.service.CheapestFreeDeduction;
import com.iceze.service.Deduction;
import com.iceze.service.PercentageOffDeduction;
import com.iceze.service.TwoForPriceDeduction;

public class BasicCheckoutTest {
	private BasicCheckout basicCheckout;

	@Before
	public void setup() {
		this.basicCheckout = new BasicCheckout();
	}
	
	@Test
	public void checkoutReturns() {
		Basket basket = this.createBasket();
		DeductionCollection deductionCollection = this.createDeductionCollection();
		
		Object checkout = this.basicCheckout.checkout(basket, deductionCollection);
		System.out.println(checkout);
		assertThat(checkout, is(
				allOf(notNullValue(), instanceOf(String.class), equalTo("Apple: £10\n"
																	  + "Apple: £10\n"
																	  + "Orange: £2\n"
																	  + "total price before discounts: £22\n"
																	  + "PERCENTAGE_OFF Apple: £10\n"
																	  + "total price after discounts: £12\n"))));
	}
	
	private Basket createBasket() {
		Basket basket = new Basket(Lists.newArrayList(
				new Item("Apple", new BigDecimal(10.0), "fruit"), 
				new Item("Apple", new BigDecimal(10.0), "fruit"), 
				new Item("Orange", new BigDecimal(2.0), "fruit")));
		
		return basket;
	}
	
	private DeductionCollection createDeductionCollection() {
		Map<String, Deduction> deductions = Maps.newHashMap(
				DiscountType.CHEAPEST_FREE.name(), new CheapestFreeDeduction());

		deductions.put(DiscountType.PERCENTAGE_OFF.name(), new PercentageOffDeduction());
		deductions.put(DiscountType.TWO_FOR_PRICE.name(), new TwoForPriceDeduction());
		
		List<Discount> discounts = Lists.newArrayList(new Discount(DiscountType.PERCENTAGE_OFF.name(), 
																   new BigDecimal(50), 
																   (List<String>) Lists.newArrayList("Apple")));
		DiscountCollection discountCollection = new DiscountCollection(discounts);
		
		DeductionCollection deductionCollection = new DeductionCollectionBuilder().withDeductions(deductions)
																				  .withDiscountCollection(discountCollection)
																				  .build();
		
		return deductionCollection;
	}
}
