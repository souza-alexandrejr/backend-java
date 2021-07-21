package com.backend.java.shopping.api.dto;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.backend.java.shopping.api.model.Item;

@Embeddable
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
	
	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		
		itemDTO.setPrice(itemDTO.getPrice());
		itemDTO.setProductIdentifier(item.getProductIdentifier());
		
		return itemDTO;
	}
	
	@NotNull
	private Float price;
	
	@NotBlank
	private String productIdentifier;
	
}
