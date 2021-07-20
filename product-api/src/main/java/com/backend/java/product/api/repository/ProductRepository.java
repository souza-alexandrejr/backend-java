package com.backend.java.product.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.java.product.api.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> getProductByCategoryId(Long categoryId);
	public Product findByProductIdentifier(String productIdentifier);
	
}
