package com.backend.java.product.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.backend.java.product.api.dto.CategoryDTO;

@Entity(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static Category convert(CategoryDTO categoryDTO) {
		Category category = new Category();
		
		category.setName(categoryDTO.getName());
		
		return category;
	}
	
}