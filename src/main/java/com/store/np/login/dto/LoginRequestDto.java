package com.store.np.login.dto;

public class LoginRequestDto {
	private String username;
	private String password;
	
	//_________________________________________________________________________________________________
			//DTO request => phải có Default Constructor, 
			// Vì khi đi vào API (trong file Controller), Spring sẽ tự tạo cho mình thằng instance của DTO này.
			// Do đó, bắt buộc DTO phải có Default Constructor này.
	//_________________________________________________________________________________________________
		
	//default constructor
	public LoginRequestDto() {
		
	}
	
	//constructor with param
	public LoginRequestDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

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

//user
