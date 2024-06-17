package com.stock.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.stock.model.SupplierDto;

@FeignClient(name = "SUPPLIER-MICROSERVICE", url = "http://localhost:8003")
public interface SupplierServiceClient {
	
	@GetMapping("/suppliers/get/{supplierId}")
    SupplierDto getSupplier(@PathVariable("supplierId") Long supplierId);

}
