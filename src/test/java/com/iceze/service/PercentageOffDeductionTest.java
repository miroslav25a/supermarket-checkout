package com.iceze.service;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import com.iceze.model.Basket;
import com.iceze.model.Item;

public class PercentageOffDeductionTest {
	private PercentageOffDeduction percentageOffDeduction;
	
	@Before
	public void setup()
	{
		this.percentageOffDeduction = new PercentageOffDeduction();
	}
	
	@Test
	public void deductionReturnsForOneItem() {
		Basket basket = Basket.builder()
				.items(Lists.newArrayList(
						Item.builder()
								.name("Apple")
								.price(new BigDecimal(1.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Orange")
								.price(new BigDecimal(2.0))
								.type("fruit")
								.build()))
				.build();
		
		Object deduction = this.percentageOffDeduction.deduction(basket, new BigDecimal(50), "Apple");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(0.5));
	}
	
	@Test
	public void deductionReturnsForNoItems() {
		Basket basket = Basket.builder()
				.items(Lists.newArrayList(
						Item.builder()
								.name("Orange")
								.price(new BigDecimal(2.0))
								.type("fruit")
								.build()))
				.build();
		
		Object deduction = this.percentageOffDeduction.deduction(basket, new BigDecimal(50), "Apple");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(0));
	}
	
	@Test
	public void deductionReturnsForTwoItems() {
		Basket basket = Basket.builder()
				.items(Lists.newArrayList(
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
								.price(new BigDecimal(2.0))
								.type("fruit")
								.build()))
				.build();
		
		Object deduction = this.percentageOffDeduction.deduction(basket, new BigDecimal(50), "Apple");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(10));
	}
}
