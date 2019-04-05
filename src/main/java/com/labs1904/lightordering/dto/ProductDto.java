package com.labs1904.lightordering.dto;

import java.time.LocalDateTime;

public class ProductDto {
    
	private int id;
	private int catalogId;
	private LocalDateTime effectiveDate;
	private LocalDateTime expirationDate;
	private OrderDto order;
	private String status;
	private CustomerDto customer;
	private ProductDto parent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	public LocalDateTime getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(LocalDateTime effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}
	public OrderDto getOrder() {
		return order;
	}
	public void setOrder(OrderDto order) {
		this.order = order;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	public ProductDto getParent() {
		return parent;
	}
	public void setParent(ProductDto parent) {
		this.parent = parent;
	}
	
}
