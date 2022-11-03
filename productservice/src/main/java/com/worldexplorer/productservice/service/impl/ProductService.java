package com.worldexplorer.productservice.service.impl;

import java.util.List;

import com.worldexplorer.productservice.entity.Category;
import com.worldexplorer.productservice.entity.Product;

public interface ProductService {

	public List<Product> findAll();
	
	public Product create(Product product);
	
	public Product update(Product product);
	
	public Product delete(long id);
	
	public Product findById(long id);
	
	public List<Product> findByCategory(Category category);
	
	public Product updateStock(long id, double quantity);
}
