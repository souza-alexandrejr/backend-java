package com.backend.java.shopping.api.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.backend.java.shopping.client.dto.ShopDTO;

@Entity(name = "shop")
public class Shop {

	public Date getDate() {
		return date;
	}
	
	public long getId() {
		return id;
	}
	
	public List<Item> getItems() {
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

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public static Shop convert(ShopDTO shopDTO) {
		Shop shop = new Shop();
		
		shop.setDate(shopDTO.getDate());
		shop.setItems(shopDTO
				.getItems()
				.stream()
				.map(Item::convert)
				.collect(Collectors.toList()));
		shop.setUserIdentifier(shopDTO.getUserIdentifier());
		shop.setTotal(shopDTO.getTotal());
		
		return shop;
	}
	
	private Date date;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
	private List<Item> items;
	
	private String userIdentifier;
	private float total;
	
}
