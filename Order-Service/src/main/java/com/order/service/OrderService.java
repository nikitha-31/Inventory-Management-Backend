package com.order.service;

import java.util.List;

import com.order.model.Order;

public interface OrderService {
	
	Order createOrder(Order order,String product, int quantity);
	
	
	List<Order> getOrderHistory();
	
	Order markOrderAsSuccess(Long orderId,Order order);
}
