package com.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.model.InventoryDto;

@FeignClient(name = "INVENTORY-MICROSERVICE", url = "http://localhost:8001")
public interface InventoryFeignClient {
    @PostMapping("/inventory/reserve")
    InventoryDto reserveStock(@RequestParam String product, @RequestParam int quantity);

    @GetMapping("/inventory/get")
    InventoryDto getStock(@RequestParam String product);
    
    @PutMapping("/inventory/update/{product}")
    InventoryDto updateStock(@PathVariable("product") String product, @RequestBody InventoryDto inventory);

}