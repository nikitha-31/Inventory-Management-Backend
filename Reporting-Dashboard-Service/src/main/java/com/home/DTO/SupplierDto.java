package com.home.DTO;

import java.util.List;



public class SupplierDto {
	
	private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private List<String> product;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<String> getProduct() {
		return product;
	}
	public void setProduct(List<String> product) {
		this.product = product;
	}
	public SupplierDto(Long id, String name, String email, String phoneNumber, List<String> product) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.product = product;
	}
	public SupplierDto() {
		super();
	}
	@Override
	public String toString() {
		return "SupplierDto [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", product=" + product + "]";
	}
	

}
