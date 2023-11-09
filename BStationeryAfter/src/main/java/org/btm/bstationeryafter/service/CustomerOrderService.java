package org.btm.bstationeryafter.service;

import java.math.BigDecimal;

import org.btm.bstationeryafter.model.CustomerOrder;

public interface CustomerOrderService {
	
	BigDecimal getCustomerOrderGrandTotal(String cartId);

	void cancelCustomerOrder(int customerOrderId);

	boolean addCustomerOrder(CustomerOrder order);

}
