package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.order.model.InventoryDto;
import com.order.model.Order;
import com.order.service.InventoryFeignClient;

import com.order.service.OrderServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
    private InventoryFeignClient inventoryFeignClient;
	
	@Autowired
    private OrderServiceImpl orderService;
	
	 @PostMapping("/create")
	 public ResponseEntity<Order> createOrder(@RequestBody Order order,@RequestParam String product, @RequestParam int quantity) 
	 {
		 InventoryDto inventory=inventoryFeignClient.getStock(product);
		 Order neworder=orderService.createOrder(order, inventory.getProduct(),quantity);
				 
		 return new ResponseEntity<>(neworder, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/status/{orderId}")
	 public ResponseEntity<?>  markOrderAsSuccess(@PathVariable Long orderId,Order order) {
	       
	       Order updateOrder = orderService.markOrderAsSuccess(orderId, order);
	       return ResponseEntity.ok(updateOrder);
	        
	 }
	 
	 @GetMapping("/history")
	 public ResponseEntity<List<Order>> getOrderHistory(){
		 List<Order> orders=orderService.getOrderHistory();
		 return ResponseEntity.ok(orders);
	 }

}
