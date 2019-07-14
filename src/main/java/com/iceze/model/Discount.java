package com.iceze.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Discount {
	private final String type;
	private final BigDecimal amount;
	private final List<String> itemNamesOrTypes;
	
	public Discount() {
		this.type = null;
		this.amount = null;
		this.itemNamesOrTypes = null;
	}

	private Discount(final Builder builder) {
		this.type = builder.type;
		this.amount = builder.amount;
		this.itemNamesOrTypes = builder.itemNamesOrTypes;
	}

	public String getType() {
		return type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public List<String> getItemNamesOrTypes() {
		List<String> newItemNamesOrTypesList = itemNamesOrTypes.stream().collect(Collectors.toList());
		return Collections.unmodifiableList(newItemNamesOrTypesList);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String type;
		private BigDecimal amount;
		private List<String> itemNamesOrTypes;

		private Builder() {
		}

		public Builder type(final String type) {
			this.type = type;
			return this;
		}

		public Builder amount(final BigDecimal amount) {
			this.amount = amount;
			return this;
		}

		public Builder itemNamesOrTypes(final List<String> itemNamesOrTypes) {
			List<String> newItemNamesOrTypesList = itemNamesOrTypes.stream().collect(Collectors.toList());
			this.itemNamesOrTypes = Collections.unmodifiableList(newItemNamesOrTypesList);
			return this;
		}

		public Discount build() {
			return new Discount(this);
		}
	}
}
