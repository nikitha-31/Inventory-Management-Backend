package com.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.DTO.InventoryDto;
import com.home.DTO.OrderDto;
import com.home.DTO.SupplierDto;
import com.home.service.InventoryServiceClient;
import com.home.service.OrderServiceClient;
import com.home.service.SupplierServiceClient;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class Dashboard {

    @Autowired
    private InventoryServiceClient inventoryServiceClient;

    @Autowired
    private OrderServiceClient orderServiceClient;

    @Autowired
    private SupplierServiceClient supplierServiceClient;

    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryDto>> getInventoryData() {
        List<InventoryDto> inventories = inventoryServiceClient.getAllStocks();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDto>> getOrderHistory() {
        List<OrderDto> orderResponse = orderServiceClient.getOrderHistory();
        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping("/supplier")
    public ResponseEntity<List<SupplierDto>> getAllSuppliers() {
        List<SupplierDto> supplierResponse = supplierServiceClient.getAllSuppliers();
        return ResponseEntity.ok(supplierResponse);
    }
}
