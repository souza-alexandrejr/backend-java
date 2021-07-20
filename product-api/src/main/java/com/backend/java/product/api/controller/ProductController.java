package com.backend.java.product.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.java.product.api.dto.ProductDTO;
import com.backend.java.product.api.service.ProductService;

@RestController
public class ProductController {

	@GetMapping("/")
	public String getMessage() {
		return "Product API Project";
	}
	
	@GetMapping("/products")
	public List<ProductDTO> getProducts() {
		List<ProductDTO> products = productService.getAll();
		return products;
	}
	
	@GetMapping("/products/category/{categoryId}")
	public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {
		List<ProductDTO> products = productService.getProductByCategoryId(categoryId);
		return products;
	}
	
	@GetMapping("/products/{productIdentifier}")
	public ProductDTO findById(@PathVariable String productIdentifier) {
		return productService.findByProductIdentifier(productIdentifier);
	}
	
	@PostMapping("/products")
	public ProductDTO insertProduct(@Valid @RequestBody ProductDTO productDTO) {
		return productService.save(productDTO);
	}
	
	@PutMapping("/products/{productIdentifier}")
	public ProductDTO updateProduct(@PathVariable String productIdentifier, 
									@Valid @RequestBody ProductDTO productDTO) {
		ProductDTO product = productService.findByProductIdentifier(productIdentifier);
		
		if (product != null) {
			product.setName(productDTO.getName());
			product.setPrice(productDTO.getPrice());
			product.setProductIdentifier(productDTO.getProductIdentifier());
			product.setDescription(productDTO.getDescription());
			product.setCategoryDTO(productDTO.getCategoryDTO());
			
			productService.update(product);
		}
		
		return product;
	}
	
	@DeleteMapping("/products/{productIdentifier}")
	public void deleteProduct(@PathVariable String productIdentifier) {
		ProductDTO product = productService.findByProductIdentifier(productIdentifier);
		
		if (product != null) {
			productService.delete(product);
		}
	}
	
	@Autowired
	private ProductService productService;
	
}
