package org.btm.bstationeryafter.model;

public class CustomerOrder {
	private int customerOrderId;
	private Cart cart;
	private ShippingAddress shippingAddress;
	private PaymentMethod paymentMethod;
	private StoreAddress storeAddress;
	private String customerOrderDate;
	
	public CustomerOrder() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public StoreAddress getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(StoreAddress storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getCustomerOrderDate() {
		return customerOrderDate;
	}

	public void setCustomerOrderDate(String customerOrderDate) {
		this.customerOrderDate = customerOrderDate;
	}

}
