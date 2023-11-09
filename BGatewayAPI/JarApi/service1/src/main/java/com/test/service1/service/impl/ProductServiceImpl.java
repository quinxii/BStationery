package com.test.service1.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.test.service1.model.BrandModel;
import com.test.service1.model.CategoryModel;
import com.test.service1.model.DiscountModel;
import com.test.service1.model.ProductJsonMessage;
import com.test.service1.model.ProductModel;
import com.test.service1.service.ProductService;
import com.test.service1.utils.JsonConversion;

@Service
public class ProductServiceImpl implements ProductService {

	private static Logger logg = Logger.getLogger(ProductServiceImpl.class);

	@Override
	public String findProductByName(String name) {
		ProductJsonMessage productCheckName = new ProductJsonMessage();
		String result = "";
		try {
			ClientRequest request = new ClientRequest("http://localhost:9090/api/product/search");
			request.accept(MediaType.APPLICATION_JSON);
			request.queryParameter("name", name);
			
			ClientResponse<ProductJsonMessage> response = request.get(ProductJsonMessage.class);
			productCheckName = response.getEntity();
			boolean isSuccess = false;
			if (productCheckName.getProductModel().getName() != null) {
				isSuccess = true;
				logg.info("Find Product with name : success");
			}
			JsonConversion<ProductJsonMessage> jsonConversion = new JsonConversion<ProductJsonMessage>(productCheckName);
			jsonConversion.setT(productCheckName);
			result = jsonConversion.ObjectToString();
			ProductJsonMessage convertedObject = jsonConversion.StringToObject(result, ProductJsonMessage.class);
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
				
		return result;

	}

	@Override
	public ProductModel findProductById(String upc) {
		ProductModel productCheckId = new ProductModel();
		try {
			ClientRequest request = new ClientRequest("");
			request.queryParameter("upc", upc);

			ClientResponse<ProductModel> response = request.get(ProductModel.class);
			productCheckId = response.getEntity();
			boolean isSuccess = false;
			if (productCheckId.getName() != null) {
				isSuccess = true;
				logg.info("Find Product with id : success");
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return productCheckId;
	}

	@Override
	public ProductModel findProductByPrice(BigDecimal priceMin, BigDecimal priceMax) {
		ProductModel productCheckPrice = new ProductModel();
		try {
			ClientRequest request = new ClientRequest("http://localhost:9090/api/product/price");
			request.queryParameter("priceMin", priceMin);
			request.queryParameter("priceMax", priceMax);

			ClientResponse<ProductModel> response = request.get(ProductModel.class);
			productCheckPrice = response.getEntity();
			boolean isSuccess = false;
			if (productCheckPrice.getName() != null) {
				isSuccess = true;
				logg.info("Find Product with id : success");
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return productCheckPrice;
	}

	@Override
	public ProductModel saveOfUpdateProduct(String upc, String productName, String image, String description,
			Double price, BrandModel brandId, CategoryModel categoryId, DiscountModel discountId) {
		ProductModel productCheck = new ProductModel();
		try {
			ClientRequest request = new ClientRequest("http://localhost:9090/api/product/insert");
			request.accept(MediaType.APPLICATION_JSON);
			request.queryParameter("upc", upc);
			request.queryParameter("productName", productName);
			request.queryParameter("image", image);
			request.queryParameter("description", description);
			request.queryParameter("price", price);
			request.queryParameter("brandId", brandId);
			request.queryParameter("categoryId", categoryId);
			request.queryParameter("discountId", discountId);

			ClientResponse<ProductModel> response = request.post(ProductModel.class);
			productCheck = response.getEntity();
			boolean isSuccess = false;
			if (productCheck.getUpc() != null) {
				isSuccess = true;
				logg.info("Save Of Update Success!!!");
			}
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return productCheck;
	}

}
