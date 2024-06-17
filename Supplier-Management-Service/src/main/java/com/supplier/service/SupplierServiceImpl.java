package com.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplier.model.Supplier;
import com.supplier.repository.SupplierRepository;


@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
    private SupplierRepository supplierRepository;

	@Override
	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier getSupplier(Long supplierId) {
		Optional<Supplier> supplierOptional = supplierRepository.findById(supplierId);
        if (supplierOptional.isPresent()) {
            return supplierOptional.get();
        } else {
            throw new RuntimeException("No supplier found with that id");
        }
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

	public void deleteSupplier(Long supplierId) {
		
	    Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierId);
	    if (optionalSupplier.isPresent()) {
	    	
	        supplierRepository.delete(optionalSupplier.get());
	    }
	    else {
	        throw new RuntimeException("Supplier not found");
	    }
	}

}
