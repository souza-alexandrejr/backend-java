package com.backend.java.shopping.api.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.java.shopping.api.service.ShopReportService;
import com.backend.java.shopping.api.service.ShopService;
import com.backend.java.shopping.client.dto.ShopDTO;
import com.backend.java.shopping.client.dto.ShopReportDTO;

@RestController
public class ShopController {

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
	
	@GetMapping("/shopping/search")
	public List<ShopDTO> getShopByFilters(
			@RequestParam(name = "startDate", required = true)
			@DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
			@RequestParam(name = "endDate", required = false)
			@DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate,
			@RequestParam(name = "minimumValue", required = false) 
			Float minimumValue) {
		return shopReportService.getShopByFilters(startDate, endDate, minimumValue);
	}
	
	@GetMapping("/shopping/report")
	public ShopReportDTO getShopReportByDate(
			@RequestParam(name = "startDate", required = true)
			@DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
			@RequestParam(name = "endDate", required = true)
			@DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
		return shopReportService.getShopReportByDate(startDate, endDate);
	}
	
	@PostMapping("/shopping")
	public ShopDTO insertShop(
			@RequestHeader(name = "key", required = true) String key,
			@Valid @RequestBody ShopDTO shopDTO) {
		return shopService.save(shopDTO, key);
	}
	
	@PutMapping("/shopping/{id}")
	public ShopDTO updateShop(@PathVariable long id, 
							  @Valid @RequestBody ShopDTO shopDTO) {
		ShopDTO shop = shopService.findById(id);
		
		if (shop != null) {
			shop.setDate(new Date());
			shop.setItems(shopDTO.getItems());
			shop.setUserIdentifier(shopDTO.getUserIdentifier());
			shop.setTotal(shopDTO.getTotal());
			
			shopService.update(shop);
		}
		
		return shop;
	}
	
	@DeleteMapping("/shopping/{id}")
	public void deleteShop(@PathVariable long id) {
		ShopDTO shop = shopService.findById(id);
		
		if (shop != null) {
			shopService.delete(shop);
		}
	}
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ShopReportService shopReportService;
	
}
