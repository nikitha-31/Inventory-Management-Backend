package com.stock.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.stock.model.InventoryDto;

@FeignClient(name = "INVENTORY-MICROSERVICE", url = "http://localhost:8001")
public interface InventoryServiceClient {
	
	@GetMapping("/inventory/get")
    InventoryDto getStock(@RequestParam("product") String product);

    @PutMapping("/inventory/update/{product}")
    InventoryDto updateStock(@PathVariable("product") String product, @RequestBody InventoryDto inventory);

}
