package com.backend.java.shopping.api.model;

import javax.persistence.Embeddable;

import com.backend.java.shopping.api.dto.ItemDTO;

@Embeddable
public class Item {

	public Float getPrice() {
		return price;
	}
	
	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}
	
	public static Item convert(ItemDTO itemDTO) {
		Item item = new Item();
		
		item.setProductIdentifier(itemDTO.getProductIdentifier());
		item.setPrice(itemDTO.getPrice());
		
		return item;
	}
	
	private Float price;
	private String productIdentifier;
	
}
