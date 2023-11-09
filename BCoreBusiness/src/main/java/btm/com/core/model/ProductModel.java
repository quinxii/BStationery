package btm.com.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "[product]", uniqueConstraints = { @UniqueConstraint(columnNames = { "brand_id", "category_id" }) })

public class ProductModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

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
	private BrandModel brandId;

//	@ManyToOne
//	@JoinColumn(name = "UPC")
//	private Inventory inventory;

	@ManyToOne(targetEntity = CategoryModel.class)
	@JoinColumn(name = "category_id")
	private CategoryModel categoryId;

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

	public BrandModel getBrandId() {
		return brandId;
	}

	public void setBrandId(BrandModel brandId) {
		this.brandId = brandId;
	}

	public CategoryModel getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(CategoryModel categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
