package com.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.model.InventoryDto;
import com.order.model.Order;
import com.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
    private InventoryFeignClient inventoryFeignClient;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order, String product, int quantity) {
    	InventoryDto inventory = inventoryFeignClient.reserveStock(product, quantity);
        if (inventory == null || inventory.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setStatus("processing");
        return orderRepository.save(order);
    }
	
    
    @Override
    public Order markOrderAsSuccess(Long orderId, Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            if (!existingOrder.getStatus().equals("processing")) {
                throw new RuntimeException("Order status should be processing to mark as success");
            }
            existingOrder.setStatus("Success"); 
            return orderRepository.save(existingOrder);
        } else {
            throw new RuntimeException("Order not found"); 
        }
    }

	@Override
	public List<Order> getOrderHistory() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	

	

}
