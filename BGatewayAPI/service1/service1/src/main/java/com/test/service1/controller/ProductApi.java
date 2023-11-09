package com.test.service1.controller;

import java.math.BigDecimal;

import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service1.model.BrandModel;
import com.test.service1.model.CategoryModel;
import com.test.service1.model.DiscountModel;
import com.test.service1.model.ProductModel;
import com.test.service1.model.UserProfile;
import com.test.service1.service.ProductService;

@RestController
public class ProductApi {
	
	private static Logger logg = Logger.getLogger(LoginController.class);
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/api/product/id")
	public ProductModel getProductById(
					@QueryParam("upc")String upc) {
		ProductModel productCheckId = productService.findProductById(upc);
		logg.info("Find id Success");
		if(productCheckId != null) {
			logg.info("Done");
			return productCheckId;
		}else {
			logg.info("Not Found Id of Product");
			return null;			
		}
	}
	
//	@GetMapping("/api/product/name")
//	public ProductModel getProductByName(@QueryParam("name")String name) {
//		ProductModel productCheckName = productService.findProductByName(name);
//		logg.info("Find id by success");
//		if(productCheckName != null) {
//			logg.info("Done");
//			return productCheckName;
//		}else {
//			logg.info("Not Found Name of Product");
//			return null;		
//		}
//	}
	
	@GetMapping("/api/product/name")
	public ResponseEntity<String> getProductByName(@QueryParam("name")String name){
		String productCheckName = productService.findProductByName(name);
		logg.info("Find id by success");
		if(productCheckName != null) {
			logg.info("Done");
			return ResponseEntity.ok(productCheckName);
		}else {
			logg.info("Not Found Name of Product");
			return null;		
		}
	}
	
	@GetMapping("/api/product/price")
	public ProductModel getProductByPrice(@QueryParam("minPrice")BigDecimal minPrice, 
											@QueryParam("maxPrice")BigDecimal maxPrice) {
		ProductModel productCheckPrice = productService.findProductByPrice(minPrice, maxPrice);
		if(productCheckPrice != null) {
			logg.info("Done");
			return productCheckPrice;
		}else {
			logg.info("Not Found Price of Product");
			return null;
		}
	}
	
	@PostMapping("/api/product/save")
	public ProductModel postProduct(@QueryParam("UPC")String upc,
									@QueryParam("productName")String productName,
									@QueryParam("image")String image,
									@QueryParam("description")String description,
									@QueryParam("price")Double price,
									@QueryParam("brandId")BrandModel brandId,
									@QueryParam("categoryId")CategoryModel categoryId,
									@QueryParam("discountId")DiscountModel discountId) {
		ProductModel productCheck = productService.saveOfUpdateProduct(upc, productName, image, description, price, brandId, categoryId, discountId);
		if(productCheck != null) {
			logg.info("Done");
			return productCheck;
		}else {
			logg.info("Not Found Product");
			return null;
		}
	}
	
	@PutMapping("/api/product/update/{UPC}")
	public ProductModel putProduct(@PathVariable("UPC")String upc,
									@QueryParam("productName")String productName,
									@QueryParam("image")String image,
									@QueryParam("description")String description,
									@QueryParam("price")Double price,
									@QueryParam("brandId")BrandModel brandId,
									@QueryParam("categoryId")CategoryModel categoryId,
									@QueryParam("discountId")DiscountModel discountId){
		ProductModel productCheck = productService.saveOfUpdateProduct(upc, productName, image, description, price, brandId, categoryId, discountId);
		if(productCheck != null) {
			logg.info("Done");
			return productCheck;
		}else {
			logg.info("Not Found Product");
			return null;
		}
	}
	@PutMapping("/api/product/delete")
	public ProductModel deleteUser(@QueryParam("UPC") String upc) {
		ProductModel productCheck = productService.findProductById(upc);
		if (productCheck != null) {
			logg.info("Done");
			return productCheck;
		} else {
			logg.info("Not Found UPC");
			return null;
		}
	}
}
