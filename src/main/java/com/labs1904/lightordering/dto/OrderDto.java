package com.labs1904.lightordering.dto;

import java.time.LocalDateTime;

public class OrderDto {

	private int id;
	private CustomerDto customer;
	private LocalDateTime createDate;
	private LocalDateTime dueDate;
	private LocalDateTime completionDate;
	private ProductDto product;
	private String status;
	private UserDto createdBy;
	
}
