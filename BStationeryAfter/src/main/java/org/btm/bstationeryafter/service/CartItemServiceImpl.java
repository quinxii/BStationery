	package org.btm.bstationeryafter.service;

import org.btm.bstationeryafter.model.Cart;
import org.btm.bstationeryafter.model.CartItem;

public class CartItemServiceImpl implements CartItemService {

//	private CartItemDao cartItemDao = new CartItemDaoImpl();
//	
//	public CartItemDao getCartItemDao() {
//		return cartItemDao;
//	}
//
//	public void setCartItemDao(CartItemDao cartItemDao) {
//		this.cartItemDao = cartItemDao;
//	}
//
//	@Override
//	public void removeCartItem(String cartItemId) {
//		cartItemDao.removeCartItem(cartItemId);
//	}
//
//	@Override
//	public void removeAllCartItems(Cart cart) {
//		cartItemDao.removeAllCartItems(cart);
//	}
//
//	@Override
//	public boolean insert(CartItem cartItem, Cart cart) {
//		return cartItemDao.insert(cartItem,cart);
//	}

	@Override
	public void updateItemQuantity(String productId, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insert(CartItem cartItem, Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeCartItem(String cartItemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		// TODO Auto-generated method stub
		
	}

}
