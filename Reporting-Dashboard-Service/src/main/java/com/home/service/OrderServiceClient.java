package com.home.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.home.DTO.OrderDto;

@FeignClient(name = "ORDER-MICROSERVICE", url = "http://localhost:8002")
public interface OrderServiceClient {
	
	@GetMapping("orders/history")
	List<OrderDto> getOrderHistory();

}
