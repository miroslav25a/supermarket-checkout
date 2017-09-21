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
import com.iceze.service.PercentageOffDeduction;

public class PercentageOffDeductionTest {
	private PercentageOffDeduction percentageOffDeduction;
	
	@Before
	public void setup()
	{
		this.percentageOffDeduction = new PercentageOffDeduction();
	}
	
	@Test
	public void deductionReturnsForOneItem() {
		Basket basket = new Basket(Lists.newArrayList(
									new Item("Apple", new BigDecimal(1.0), "fruit"), 
									new Item("Orange", new BigDecimal(2.0), "fruit")));
		
		Object deduction = this.percentageOffDeduction.deduction(basket, new BigDecimal(50), "Apple");
		assertThat(deduction, is(
				allOf(notNullValue(), instanceOf(BigDecimal.class), equalTo(new BigDecimal(0.5)))));
	}
	
	@Test
	public void deductionReturnsForNoItems() {
		Basket basket = new Basket(Lists.newArrayList( 
									new Item("Orange", new BigDecimal(2.0), "fruit")));
		
		Object deduction = this.percentageOffDeduction.deduction(basket, new BigDecimal(50), "Apple");
		assertThat(deduction, is(
				allOf(notNullValue(), instanceOf(BigDecimal.class), equalTo(new BigDecimal(0)))));
	}
	
	@Test
	public void deductionReturnsForTwoItems() {
		Basket basket = new Basket(Lists.newArrayList(
									new Item("Apple", new BigDecimal(10.0), "fruit"), 
									new Item("Apple", new BigDecimal(10.0), "fruit"), 
									new Item("Orange", new BigDecimal(2.0), "fruit")));
		
		Object deduction = this.percentageOffDeduction.deduction(basket, new BigDecimal(50), "Apple");
		assertThat(deduction, is(
				allOf(notNullValue(), instanceOf(BigDecimal.class), equalTo(new BigDecimal(10)))));
	}
}
