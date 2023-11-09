package org.btm.bstationeryafter.service;

import java.math.BigDecimal;
import java.util.List;

//import org.btm.bstationeryafter.dao.CustomerOrderDao;
import org.btm.bstationeryafter.model.Cart;
import org.btm.bstationeryafter.model.CartItem;
import org.btm.bstationeryafter.model.CustomerOrder;

public class CustomerOrderServiceImpl implements CustomerOrderService {

//	private CustomerOrderDao customerOrderDao;
	private CartService cartService;
	

	@Override
	public void cancelCustomerOrder(int customerOrder) {
		
	}

	@Override
	public BigDecimal getCustomerOrderGrandTotal(String cartId) {
	    BigDecimal grandTotal = BigDecimal.ZERO;
	    Cart cart = cartService.getCartByCartId(cartId);
	    List<CartItem> cartItems = cart.getCartItem();

	    for (CartItem item : cartItems) {
	        BigDecimal itemPrice = item.getPrice();
	        grandTotal = grandTotal.add(itemPrice);
	    }

	    return grandTotal;
	}


	@Override
	public boolean addCustomerOrder(CustomerOrder order) {
		// TODO Auto-generated method stub
		return false;
	}

}
