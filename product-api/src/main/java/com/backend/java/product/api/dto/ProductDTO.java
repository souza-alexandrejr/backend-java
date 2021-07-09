package com.backend.java.product.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.backend.java.product.api.model.Product;

public class ProductDTO {

	@NotBlank
	private String name;
	
	@NotNull
	private Float price;
	
	private String description;
	
	@NotBlank
	private String productIdentifier;
	
	@NotNull
	private CategoryDTO categoryDTO;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductIdentifier() {
		return productIdentifier;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	
	public static ProductDTO convert(Product product) {
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());
		productDTO.setProductIdentifier(product.getProductIdentifier());
		
		if (product.getCategory() != null) {
			productDTO.setCategoryDTO(CategoryDTO.convert(product.getCategory()));
		}
		
		return productDTO;
	}
	
}
