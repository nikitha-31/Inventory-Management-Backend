package com.stock.service;

import java.util.List;

import com.stock.model.StockReplenishment;

public interface StockReplenishmentService {
	
    StockReplenishment replenishStock(StockReplenishment replenishment);
    
    List<StockReplenishment> getAllReplenishments();
}
