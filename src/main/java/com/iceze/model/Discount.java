package com.iceze.model;

import java.math.BigDecimal;
import java.util.List;

public class Discount {
	private String type;
	private BigDecimal amount;
	private List<String> itemNamesOrTypes;
	
	public Discount(String type, BigDecimal amount,
			List<String> itemNamesOrTypes) {
		super();
		this.type = type;
		this.amount = amount;
		this.itemNamesOrTypes = itemNamesOrTypes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public List<String> getItemNamesOrTypes() {
		return itemNamesOrTypes;
	}

	public void setItemNamesOrTypes(List<String> itemNamesOrTypes) {
		this.itemNamesOrTypes = itemNamesOrTypes;
	}
}
