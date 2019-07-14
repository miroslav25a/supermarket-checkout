package com.iceze.model;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import com.iceze.service.Deduction;

/**
 * Class that contains info required to apply discounts.
 * 
 * @author Miroslav
 */
public final class DeductionCollection {
	private final Map<String, Deduction> deductions;
	private final DiscountCollection discountCollection;
	
	public DeductionCollection() {
		this.deductions = null;
		this.discountCollection = null;
	}

	private DeductionCollection(final Builder builder) {
		this.deductions = builder.deductions;
		this.discountCollection = builder.discountCollection;
	}

	public Map<String, Deduction> getDeductions() {
		Map<String, Deduction> newDeductionsMap = deductions.entrySet().stream()
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		return Collections.unmodifiableMap(newDeductionsMap);
	}

	public DiscountCollection getDiscountCollection() {
		return discountCollection;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Map<String, Deduction> deductions;
		private DiscountCollection discountCollection;

		private Builder() {
		}
		
		public Builder deductions(final Map<String, Deduction> deductions) {
			Map<String, Deduction> newDeductionsMap = deductions.entrySet().stream()
					.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
			this.deductions = Collections.unmodifiableMap(newDeductionsMap);
			return this;
		}
		
		public Builder discountCollection(final DiscountCollection discountCollection) {
			this.discountCollection = discountCollection;
			return this;
		}
		
		public DeductionCollection build() {
			return new DeductionCollection(this);
		}
	}
}
