package com.store.dto;

//Author: Nam Phương

public class CartItemRequestDto {
	private int id;
	
	//_________________________________________________________________________________________________
		//DTO request => phải có Default Constructor, 
		// Vì khi đi vào API (trong file Controller), Spring sẽ tự tạo cho mình thằng instance của DTO này.
		// Do đó, bắt buộc DTO phải có Default Constructor này.
	//_________________________________________________________________________________________________
	
	//Default constructor
	public CartItemRequestDto() {
		super();
	}
	
	//Constructor having param
	public CartItemRequestDto(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
