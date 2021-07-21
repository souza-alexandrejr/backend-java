package com.backend.java.shopping.api.repository;

import java.util.Date;
import java.util.List;

import com.backend.java.shopping.api.model.Shop;
import com.backend.java.shopping.client.dto.ShopReportDTO;

public interface ShopReportRepository {

	public List<Shop> getShopByFilters(Date startDate, Date endDate, Float minimumValue);
	public ShopReportDTO getShopReportByDate(Date startDate, Date endDate);

}
