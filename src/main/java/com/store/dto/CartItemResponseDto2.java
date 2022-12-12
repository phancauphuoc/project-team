package com.store.dto;

public class CartItemResponseDto2 {
	private int id;
	private String product_img;
	private String product_name;
	private float unit_price;
	private int quantity;
	
	public CartItemResponseDto2() {
		
	}

	public CartItemResponseDto2(int id, String product_img, String product_name, float unit_price, int quantity) {
		super();
		this.id = id;
		this.product_img = product_img;
		this.product_name = product_name;
		this.unit_price = unit_price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
}
