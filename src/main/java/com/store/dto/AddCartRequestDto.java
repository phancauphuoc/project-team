package com.store.dto;

//Author: Nam Phương

public class AddCartRequestDto {
	private String username; 
	private int idproduct;
	private int quantity;
	
	//_________________________________________________________________________________________________
		//DTO request => phải có Default Constructor, 
		// Vì khi đi vào API (trong file Controller), Spring sẽ tự tạo cho mình thằng instance của DTO này.
		// Do đó, bắt buộc DTO phải có Default Constructor này.
	//_________________________________________________________________________________________________
	
	//default constructor
	public AddCartRequestDto() {
		
	}
	
	//constructor có param
	public AddCartRequestDto(String username, int idproduct, int quantity) {
		super();
		this.username = username;
		this.idproduct = idproduct;
		this.quantity = quantity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
