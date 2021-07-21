package com.backend.java.shopping.api.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.java.shopping.api.converter.DTOConverter;
import com.backend.java.shopping.api.model.Item;
import com.backend.java.shopping.api.model.Shop;
import com.backend.java.shopping.api.repository.ShopRepository;
import com.backend.java.shopping.client.dto.ItemDTO;
import com.backend.java.shopping.client.dto.ProductDTO;
import com.backend.java.shopping.client.dto.ShopDTO;

@Service
public class ShopService {

	public List<ShopDTO> getAll() {
		List<Shop> shops = shopRepository.findAll();
		return shops
				.stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	public List<ShopDTO> getByUser(String userIdentifier) {
		List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
		return shops
				.stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	public List<ShopDTO> getByDate(ShopDTO shopDTO) {
		List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
		return shops
				.stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	public ShopDTO findById(long productId) {
		Optional<Shop> shop = shopRepository.findById(productId);
		
		if (shop.isPresent()) {
			return DTOConverter.convert(shop.get());
		}
		
		return null;
	}
	
	public ShopDTO save(ShopDTO shopDTO) {
		
		if (userService.getUserByCpf(shopDTO.getUserIdentifier()) == null) {
			return null;
		}
		
		if (!validateProducts(shopDTO.getItems())) {
			return null;
		}
		
		shopDTO.setTotal(shopDTO
							.getItems()
							.stream()
							.map(x -> x.getPrice())
							.reduce((float) 0, Float::sum));
		
		Shop shop = Shop.convert(shopDTO);
		shop.setDate(new Date());
		
		shop = shopRepository.save(shop);
		return DTOConverter.convert(shop);
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
		
		return DTOConverter.convert(shop);
	}
	
	public void delete(ShopDTO shopDTO) {
		Shop shop = shopRepository.findById(shopDTO.getId()).get();
		
		if (shop != null) {
			shopRepository.delete(shop);
		}
	}
	
	public boolean validateProducts(List<ItemDTO> items) {
		for (ItemDTO item : items) {
			ProductDTO productDTO = productService.getProductByIdentifier(item.getProductIdentifier());
			if (productDTO == null) { return false;	} 
			item.setPrice(productDTO.getPrice());
		}
		return true;
	}
	
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
}
