package com.backend.java.product.api.dto;

import javax.validation.constraints.NotNull;

import com.backend.java.product.api.model.Category;

public class CategoryDTO {

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static CategoryDTO convert(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		
		categoryDTO.setName(category.getName());
		
		return categoryDTO;
	}
	
	@NotNull
	private String name;
	
}
