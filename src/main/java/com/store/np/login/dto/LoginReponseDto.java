package com.store.np.login.dto;

public class LoginReponseDto {
	private int id;
	private String username;
	
	public LoginReponseDto(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

	
	
	
}
