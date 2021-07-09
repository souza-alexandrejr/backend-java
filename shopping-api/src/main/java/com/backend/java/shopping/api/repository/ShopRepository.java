package com.backend.java.shopping.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.java.shopping.api.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {

	public List<Shop> findAllByUserIdentifier(String userIdentifier);
	public List<Shop> findAllByTotalGreaterThan(Float price);
	public List<Shop> findAllByDateGreaterThan(Date date);
	
}
