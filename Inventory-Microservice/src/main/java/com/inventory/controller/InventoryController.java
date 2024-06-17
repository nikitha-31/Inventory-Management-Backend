package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.Inventory;
import com.inventory.service.InventoryServiceImpl;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryServiceImpl inventoryServiceImpl;
	
	@PostMapping("/add")
    private ResponseEntity<Inventory>  addStock(@RequestBody Inventory inventory) {
		Inventory addStock=inventoryServiceImpl.addStock(inventory);
        return ResponseEntity.status(HttpStatus.CREATED).body(addStock);
    }
	
	@PostMapping("/reserve")
	public Inventory reserveStock(@RequestParam String product, @RequestParam int quantity) {
	    return inventoryServiceImpl.reserveStock(product, quantity);  
	}
	
	@GetMapping("/get")
    public Inventory getStock(@RequestParam String product) {
        return inventoryServiceImpl.getStock(product);
    }
	
	@GetMapping("/all")
    public List<Inventory> getAllStocks() {
        return inventoryServiceImpl.getAllStocks();
    }
	
	@PutMapping("/update/{product}")
    public ResponseEntity<?> updateStock(@PathVariable String product, @RequestBody Inventory updatedInventory) {
		Inventory updated = inventoryServiceImpl.updateStock(product, updatedInventory);
        return ResponseEntity.ok(updated);
       
    }
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteStock(@RequestParam String product) {
		
	    inventoryServiceImpl.deleteStock(product);
	    return ResponseEntity.ok("stock deleted successfully");
	}

}
