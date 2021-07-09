package com.backend.java.shopping.api.dto;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.backend.java.shopping.api.model.Item;

@Embeddable
public class ItemDTO {

	@NotBlank
	private String productIdentifier;
	
	@NotNull
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
	
	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		
		itemDTO.setProductIdentifier(item.getProductIdentifier());
		itemDTO.setPrice(itemDTO.getPrice());
		
		return itemDTO;
	}
	
}
