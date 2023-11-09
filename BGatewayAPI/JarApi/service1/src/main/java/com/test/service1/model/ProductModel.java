package com.test.service1.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;



@Entity
@Table(name = "[product]", uniqueConstraints = { @UniqueConstraint(columnNames = { "brand_id", "category_id" }) })
public class ProductModel {

	@Id
	@Column(name = "UPC", nullable = false)
	private String upc;
	@Column(name = "product_name")
	private String name;
	@Column
	private String image;
	@Column
	private String description;
	@Column
	private BigDecimal price;
	@Column
	private Integer quantity;
	@Column
	private Boolean active;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "deleted_at")
	private Date deletedAt;

	@ManyToOne(targetEntity = BrandModel.class)
	@JoinColumn(name = "brand_id")
	private Collection<BrandModel>  brandId;

	@ManyToOne(targetEntity = CategoryModel.class)
	@JoinColumn(name = "category_id")
	private Collection<CategoryModel>  categoryId;

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Collection<BrandModel> getBrandId() {
		return brandId;
	}

	public void setBrandId(Collection<BrandModel> brandId) {
		this.brandId = brandId;
	}

	public Collection<CategoryModel> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Collection<CategoryModel> categoryId) {
		this.categoryId = categoryId;
	}	
}

