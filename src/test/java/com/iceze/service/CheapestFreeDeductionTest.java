package com.iceze.service;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import com.iceze.model.Basket;
import com.iceze.model.Item;

public class CheapestFreeDeductionTest {
	private CheapestFreeDeduction cheapestFreeDeduction;
	
	@Before
	public void setup() {
		this.cheapestFreeDeduction = new CheapestFreeDeduction();
	}
	
	@Test
	public void deductionReturnsForNoItems() {
		Basket basket = Basket.builder()
				.items(Lists.newArrayList(
						Item.builder()
								.name("Weetabix")
								.price(new BigDecimal(2.0))
								.type("cereal").build()))
				.build();
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");
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
								.name("Orange")
								.price(new BigDecimal(2.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Weetabix")
								.price(new BigDecimal(2.0))
								.type("cereal").build()))
				.build();
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");

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
								.type("fruit")
								.build(),
						Item.builder()
								.name("Orange")
								.price(new BigDecimal(2.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Banana")
								.price(new BigDecimal(3.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Weetabix")
								.price(new BigDecimal(2.0))
								.type("cereal").build()))
				.build();
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(1));
	}
	
	@Test
	public void deductionReturnsForFourItems() {
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
								.build(),
						Item.builder()
								.name("Banana")
								.price(new BigDecimal(3.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Orange")
								.price(new BigDecimal(2.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Weetabix")
								.price(new BigDecimal(2.0))
								.type("cereal")
								.build()))
				.build();
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");

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
								.name("Banana")
								.price(new BigDecimal(3.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Banana")
								.price(new BigDecimal(3.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Banana")
								.price(new BigDecimal(3.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Orange")
								.price(new BigDecimal(2.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Orange")
								.price(new BigDecimal(2.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Weetabix")
								.price(new BigDecimal(2.0))
								.type("cereal")
								.build()))
				.build();
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(3));
	}
	
	@Test
	public void deductionReturnsForSevenItems() {
		Basket basket = Basket.builder()
				.items(Lists.newArrayList(
						Item.builder()
								.name("Apple")
								.price(new BigDecimal(1.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Banana")
								.price(new BigDecimal(3.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Banana")
								.price(new BigDecimal(3.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Banana")
								.price(new BigDecimal(3.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Orange")
								.price(new BigDecimal(2.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Orange")
								.price(new BigDecimal(2.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Orange")
								.price(new BigDecimal(2.0))
								.type("fruit")
								.build(),
						Item.builder()
								.name("Weetabix")
								.price(new BigDecimal(2.0))
								.type("cereal")
								.build()))
				.build();
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");

		assertThat(deduction)
				.isNotNull()
				.isInstanceOf(BigDecimal.class)
				.isEqualTo(new BigDecimal(3));
	}
}
