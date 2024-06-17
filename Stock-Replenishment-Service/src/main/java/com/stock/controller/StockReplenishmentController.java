package com.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.model.StockReplenishment;
import com.stock.service.StockReplenishmentService;

@RestController
@RequestMapping("/replenishments")
public class StockReplenishmentController {
	
	@Autowired
	private StockReplenishmentService stockReplenishmentService;

	@PostMapping("/replenish")
	public ResponseEntity<StockReplenishment> replenishStock(@RequestBody StockReplenishment replenishment) {
	    StockReplenishment replenished = stockReplenishmentService.replenishStock(replenishment);
	    return ResponseEntity.status(HttpStatus.CREATED).body(replenished);
	}


	@GetMapping("/all")
	public ResponseEntity<List<StockReplenishment>> getAllReplenishments() {
		List<StockReplenishment> replenishments = stockReplenishmentService.getAllReplenishments();
		return ResponseEntity.ok(replenishments);
	}
}