package com.backend.java.shopping.api.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.backend.java.shopping.api.model.Shop;

public class ShopDTO {

	public Date getDate() {
		return date;
	}
	
	public long getId() {
		return id;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public float getTotal() {
		return total;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		
		shopDTO.setDate(shop.getDate());
		shopDTO.setId(shop.getId());
		shopDTO.setItems(shop.getItems()
							.stream()
							.map(ItemDTO::convert)
							.collect(Collectors.toList()));
		shopDTO.setUserIdentifier(shop.getUserIdentifier());
		shopDTO.setTotal(shop.getTotal());
		
		return shopDTO;
	}
	
	@NotNull
	private Date date;
	
	@NotNull
	private long id;
	
	@NotNull
	private List<ItemDTO> items;
	
	@NotBlank
	private String userIdentifier;
	
	@NotNull
	private float total;

}
