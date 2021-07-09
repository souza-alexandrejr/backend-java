package com.backend.java.product.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.java.product.api.dto.ProductDTO;
import com.backend.java.product.api.model.Product;
import com.backend.java.product.api.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDTO> getAll() {
		List<Product> products = productRepository.findAll();
		return products
				.stream()
				.map(ProductDTO::convert)
				.collect(Collectors.toList());
	}
	
	public List<ProductDTO> getProductByCategoryId(Long categoryId) {
		List<Product> products = productRepository.getProductByCategory(categoryId);
		return products
				.stream()
				.map(ProductDTO::convert)
				.collect(Collectors.toList());
	}
	
	public ProductDTO findByProductIdentifier(String productIdentifier) {
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		
		if (product != null) {
			return ProductDTO.convert(product);
		}
		
		return null;
	}
	
	public ProductDTO save(ProductDTO productDTO) {
		Product product = productRepository.save(Product.convert(productDTO));
		return ProductDTO.convert(product);
	}
	
	public ProductDTO update(ProductDTO productDTO) {
		Product product = productRepository.findById(Product.convert(productDTO).getId()).get();
		
		if (product != null) {
			product.setName(productDTO.getName());
			product.setPrice(productDTO.getPrice());
			product.setProductIdentifier(productDTO.getProductIdentifier());
			product.setDescription(productDTO.getDescription());
			
			productRepository.save(product);
		}
		
		return ProductDTO.convert(product);
	}
	
	public void delete(ProductDTO productDTO) {
		Product product = productRepository.findById(Product.convert(productDTO).getId()).get();
		
		if (product != null) {
			productRepository.delete(product);
		}
	}
	
}
