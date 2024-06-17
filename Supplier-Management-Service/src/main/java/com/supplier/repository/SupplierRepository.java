package com.supplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplier.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
