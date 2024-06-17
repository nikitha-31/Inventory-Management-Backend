package com.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order-table")
public class Order {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String product;
    
    private int quantity;
    
    private String customerName;
    
    private String customerAddress;
    
    private String customerContact;
    
    private String status;
    
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
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerAddress() {
		return customerAddress;
	}
	
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public String getCustomerContact() {
		return customerContact;
	}
	
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public Order(Long id, String product, int quantity, String customerName, String customerAddress,
			String customerContact, String status) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerContact = customerContact;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", product=" + product + ", quantity=" + quantity + ", customerName=" + customerName
				+ ", customerAddress=" + customerAddress + ", customerContact=" + customerContact + ", status=" + status
				+ "]";
	}

	public Order() {
		super();
	} 
    
    
    
   
}