package com.backend.java.shopping.client.dto;

import java.util.Date;
import java.util.List;

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

	private Date date;
	private long id;
	private List<ItemDTO> items;
	private String userIdentifier;
	private float total;

}
