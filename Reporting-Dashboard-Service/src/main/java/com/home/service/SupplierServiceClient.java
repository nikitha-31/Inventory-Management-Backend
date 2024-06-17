package com.home.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.home.DTO.SupplierDto;

@FeignClient(name = "SUPPLIER-MICROSERVICE", url = "http://localhost:8003")
public interface SupplierServiceClient {
	
	@GetMapping("/suppliers/all")
	List<SupplierDto> getAllSuppliers();

}
