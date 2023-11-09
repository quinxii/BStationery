package org.btm.bstationeryafter.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.btm.bstationeryafter.model.Cart;

public interface CartService {
	
	Cart getCartByCartId(String CartId);

	BigDecimal getTotalCartPrice(ArrayList<Cart> cartList);

	void update(Cart existingCart);

	void delete(String cartId);

//	boolean insert(Cart cart, Customer customer);
	
//	Cart findCartByCustomer(Customer customer);
}
