package com.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String product;
	
	private double price;
	
    private String category;
    
    private String description;
	
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Inventory(Long id, String product, double price, String category, String description, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.price = price;
		this.category = category;
		this.description = description;
		this.quantity = quantity;
	}

	public Inventory() {
		super();
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", product=" + product + ", price=" + price + ", category=" + category
				+ ", description=" + description + ", quantity=" + quantity + "]";
	}
	
	
}
