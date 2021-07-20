package com.backend.java.shopping.api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.java.shopping.api.dto.ShopDTO;
import com.backend.java.shopping.api.model.Shop;
import com.backend.java.shopping.api.model.Item;
import com.backend.java.shopping.api.repository.ShopRepository;

@Service
public class ShopService {

	public List<ShopDTO> getAll() {
		List<Shop> shops = shopRepository.findAll();
		return shops
				.stream()
				.map(ShopDTO::convert)
				.collect(Collectors.toList());
	}
	
	public List<ShopDTO> getByUser(String userIdentifier) {
		List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
		return shops
				.stream()
				.map(ShopDTO::convert)
				.collect(Collectors.toList());
	}
	
	public List<ShopDTO> getByDate(ShopDTO shopDTO) {
		List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
		return shops
				.stream()
				.map(ShopDTO::convert)
				.collect(Collectors.toList());
	}
	
	public ShopDTO findById(long productId) {
		Optional<Shop> shop = shopRepository.findById(productId);
		
		if (shop.isPresent()) {
			return ShopDTO.convert(shop.get());
		}
		
		return null;
	}
	
	public ShopDTO save(ShopDTO shopDTO) {
		shopDTO.setTotal(shopDTO
							.getItems()
							.stream()
							.map(x -> x.getPrice())
							.reduce((float) 0, Float::sum));
		
		Shop shop = Shop.convert(shopDTO);
		shop.setDate(new Date());
		
		shop = shopRepository.save(shop);
		return ShopDTO.convert(shop);
	}
	
	public ShopDTO update(ShopDTO shopDTO) {
		Shop shop = shopRepository.findById(shopDTO.getId()).get();
		
		if (shop != null) {
			
			shop.setDate(new Date());
			shop.setId(shopDTO.getId());
			shop.setItems(shopDTO
					.getItems()
					.stream()
					.map(Item::convert)
					.collect(Collectors.toList()));
			shop.setUserIdentifier(shopDTO.getUserIdentifier());
			shop.setTotal(shopDTO
					.getItems()
					.stream()
					.map(x -> x.getPrice())
					.reduce((float) 0, Float::sum));
			
			shopRepository.save(shop);
		}
		
		return ShopDTO.convert(shop);
	}
	
	public void delete(ShopDTO shopDTO) {
		Shop shop = shopRepository.findById(shopDTO.getId()).get();
		
		if (shop != null) {
			shopRepository.delete(shop);
		}
	}
	
	@Autowired
	private ShopRepository shopRepository;
}