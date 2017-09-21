package com.iceze.service;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import com.iceze.model.Basket;
import com.iceze.model.Item;
import com.iceze.service.CheapestFreeDeduction;

public class CheapestFreeDeductionTest {
	private CheapestFreeDeduction cheapestFreeDeduction;
	
	@Before
	public void setup() {
		this.cheapestFreeDeduction = new CheapestFreeDeduction();
	}
	
	@Test
	public void deductionReturnsForNoItems() {
		Basket basket = new Basket(Lists.newArrayList(
									new Item("Weetabix", new BigDecimal(2.0), "cereal")));
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");
		assertThat(deduction, is(
				allOf(notNullValue(), instanceOf(BigDecimal.class), equalTo(new BigDecimal(0)))));
	}
	
	@Test
	public void deductionReturnsForTwoItems() {
		Basket basket = new Basket(Lists.newArrayList(
									new Item("Apple", new BigDecimal(1.0), "fruit"),
									new Item("Orange", new BigDecimal(2.0), "fruit"),
									new Item("Weetabix", new BigDecimal(2.0), "cereal")));
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");
		assertThat(deduction, is(
				allOf(notNullValue(), instanceOf(BigDecimal.class), equalTo(new BigDecimal(0)))));
	}
	
	@Test
	public void deductionReturnsForThreeItems() {
		Basket basket = new Basket(Lists.newArrayList(
									new Item("Apple", new BigDecimal(1.0), "fruit"),
									new Item("Orange", new BigDecimal(2.0), "fruit"),
									new Item("Banana", new BigDecimal(3.0), "fruit"),
									new Item("Weetabix", new BigDecimal(2.0), "cereal")));
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");
		assertThat(deduction, is(
				allOf(notNullValue(), instanceOf(BigDecimal.class), equalTo(new BigDecimal(1)))));
	}
	
	@Test
	public void deductionReturnsForFourItems() {
		Basket basket = new Basket(Lists.newArrayList(
									new Item("Apple", new BigDecimal(1.0), "fruit"),
									new Item("Orange", new BigDecimal(2.0), "fruit"),
									new Item("Banana", new BigDecimal(3.0), "fruit"),
									new Item("Orange", new BigDecimal(2.0), "fruit"),
									new Item("Weetabix", new BigDecimal(2.0), "cereal")));
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");
		assertThat(deduction, is(
				allOf(notNullValue(), instanceOf(BigDecimal.class), equalTo(new BigDecimal(1)))));
	}
	
	@Test
	public void deductionReturnsForSixItems() {
		Basket basket = new Basket(Lists.newArrayList(
									new Item("Apple", new BigDecimal(1.0), "fruit"),
									new Item("Banana", new BigDecimal(3.0), "fruit"),
									new Item("Banana", new BigDecimal(3.0), "fruit"),
									new Item("Banana", new BigDecimal(3.0), "fruit"),
									new Item("Orange", new BigDecimal(2.0), "fruit"),
									new Item("Orange", new BigDecimal(2.0), "fruit"),
									new Item("Weetabix", new BigDecimal(2.0), "cereal")));
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");
		assertThat(deduction, is(
				allOf(notNullValue(), instanceOf(BigDecimal.class), equalTo(new BigDecimal(3)))));
	}
	
	@Test
	public void deductionReturnsForSevenItems() {
		Basket basket = new Basket(Lists.newArrayList(
									new Item("Apple", new BigDecimal(1.0), "fruit"),
									new Item("Banana", new BigDecimal(3.0), "fruit"),
									new Item("Banana", new BigDecimal(3.0), "fruit"),
									new Item("Banana", new BigDecimal(3.0), "fruit"),
									new Item("Orange", new BigDecimal(2.0), "fruit"),
									new Item("Orange", new BigDecimal(2.0), "fruit"),
									new Item("Orange", new BigDecimal(2.0), "fruit"),
									new Item("Weetabix", new BigDecimal(2.0), "cereal")));
		
		Object deduction = this.cheapestFreeDeduction.deduction(basket, new BigDecimal(0), "fruit");
		assertThat(deduction, is(
				allOf(notNullValue(), instanceOf(BigDecimal.class), equalTo(new BigDecimal(3)))));
	}
}
