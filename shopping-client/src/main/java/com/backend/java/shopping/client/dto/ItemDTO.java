package com.backend.java.shopping.client.dto;

public class ItemDTO {

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
	
	private Float price;
	private String productIdentifier;
	
}
