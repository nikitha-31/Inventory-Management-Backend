package com.home.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


import com.home.DTO.InventoryDto;




@FeignClient(name = "INVENTORY-MICROSERVICE", url = "http://localhost:8001")
public interface InventoryServiceClient {
	
	@GetMapping("/inventory/all")
	List<InventoryDto> getAllStocks();
    

}
