package org.btm.bstationeryafter.service;

import org.btm.bstationeryafter.model.Cart;
import org.btm.bstationeryafter.model.CartItem;

public interface CartItemService {
	
	boolean insert(CartItem cartItem, Cart cart);
	
	void removeCartItem(String cartItemId);
	
	void removeAllCartItems(Cart cart);

	void updateItemQuantity(String productId, int quantity);

}
