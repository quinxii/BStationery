package btm.com.core.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btm.com.core.dao.ProductDAO;
import btm.com.core.model.ProductModel;
import btm.com.core.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;

	@Override
	public List<ProductModel> get() {
		return productDAO.findAll();
	}

	@Override
	public ProductModel save(ProductModel prod) {
		return productDAO.save(prod);
	}

	@Override
	public Optional<ProductModel> findProduct(String id) {
		return productDAO.findById(id);
	}

	@Override
	public List<ProductModel> findProductByPriceBetween(BigDecimal priceMin, BigDecimal priceMax) {
		return productDAO.findProductByPriceBetween(priceMin, priceMax);
	}

	@Override
	public ProductModel get(String id) {
		return productDAO.findByName(id);
	}

	@Override
	public List<ProductModel> findProductByNameLike(String name) {
		return productDAO.findProductByNameLike(name);
	}

	@Override
	public void delete(String upc) {
		productDAO.deleteById(upc);

	}

}
