package com.inventory.service;

import java.util.List;

import com.inventory.model.Inventory;

public interface InventoryService {
	
	Inventory addStock(Inventory inventory);
	
	Inventory reserveStock(String product, int quantity);
	
	Inventory getStock(String product);
	
	Inventory updateStock(String product, Inventory updatedInventory);
	
	void deleteStock(String product);
	
	List<Inventory> getAllStocks();
	
	

}
