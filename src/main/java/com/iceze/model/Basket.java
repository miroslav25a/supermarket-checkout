package com.iceze.model;

import java.util.List;

public class Basket 
{
	private List<Item> items;

	public Basket(List<Item> items) {
		super();
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
