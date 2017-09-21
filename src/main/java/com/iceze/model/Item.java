package com.iceze.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Item {
    private String name;
    private BigDecimal price;
    private String type;

    @JsonCreator
    public Item(@JsonProperty("name") String name,
                @JsonProperty("price") BigDecimal price,
                @JsonProperty("type") String type) {
        this.name = name;
        this.price = price;
        this.type = type;
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
}
