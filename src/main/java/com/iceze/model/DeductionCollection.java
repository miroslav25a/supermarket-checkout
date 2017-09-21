package com.iceze.model;

import java.util.Map;

import com.iceze.service.Deduction;

/**
 * Class that contains info required to apply discounts.
 * 
 * @author Miroslav
 */
public class DeductionCollection {
	private Map<String, Deduction> deductions;
	private DiscountCollection discountCollection;
	
	public DeductionCollection() {
		super();
		this.deductions = null;
		this.discountCollection = null;
	}

	private DeductionCollection(final Map<String, Deduction> deductions, final DiscountCollection discountCollection) {
		super();
		this.deductions = deductions;
		this.discountCollection = discountCollection;
	}

	public Map<String, Deduction> getDeductions() {
		return deductions;
	}

	public DiscountCollection getDiscountCollection() {
		return discountCollection;
	}
	
	/**
	 * Builder class for DeductionCollection
	 * 
	 * @author Miroslav
	 */
	public static class DeductionCollectionBuilder {
		private Map<String, Deduction> deductions;
		private DiscountCollection discountCollection;
		
		public DeductionCollectionBuilder withDeductions(final Map<String, Deduction> deductions) {
			this.deductions = deductions;
			return this;
		}
		
		public DeductionCollectionBuilder withDiscountCollection(final DiscountCollection discountCollection) {
			this.discountCollection = discountCollection;
			return this;
		}
		
		public DeductionCollection build() {
			return new DeductionCollection(this.deductions, this.discountCollection);
		}
	}
}
