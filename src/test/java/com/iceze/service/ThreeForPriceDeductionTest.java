package com.iceze.service;

import com.google.common.collect.Lists;
import com.iceze.model.Basket;
import com.iceze.model.Item;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeForPriceDeductionTest {
	private ThreeForPriceDeduction threeForPriceDeduction;
	
	@Before
	public void setup() {
		this.threeForPriceDeduction = new ThreeForPriceDeduction();
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

		Object deduction = this.threeForPriceDeduction.deduction(basket, new BigDecimal(2.0), "Apple");

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
							.price(new BigDecimal(1.0))
							.type("fruit")
							.build(),
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

		Object deduction = this.threeForPriceDeduction.deduction(basket, new BigDecimal(2.0), "Apple");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(0));
	}
	
	@Test
	public void deductionReturnsForThreeItems() {
		Basket basket = Basket.builder()
				.items(Lists.newArrayList(
					Item.builder()
							.name("Apple")
							.price(new BigDecimal(1.0))
							.type("fruit").build(),
					Item.builder()
							.name("Apple")
							.price(new BigDecimal(1.0))
							.type("fruit")
							.build(),
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

		Object deduction = this.threeForPriceDeduction.deduction(basket, new BigDecimal(2.0), "Apple");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(1));
	}
	
	@Test
	public void deductionReturnsForSixItems() {
		Basket basket = Basket.builder()
				.items(Lists.newArrayList(
					Item.builder()
							.name("Apple")
							.price(new BigDecimal(1.0))
							.type("fruit")
							.build(),
					Item.builder()
							.name("Apple")
							.price(new BigDecimal(1.0))
							.type("fruit")
							.build(),
					Item.builder()
							.name("Apple")
							.price(new BigDecimal(1.0))
							.type("fruit")
							.build(),
					Item.builder()
							.name("Apple")
							.price(new BigDecimal(1.0))
							.type("fruit")
							.build(),
					Item.builder()
							.name("Apple")
							.price(new BigDecimal(1.0))
							.type("fruit")
							.build(),
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

		Object deduction = this.threeForPriceDeduction.deduction(basket, new BigDecimal(2.0), "Apple");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(2));
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

		Object deduction = this.threeForPriceDeduction.deduction(basket, new BigDecimal(2.0), "Apple");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(0));
	}
}
