package com.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.model.StockReplenishment;

public interface StockReplenishmentRepository extends JpaRepository<StockReplenishment, Long> {
}
