package com.iceze.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class DiscountCollection {
	private final List<Discount> discounts;

	public DiscountCollection() {
		this.discounts = null;
	}

	private DiscountCollection(final Builder builder) {
		this.discounts = builder.discounts;
	}

	public List<Discount> getDiscounts() {
		List<Discount> newDiscountList = discounts.stream().map(i -> Discount.builder()
						.amount(i.getAmount())
						.itemNamesOrTypes(i.getItemNamesOrTypes())
						.type(i.getType())
						.build()).collect(Collectors.toList());
		return Collections.unmodifiableList(newDiscountList);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private List<Discount> discounts;

		private Builder() {
		}

		public Builder discounts(final List<Discount> discounts) {
			List<Discount> newDiscountList = discounts.stream().map(d -> Discount.builder()
					.type(d.getType())
					.itemNamesOrTypes(d.getItemNamesOrTypes())
					.amount(d.getAmount())
					.build()).collect(Collectors.toList());
			this.discounts = Collections.unmodifiableList(newDiscountList);
			return this;
		}

		public DiscountCollection build() {
			return new DiscountCollection(this);
		}
	}
}
