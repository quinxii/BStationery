package btm.com.core.rest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import btm.com.core.model.ProductModel;
import btm.com.core.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService productService;

	// Get all product
	@GetMapping
	public List<ProductModel> get() {
		return productService.get();
	}

	@GetMapping("/detail")
	public Optional<ProductModel> detail(@QueryParam("upc") String upc) {
		return productService.findProduct(upc);
	}

	// Insert product
	@PostMapping("/insert")
	public ProductModel insert(ProductModel prod, @QueryParam("upc") String upc) {
		if (productService.findProduct(upc).isPresent()) {
			return null;
		} else {
			prod.setCreatedAt(new Date());
			productService.save(prod);
			return prod;
		}
	}

	// Find products by price range
	@GetMapping("/price")
	public List<ProductModel> findProductByPriceBetween(@QueryParam("priceMin") BigDecimal priceMin,
			@QueryParam("priceMax") BigDecimal priceMax) {
		return productService.findProductByPriceBetween(priceMin, priceMax);
	}

	// Find products by keyword
	@GetMapping("/search")
	public List<ProductModel> findProductByNameLike(@QueryParam("name") String name) {
		return productService.findProductByNameLike("%" + name + "%");
	}

	// Update products information
	@PutMapping("/update")
	public ProductModel updateInfo(ProductModel prod, @QueryParam("upc") String upc) {
		return productService.findProduct(upc).map(x -> {
			x.setName(prod.getName());
			x.setImage(prod.getImage());
			x.setDescription(prod.getDescription());
			x.setPrice(prod.getPrice());
			x.setQuantity(prod.getQuantity());
			x.setUpdatedAt(new Date());
			return productService.save(x);
		}).orElseGet(() -> {
			prod.setUpc(upc);
			return productService.save(prod);
		});
	}

	// Delete Product
	@DeleteMapping("/delete")
	public String delete(@QueryParam("upc") String upc) {
		productService.delete(upc);
		return "Delete product " + upc + " success";
	}
}
