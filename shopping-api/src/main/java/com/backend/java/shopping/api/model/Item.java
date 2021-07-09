package com.backend.java.shopping.api.model;

import com.backend.java.shopping.api.dto.ItemDTO;

public class Item {

	private String productIdentifier;
	private Float price;
	
	public String getProductIdentifier() {
		return productIdentifier;
	}
	
	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public static Item convert(ItemDTO itemDTO) {
		Item item = new Item();
		
		item.setProductIdentifier(itemDTO.getProductIdentifier());
		item.setPrice(itemDTO.getPrice());
		
		return item;
	}
}
