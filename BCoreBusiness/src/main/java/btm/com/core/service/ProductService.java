package btm.com.core.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import btm.com.core.model.ProductModel;

public interface ProductService {

	List<ProductModel> get();

	ProductModel save(ProductModel prod);

	Optional<ProductModel> findProduct(String id);

	ProductModel get(String id);

	List<ProductModel> findProductByPriceBetween(BigDecimal priceMin, BigDecimal priceMax);

	List<ProductModel> findProductByNameLike(String name);

	void delete(String upc);

}