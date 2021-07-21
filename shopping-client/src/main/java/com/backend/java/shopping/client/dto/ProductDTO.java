package com.backend.java.shopping.client.dto;

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

	private CategoryDTO categoryDTO;
	private String description;
	private String name;
	private Float price;
	private String productIdentifier;

}
