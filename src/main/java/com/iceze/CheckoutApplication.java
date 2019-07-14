package com.iceze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.iceze.model.Basket;
import com.iceze.model.DeductionCollection;
import com.iceze.model.DiscountCollection;
import com.iceze.model.DiscountType;
import com.iceze.service.*;

/**
 * Main application class
 * 
 * @author Miroslav
 */
public class CheckoutApplication {
	
	/**
	 * main method for running the Checkout application
	 * 
	 * @param args
	 * 			String[], represents arguments
	 * 
	 * @throws IOException
	 */
    public static void main(String[] args) throws IOException {
        if(args.length < 2) {
            throw new RuntimeException("No paths to the input basket and/or discounts was provided.");
        }

        String basketFilePath = args[0];
        String discountFilePath = args[1];
        
        //load shopping basket from a file
        Basket basket = loadBasket(basketFilePath);
        //get deductions and discounts
        DeductionCollection deductionCollection = getDeductionCollection(discountFilePath);
        
        // perform a checkout
        Checkout basicCheckout = new BasicCheckout();
        String output = basicCheckout.checkout(basket, deductionCollection);
        
        System.out.print(output);
    }
    
    /**
     * Load a shopping basket from the given file path.
     * 
     * @param filePath
     * 			String, representing file path
     * @return Basket
     * 			Shopping basket
     * @throws IOException
     */
    private static Basket loadBasket(final String filePath) throws IOException {
    	String json = new String(Files.readAllBytes(Paths.get(filePath)));
        Gson gson = new Gson();
        Basket basket = gson.fromJson(json, Basket.class);
        
        return basket;
    }
    
    /**
     * Load shopping discounts from the given file path.
     * 
     * @param filePath
     * 			String, representing file path
     * @return DiscountCollection
     * 				Shopping discounts
     * @throws IOException
     */
    private static DiscountCollection loadDiscountCollection(final String filePath) throws IOException {
    	String json = new String(Files.readAllBytes(Paths.get(filePath)));
        Gson gson = new Gson();
        DiscountCollection discountCollection = gson.fromJson(json, DiscountCollection.class);
        
        return discountCollection;
    }
    
    /**
     * Get a discounts and deductions can apply on a shopping basket at a checkout.
     * 
     * @param discountFilePath
     * 			String, representing discount file path
     * 
     * @return DeductionCollection
     * @throws IOException
     */
    private static DeductionCollection getDeductionCollection(final String discountFilePath) throws IOException {
    	Map<String, Deduction> deductions = initDeductions();
    	DiscountCollection discountCollection = loadDiscountCollection(discountFilePath);
    	
    	DeductionCollection deductionCollection = DeductionCollection.builder()
                .deductions(deductions)
                .discountCollection(discountCollection)
                .build();
    	
    	return deductionCollection;
    }
    
    /**
	 * This method creates a map with deductions
	 * 
	 * @return HashMap<String, Deduction>
	 */
	private static Map<String, Deduction> initDeductions() {
		Map<String, Deduction> deductions = Maps.newHashMap();
		deductions.put(DiscountType.CHEAPEST_FREE.name(), new CheapestFreeDeduction());
		deductions.put(DiscountType.PERCENTAGE_OFF.name(), new PercentageOffDeduction());
		deductions.put(DiscountType.TWO_FOR_PRICE.name(), new TwoForPriceDeduction());
		deductions.put(DiscountType.THREE_FOR_PRICE.name(), new ThreeForPriceDeduction());
		
		return deductions;
	}
}
