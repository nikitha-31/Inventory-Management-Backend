package com.stock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class StockReplenishment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String product;
    private Long supplierId;
    private int quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public StockReplenishment(Long id, String product, Long supplierId, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.supplierId = supplierId;
		this.quantity = quantity;
	}
	
	public StockReplenishment() {
		super();
	}
	
    
	@Override
	public String toString() {
		return "StockReplenishment [id=" + id + ", product=" + product + ", supplierId=" + supplierId + ", quantity="
				+ quantity + "]";
	}
	
	

}
