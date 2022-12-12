package com.store.dto;

//Author: Nam Phương

public class CartItemResponseDto { //Dto ~ 1 item (in Cart)
	private String product_name;
	private float unit_price;
	private int quantity;
	
	public CartItemResponseDto() {
		
	}
	
	public CartItemResponseDto(String product_name, float unit_price, int quantity) {
		super();
		this.product_name = product_name;
		this.unit_price = unit_price;
		this.quantity = quantity;
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
