package com.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplier.model.Supplier;
import com.supplier.service.SupplierServiceImpl;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
	
	@Autowired
	private SupplierServiceImpl supplierService;
	
	
	@PostMapping("/add")
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier savedSupplier = supplierService.saveSupplier(supplier);
        return ResponseEntity.ok(savedSupplier);
    }

    @GetMapping("/get/{supplierId}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable Long supplierId) {
    	Supplier supplier = supplierService.getSupplier(supplierId);
        if (supplier != null) {
            return ResponseEntity.ok(supplier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @DeleteMapping("/delete/{supplierId}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long supplierId) {
    	supplierService.deleteSupplier(supplierId);
    	return ResponseEntity.ok("Supplier deleted successfully");
    }


}
