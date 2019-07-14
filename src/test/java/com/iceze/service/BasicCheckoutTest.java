package com.iceze.service;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import com.iceze.model.Basket;
import com.iceze.model.DeductionCollection;
import com.iceze.model.Discount;
import com.iceze.model.DiscountCollection;
import com.iceze.model.DiscountType;
import com.iceze.model.Item;

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

		assertThat(checkout).isNotNull().isInstanceOf(String.class).isEqualTo("Apple: £10\n"
				+ "Apple: £10\n"
				+ "Orange: £2\n"
				+ "total price before discounts: £22\n"
				+ "PERCENTAGE_OFF Apple: £10\n"
				+ "total price after discounts: £12\n");
	}
	
	private Basket createBasket() {
		Basket basket = Basket.builder().items(Lists.newArrayList(
				Item.builder()
						.name("Apple")
						.price(new BigDecimal(10.0))
						.type("fruit")
						.build(),
				Item.builder()
						.name("Apple")
						.price(new BigDecimal(10.0))
						.type("fruit")
						.build(),
				Item.builder()
						.name("Orange")
						.price(new BigDecimal(2.0)).type("fruit")
						.build()))
				.build();
		
		return basket;
	}
	
	private DeductionCollection createDeductionCollection() {
		Map<String, Deduction> deductions = Maps.newHashMap();
		deductions.put(DiscountType.CHEAPEST_FREE.name(), new CheapestFreeDeduction());

		deductions.put(DiscountType.PERCENTAGE_OFF.name(), new PercentageOffDeduction());
		deductions.put(DiscountType.TWO_FOR_PRICE.name(), new TwoForPriceDeduction());
		
		List<Discount> discounts = Lists.newArrayList(
				Discount.builder()
						.type(DiscountType.PERCENTAGE_OFF.name())
						.amount(new BigDecimal(50))
						.itemNamesOrTypes(Lists.newArrayList("Apple"))
						.build());

		DiscountCollection discountCollection = DiscountCollection.builder()
				.discounts(discounts)
				.build();
		
		DeductionCollection deductionCollection = DeductionCollection.builder()
				.deductions(deductions)
				.discountCollection(discountCollection)
				.build();
		
		return deductionCollection;
	}
}
