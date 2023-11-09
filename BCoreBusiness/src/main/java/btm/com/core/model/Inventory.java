package btm.com.core.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "[inventory]")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(name = "product_id")
	private String upc;

	@Column
	private Integer quantity;

	@Column(name = "export_at")
	private Date exp;

	@Column(name = "import_at")
	private Date imp;

	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "deleted_at")
	private Date deleteddAt;

	@OneToMany
	private Set<ProductModel> productModel;

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getExp() {
		return exp;
	}

	public void setExp(Date exp) {
		this.exp = exp;
	}

	public Date getImp() {
		return imp;
	}

	public void setImp(Date imp) {
		this.imp = imp;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDeleteddAt() {
		return deleteddAt;
	}

	public void setDeleteddAt(Date deleteddAt) {
		this.deleteddAt = deleteddAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<ProductModel> getProduct() {
		return productModel;
	}

	public void setProduct(Set<ProductModel> productModel) {
		this.productModel = productModel;
	}

}
