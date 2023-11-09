package com.test.service1.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



import com.google.gson.Gson;

public class ProductJsonMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	private ProductModel productModel;
	
	public ProductJsonMessage() {
		super();
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}
	
}
	
