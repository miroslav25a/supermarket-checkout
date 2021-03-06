package com.iceze.service;

import java.math.BigDecimal;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import com.iceze.model.Basket;
import com.iceze.model.Item;

import static org.assertj.core.api.Assertions.*;

public class TwoForPriceDeductionTest {
	private TwoForPriceDeduction twoForPriceDeduction;
	
	@Before
	public void setup() {
		this.twoForPriceDeduction = new TwoForPriceDeduction();
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

		Object deduction = this.twoForPriceDeduction.deduction(basket, new BigDecimal(1.0), "Apple");

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

		Object deduction = this.twoForPriceDeduction.deduction(basket, new BigDecimal(1.0), "Apple");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(1));
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

		Object deduction = this.twoForPriceDeduction.deduction(basket, new BigDecimal(1.0), "Apple");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(1));
	}
	
	@Test
	public void deductionReturnsForFiveItems() {
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
							.name("Orange")
							.price(new BigDecimal(2.0))
							.type("fruit")
							.build()))
				.build();

		Object deduction = this.twoForPriceDeduction.deduction(basket, new BigDecimal(1.0), "Apple");

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

		Object deduction = this.twoForPriceDeduction.deduction(basket, new BigDecimal(1.0), "Apple");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(0));
	}
}
