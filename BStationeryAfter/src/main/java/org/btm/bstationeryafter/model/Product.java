package org.btm.bstationeryafter.model;

import java.math.BigDecimal;

public class Product {
	private String productId;
	private String productCode;
	private String productName;
	private BigDecimal productPrice;
	private Category category;
	private String productCreatedAt;
	private String productImage;
	private Brand brand;
	private int productStock;
	private String productDescription;
	private String UPC;

	public Product() {
		
	}
	
	public Product(String productId, String productCode, String productName, BigDecimal productPrice,
			Category category, String productCreatedAt, String productImage, Brand brand, int productStock,
			String productDescription) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.category = category;
		this.productCreatedAt = productCreatedAt;
		this.productImage = productImage;
		this.brand = brand;
		this.productStock = productStock;
		this.productDescription = productDescription;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCreatedAt() {
		return productCreatedAt;
	}

	public void setProductCreatedAt(String productCreatedAt) {
		this.productCreatedAt = productCreatedAt;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int i) {
		this.productStock = i;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getUPC() {
		return UPC;
	}

	public void setUPC(String uPC) {
		UPC = uPC;
	}

}
