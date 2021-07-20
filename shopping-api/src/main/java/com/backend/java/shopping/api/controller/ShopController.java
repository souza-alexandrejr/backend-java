package com.backend.java.shopping.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.java.shopping.api.dto.ShopDTO;
import com.backend.java.shopping.api.service.ShopService;

@RestController
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	@GetMapping("/")
	public String getMessage() {
		return "Shopping API Project";
	}
	
	@GetMapping("/shopping")
	public List<ShopDTO> getShops() {
		List<ShopDTO> products = shopService.getAll();
		return products;
	}
	
	@GetMapping("/shopping/user/{userIdentifier}")
	public List<ShopDTO> getShops(@PathVariable String userIdentifier) {
		List<ShopDTO> products = shopService.getByUser(userIdentifier);
		return products;
	}
	
	@GetMapping("/shopping/date")
	public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {
		List<ShopDTO> products = shopService.getByDate(shopDTO);
		return products;
	}
	
	@GetMapping("/shopping/{id}")
	public ShopDTO findById(@PathVariable long id) {
		return shopService.findById(id);
	}
	
	@PostMapping("/shopping")
	public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO) {
		return shopService.save(shopDTO);
	}
	
	// PUT Method
	
	// DELETE Method
}
