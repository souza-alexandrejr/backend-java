package com.backend.java.shopping.api.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.java.shopping.api.dto.ShopDTO;
import com.backend.java.shopping.api.dto.ShopReportDTO;
import com.backend.java.shopping.api.model.Shop;
import com.backend.java.shopping.api.repository.ShopReportRepository;

@Service
public class ShopReportService {

	public List<ShopDTO> getShopByFilters(Date startDate, Date endDate, Float minimumValue) {
		List<Shop> shops = shopReportRepository.getShopByFilters(startDate, endDate, minimumValue);
		return shops
				.stream()
				.map(ShopDTO::convert)
				.collect(Collectors.toList());
	}
	
	public ShopReportDTO getShopReportByDate(Date startDate, Date endDate) {
		return shopReportRepository.getShopReportByDate(startDate, endDate);
	}
	
	@Autowired
	private ShopReportRepository shopReportRepository;
	
}
