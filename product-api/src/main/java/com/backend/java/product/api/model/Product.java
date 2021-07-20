package com.backend.java.product.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.backend.java.product.api.dto.ProductDTO;

@Entity(name="product")
public class Product {

	public Category getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public long getId() {
		return id;
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
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(long id) {
		this.id = id;
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

	public static Product convert(ProductDTO productDTO, long id) {
		Product product = new Product();
		
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setDescription(productDTO.getDescription());
		product.setProductIdentifier(productDTO.getProductIdentifier());
		
		if (productDTO.getCategoryDTO() != null) {
			product.setCategory(Category.convert(productDTO.getCategoryDTO(), id));
		}
		
		return product;
	}
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	private String description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private Float price;
	private String productIdentifier;
	
}
