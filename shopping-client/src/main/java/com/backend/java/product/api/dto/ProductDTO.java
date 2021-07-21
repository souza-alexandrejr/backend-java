package com.backend.java.product.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.backend.java.product.api.model.Product;

public class ProductDTO {

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Float getPrice() {
		return price;
	}

	public String getProductIdentifier() {
		return productIdentifier;
	}
	
	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
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
	
	@NotNull
	private CategoryDTO categoryDTO;
	
	private String description;
	
	@NotBlank
	private String name;

	@NotNull
	private Float price;

	@NotBlank
	private String productIdentifier;

}
