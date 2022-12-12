package com.store.dto;

//Author: Nam Phương

public class UserAccountRequestDto {
	
	private String username; 
	private String password;
	
	//_________________________________________________________________________________________________
		//DTO request => phải có Default Constructor, 
		// Vì khi đi vào API (trong file Controller), Spring sẽ tự tạo cho mình thằng instance của DTO này.
		// Do đó, bắt buộc DTO phải có Default Constructor này.
	//_________________________________________________________________________________________________
	
	//Default constructor
	public UserAccountRequestDto() {
		
	}
	
	//Constructor having param
	public UserAccountRequestDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	//----------------------------------------
	//Setter, Getter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
