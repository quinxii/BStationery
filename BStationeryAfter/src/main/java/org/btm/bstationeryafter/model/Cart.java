package org.btm.bstationeryafter.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import btm.com.core.model.UserProfile;

public class Cart {

	private String cartId;
	private UserProfile customer;
	private List<CartItem> cartItems;
	private BigDecimal totalPrice;
	private int totalQuantity;
	
	public Cart() {
		cartItems = new ArrayList<>();
    }

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public UserProfile getCustomer() {
		return customer;
	}

	public void setCustomer(UserProfile loginedUser) {
		this.customer = loginedUser;
	}

	public List<CartItem> getCartItem() {
		return cartItems;
	}

	public void setCartItem(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public void insertToCart(CartItem cartItem) {
        cartItems.add(cartItem);
    }
}
