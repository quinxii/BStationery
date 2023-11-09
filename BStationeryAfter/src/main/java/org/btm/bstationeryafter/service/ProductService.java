package org.btm.bstationeryafter.service;

import java.util.List;

import btm.com.core.model.Category;
import btm.com.core.model.Product;

public interface ProductService {
	
	public List<Product> findAllProducts();
	
	public Product findProductById(String upc);

	public List<Product> searchProduct(String search);

	public List<Product> getSimilarProductsByCategory(Category currentProductCategory, String upc);
	
//	List<Product> getAllProducts();
//
//	Product getProductById(String productId);
//
//	void deleteProduct(String productId);
//
//	void addProduct(Product product);
//	
//	void editProduct(Product product);
//
//	List<Product> searchProduct(String search);
//
//	List<Product> getSimilarProductsByCategory(Category category, String productId);


}
