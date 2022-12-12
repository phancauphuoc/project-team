package com.store.model;

//Author: Nam Phương

public class Cart {
	private int id;
	private String user_name;
	private int id_product;
	private int quantity;
	
	public Cart() {
		
	}
	
	public Cart(String user_name, int id_product, int quantity) {
		super();

		this.user_name = user_name;
		this.id_product = id_product;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

	
}