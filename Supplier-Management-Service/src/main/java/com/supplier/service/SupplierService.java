package com.supplier.service;

import java.util.List;

import com.supplier.model.Supplier;

public interface SupplierService {
	
	Supplier saveSupplier(Supplier supplier);
	
	Supplier getSupplier(Long supplierId);
	
	List<Supplier> getAllSuppliers();
	
	void deleteSupplier(Long supplierId);
	

}
