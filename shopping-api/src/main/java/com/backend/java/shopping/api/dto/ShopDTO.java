package com.backend.java.shopping.api.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.backend.java.shopping.api.model.Shop;

public class ShopDTO {

	@NotBlank
	private String userIdentifier;
	
	@NotNull
	private float total;

	@NotNull
	private Date date;
	
	@NotNull
	private List<ItemDTO> items;
	
	public String getUserIdentifier() {
		return userIdentifier;
	}
	
	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<ItemDTO> getItems() {
		return items;
	}
	
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	
	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		
		return shopDTO;
	}
	
}
