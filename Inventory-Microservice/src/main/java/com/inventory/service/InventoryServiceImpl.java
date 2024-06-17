package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Inventory;
import com.inventory.repository.InventoryRepo;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
    private InventoryRepo inventoryRepo;
	
	@Override
	public Inventory addStock(Inventory inventory) {
	    String product = inventory.getProduct();
	    Inventory existingInventory = inventoryRepo.findByProduct(product);
	    if (existingInventory != null) {
	        throw new RuntimeException("Product already exists");
	    }
	    return inventoryRepo.save(inventory);
	}
	
	

	@Override
	public Inventory reserveStock(String product, int quantity) {
		Inventory inventory = inventoryRepo.findByProduct(product);
        if (inventory == null || inventory.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        inventory.setQuantity(inventory.getQuantity() - quantity);
        return inventoryRepo.save(inventory);
	}

	@Override
	public Inventory getStock(String product) {
		Inventory inventory = inventoryRepo.findByProduct(product);
        if (inventory == null) {
            throw new RuntimeException("Product is not available");
        }
        return inventory;
		
	}

	@Override
	public Inventory updateStock(String product, Inventory updatedInventory) {
		
		 Inventory existingInventory = inventoryRepo.findByProduct(product);
		    
		    if (existingInventory != null) {
		        
		    	existingInventory.setPrice(updatedInventory.getPrice());
		    	existingInventory.setCategory(updatedInventory.getCategory());
		    	existingInventory.setDescription(updatedInventory.getDescription());
		        existingInventory.setQuantity(updatedInventory.getQuantity());
		       
		        return inventoryRepo.save(existingInventory);
		    } else {
		        throw new RuntimeException("Inventory for product '" + product+ "' not found");
		    }
		
	}
	
	@Override
	public void deleteStock(String product) {
		Inventory inventory = inventoryRepo.findByProduct(product);
        if (inventory == null) {
            throw new RuntimeException("Product is not available");
        }
        inventoryRepo.delete(inventory);
		
	}

	@Override
	public List<Inventory> getAllStocks() {
		return inventoryRepo.findAll();
	}



	

}
