package btm.com.core.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import btm.com.core.model.ProductModel;

public interface ProductDAO extends JpaRepository<ProductModel, String> {

	List<ProductModel> findProductByPriceBetween(BigDecimal priceMin, BigDecimal priceMax);

	List<ProductModel> findProductByNameLike(String name);
	
	ProductModel findByName(String id);


}
