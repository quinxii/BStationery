package org.btm.bstationeryafter.rest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.btm.bstationeryafter.utils.ConfigReader;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;

import btm.com.core.model.Product;

public class ProductRestService {

	// INVENTORY MANAGEMENT
	// Used for FIND PRODUCT BY ID FUNCTION
	public static Product callRestApiForFindProductById(String UPC) {
		Product productModel = new Product();
		
		try {
			ClientRequest request = new ClientRequest(ConfigReader.getApiProductPath()+ConfigReader.getApiProductFindById());
			
			request.queryParameter("UPC", UPC);
			
			ClientResponse<Product> response = request.get(Product.class);
			productModel = response.getEntity();
			if(productModel.getUpc() == null) {
				productModel = null;
			}
			
		} catch (UnrecognizedPropertyException e) {
		    
        } catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
		}
		
		return productModel;
	}
	
	// Used for FIND PRODUCT BY NAME FUNCTION
	public static List<Product> callRestApiForFindProductByName(String name) {
		List<Product> productModel = new ArrayList<>(); 
		
		try {
//			ClientRequest request = new ClientRequest(ConfigReader.getApiProductPath()+ConfigReader.getApiProductFindByName());
			ClientRequest request = new ClientRequest("http://localhost:9090/api/product/search");
			request.queryParameter("name", name);
			
			ClientResponse<List<Product>> response = request.get(new GenericType<List<Product>>() {});
	        
	        if (response.getResponseStatus().getFamily() == Response.Status.Family.SUCCESSFUL) {
	            productModel = response.getEntity();
	        } 
			
		} catch (UnrecognizedPropertyException e) {
		    
        } catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
		}
		
		return productModel;
	}
	
	// Used for FIND PRODUCT BY NAME FUNCTION
	public static Product callRestApiForFindProductByPrice(String priceMin, String priceMax) {
		Product productModel = new Product();
		
		try {
//			ClientRequest request = new ClientRequest(ConfigReader.getApiProductPath()+ConfigReader.getApiProductFindByPrice());
			ClientRequest request = new ClientRequest("http://localhost:9090/api/product/price");
			
			request.queryParameter("priceMin", priceMin);
			request.queryParameter("priceMax", priceMax);
			
			ClientResponse<Product> response = request.get(Product.class);
			productModel = response.getEntity();
			if(productModel.getUpc() == null) {
				productModel = null;
			}
			
		} catch (UnrecognizedPropertyException e) {
		    
        } catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
		}
		
		return productModel;
	}
		
	// Used for FIND ALL PRODUCTS FUNCTION
	public static List<Product> callRestApiForFindAllProducts() {
	    List<Product> productModel = new ArrayList<>(); 

	    try {
	        ClientRequest request = new ClientRequest("http://localhost:9090/api/product");
	        
	        ClientResponse<List<Product>> response = request.get(new GenericType<List<Product>>() {});
	        
	        if (response.getResponseStatus().getFamily() == Response.Status.Family.SUCCESSFUL) {
	            productModel = response.getEntity();
	        } 
		} catch (UnrecognizedPropertyException e) {
				    
	    } catch (MalformedURLException e) {
	    	
	        e.printStackTrace();
	        
	    } catch (IOException e) {
	    	
	        e.printStackTrace();
	        
	    } catch (Exception e) {
	    	
	    }
	    
	    return productModel;
	}
}
