package org.btm.bstationeryafter.service;

import java.util.List;

import org.btm.bstationeryafter.rest.ProductRestService;

import btm.com.core.model.Category;
import btm.com.core.model.Product;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> findAllProducts() {
		List<Product> product = ProductRestService.callRestApiForFindAllProducts();
		return product;
	}

	@Override
	public Product findProductById(String upc) {
		Product product = ProductRestService.callRestApiForFindProductById(upc);
		return product;
	}

	@Override
	public List<Product> searchProduct(String search) {
		List<Product> product = ProductRestService.callRestApiForFindProductByName(search);
		return product;
	}

	@Override
	public List<Product> getSimilarProductsByCategory(Category currentProductCategory, String upc) {
		// TODO Auto-generated method stub
		return null;
	}

}
