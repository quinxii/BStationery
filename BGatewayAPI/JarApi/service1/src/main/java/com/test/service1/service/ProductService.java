package com.test.service1.service;

import java.math.BigDecimal;

import com.test.service1.model.BrandModel;
import com.test.service1.model.CategoryModel;
import com.test.service1.model.DiscountModel;
import com.test.service1.model.ProductModel;

public interface ProductService {

	public String findProductByName(String name);
	
	public ProductModel findProductById(String upc);
	
	public ProductModel findProductByPrice(BigDecimal priceMin,BigDecimal priceMax);
	
	public ProductModel saveOfUpdateProduct(String upc,String productName, String image,String description
						,Double price, BrandModel brandId, CategoryModel categoryId, DiscountModel discountId);
}
