package com.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.model.InventoryDto;
import com.stock.model.StockReplenishment;
import com.stock.model.SupplierDto;
import com.stock.repository.StockReplenishmentRepository;

@Service
public class StockReplenishmentServiceImpl implements StockReplenishmentService {
	
	@Autowired
	private StockReplenishmentRepository stockReplenishmentRepository;
	
	@Autowired
	private InventoryServiceClient inventoryServiceClient;
	
	@Autowired
	private SupplierServiceClient supplierServiceClient;
	
	
	@Override
	public List<StockReplenishment> getAllReplenishments() {
		return stockReplenishmentRepository.findAll();
	}


	@Override
	public StockReplenishment replenishStock(StockReplenishment replenishment) {
		SupplierDto supplier = supplierServiceClient.getSupplier(replenishment.getSupplierId());
		if (supplier == null || !supplier.getProduct().contains(replenishment.getProduct())) {
			throw new RuntimeException("Supplier does not supply this product");
		}
		
		// Call inventory service to add stock
		InventoryDto inventory = inventoryServiceClient.getStock(replenishment.getProduct());
		if (inventory == null) {
			throw new RuntimeException("Product not found in inventory");
		}
		inventory.setQuantity(inventory.getQuantity() + replenishment.getQuantity());
		inventoryServiceClient.updateStock(replenishment.getProduct(), inventory);
		
		// Save the replenishment record
		return stockReplenishmentRepository.save(replenishment);
	}

	
}
