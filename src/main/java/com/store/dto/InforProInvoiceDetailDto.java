package com.store.dto;

/**
 * @author hieun
 * 16 Aug 2022  08:39:13
 *
 * cloud.com.store.dto.InforProInvoiceDetailDto
 */
public class InforProInvoiceDetailDto {
	
	private String productName;
	private String imgProduct;
	private int quantity;
	private float price;
	
	public InforProInvoiceDetailDto(String productName, String imgProduct, int quantity, float price) {
		this.productName = productName;
		this.imgProduct = imgProduct;
		this.quantity = quantity;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImgProduct() {
		return imgProduct;
	}

	public void setImgProduct(String imgProduct) {
		this.imgProduct = imgProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	

}
