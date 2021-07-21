package com.backend.java.product.api.converter;

import com.backend.java.product.api.model.Category;
import com.backend.java.product.api.model.Product;
import com.backend.java.shopping.client.dto.CategoryDTO;
import com.backend.java.shopping.client.dto.ProductDTO;

public class DTOConverter {
	
	public static CategoryDTO convert(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		
		categoryDTO.setName(category.getName());
		
		return categoryDTO;
	}
	
	public static ProductDTO convert(Product product) {
		ProductDTO productDTO = new ProductDTO();

		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setDescription(product.getDescription());
		productDTO.setProductIdentifier(product.getProductIdentifier());

		if (product.getCategory() != null) {
			productDTO.setCategoryDTO(DTOConverter.convert(product.getCategory()));
		}

		return productDTO;
	}

}
