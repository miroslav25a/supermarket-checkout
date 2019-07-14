package com.iceze.model;

import java.math.BigDecimal;

public final class Item {
    private final String name;
    private final BigDecimal price;
    private final String type;

    public Item() {
        this.name = null;
        this.price = null;
        this.type = null;
    }

    private Item(final Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.type = builder.type;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    
    public String getType() {
    	return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private BigDecimal price;
        private String type;

        private Builder() {
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder price(final BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder type(final String type) {
            this.type = type;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }
}
