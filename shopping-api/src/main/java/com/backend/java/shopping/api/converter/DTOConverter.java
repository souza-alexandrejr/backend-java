package com.backend.java.shopping.api.converter;

import java.util.stream.Collectors;

import com.backend.java.shopping.api.dto.ItemDTO;
import com.backend.java.shopping.api.dto.ShopDTO;
import com.backend.java.shopping.api.model.Item;
import com.backend.java.shopping.api.model.Shop;

public class DTOConverter {

	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		
		itemDTO.setPrice(itemDTO.getPrice());
		itemDTO.setProductIdentifier(item.getProductIdentifier());
		
		return itemDTO;
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
	
}
