package com.iceze.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.iceze.model.Basket;
import com.iceze.model.DeductionCollection;
import com.iceze.model.Discount;
import com.iceze.model.Item;

/**
 * The class that contains functionality for a basic shopping basket checkout.
 * 
 * @author Miroslav
 */
public class BasicCheckout implements Checkout {
	
	/**
	 * {@inheritDoc}
	 */
    @Override
    public String checkout(final Basket basket, final DeductionCollection deductionCollection) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Item> items = basket.getItems();
        
        items.forEach(item -> stringBuilder
                .append(item.getName())
                .append(": £")
                .append(item.getPrice())
                .append("\n"));

        //total sum before discounts
        BigDecimal sum = items.stream().map(Item::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        stringBuilder.append("total price before discounts: £").append(sum).append("\n");
        
        List<Discount> discounts = deductionCollection.getDiscountCollection().getDiscounts();
        Map<String, Deduction> deductions = deductionCollection.getDeductions();
        
        List<BigDecimal> discountSums = Lists.newArrayList();
        
        discounts.forEach((d) -> {
        	final BigDecimal itemDiscountSum = deductions.get(d.getType()).deduction(basket, d.getAmount(), d.getItemNamesOrTypes().get(0));
        	stringBuilder.append(d.getType() + " " + d.getItemNamesOrTypes().get(0))
        				 .append(": £")
        				 .append(itemDiscountSum)
        				 .append("\n");
        	discountSums.add(itemDiscountSum);
        });
        
        //total sum of discoutns 
        BigDecimal totalDiscointSum = discountSums.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        
        //total sum after discounts
        BigDecimal totalSum = sum.subtract(totalDiscointSum);
        stringBuilder.append("total price after discounts: £")
        			 .append(totalSum)
        			 .append("\n");

        String output = stringBuilder.toString();

        return output;
    }
}
