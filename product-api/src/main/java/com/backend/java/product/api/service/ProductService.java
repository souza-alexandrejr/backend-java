package com.backend.java.product.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.java.product.api.converter.DTOConverter;
import com.backend.java.product.api.dto.ProductDTO;
import com.backend.java.product.api.model.Category;
import com.backend.java.product.api.model.Product;
import com.backend.java.product.api.repository.CategoryRepository;
import com.backend.java.product.api.repository.ProductRepository;
import com.backend.java.shopping.client.exception.CategoryNotFoundException;
import com.backend.java.shopping.client.exception.ProductNotFoundException;

@Service
public class ProductService {

	public List<ProductDTO> getAll() {
		List<Product> products = productRepository.findAll();
		return products
				.stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	public List<ProductDTO> getProductByCategoryId(Long categoryId) {
		List<Product> products = productRepository.getProductByCategoryId(categoryId);
		return products
				.stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	public ProductDTO findByProductIdentifier(String productIdentifier) {
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		
		if (product != null) {
			return DTOConverter.convert(product);
		}
		throw new ProductNotFoundException();
	}
	
	public ProductDTO save(ProductDTO productDTO) {
		Category category = categoryRepository.findByName(productDTO.getCategoryDTO().getName());
		
		if (category != null) {
			Product product = productRepository.save(Product.convert(productDTO, category.getId()));
			return DTOConverter.convert(product);
		}
		throw new CategoryNotFoundException();
	}
	
	public ProductDTO update(ProductDTO productDTO) {
		Category category = categoryRepository.findByName(productDTO.getCategoryDTO().getName());
		
		Product product = productRepository.findByProductIdentifier(productDTO.getProductIdentifier());
		
		if (product != null) {
			product.setName(productDTO.getName());
			product.setPrice(productDTO.getPrice());
			product.setProductIdentifier(productDTO.getProductIdentifier());
			product.setDescription(productDTO.getDescription());
			product.setCategory(Category.convert(productDTO.getCategoryDTO(), category.getId()));
			
			productRepository.save(product);
		}
		
		return DTOConverter.convert(product);
	}
	
	public ProductDTO delete(ProductDTO productDTO) {
		Product product = productRepository.findByProductIdentifier(productDTO.getProductIdentifier());
		
		if (product != null) {
			productRepository.delete(product);
		}
		throw new ProductNotFoundException();
	}
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
}
