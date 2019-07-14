package com.iceze.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Basket {
	private final List<Item> items;

	public Basket() {
		this.items = null;
	}

	private Basket(final Builder builder) {
		this.items = builder.items;
	}

	public List<Item> getItems() {
		List<Item> newItemList = items.stream().map(i -> Item.builder()
				.name(i.getName())
				.price(i.getPrice())
				.type(i.getType())
				.build()).collect(Collectors.toList());
		return Collections.unmodifiableList(newItemList);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private List<Item> items;

		private Builder() {
		}

		public Builder items(final List<Item> items) {
			List<Item> newItemList = items.stream().map(i -> Item.builder()
					.name(i.getName())
					.price(i.getPrice())
					.type(i.getType())
					.build()).collect(Collectors.toList());
			this.items = Collections.unmodifiableList(newItemList);
			return this;
		}

		public Basket build() {
			return new Basket(this);
		}
	}
}
