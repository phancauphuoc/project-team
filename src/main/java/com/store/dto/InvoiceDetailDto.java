package com.store.dto;

import java.sql.Date;

/**
 * @author hieun
 * 15 Aug 2022  21:30:57
 *
 * cloud.com.store.dto.InvoiceDetailDto
 */
public class InvoiceDetailDto {

	private String fullName;
	private String phoneNumber;
	private String address;
	private String productName;
	private String imgProduct;
	private int quantity;
	private float price;
	private Date orderDate;
	private Date receiptDate;
	
	public InvoiceDetailDto(String fullName, String phoneNumber, String address, String productName, String imgProduct,
			int quantity, float price, Date orderDate, Date receiptDate) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.productName = productName;
		this.imgProduct = imgProduct;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
		this.receiptDate = receiptDate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
	
	
	
	
}
