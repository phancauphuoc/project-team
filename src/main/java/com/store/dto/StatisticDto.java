package com.store.dto;

/**
 * @author hieun
 * 13 Aug 2022  17:32:47
 *
 * cloud.com.store.dto.StatisticDto
 */
public class StatisticDto {

	private int idProduct;
	private String productName;
	private String productImg;
	private int quantity;
	private int amount;
	private int receiptDate;
	
	public StatisticDto(int idProduct, String productName, String productImg, int quantity, int amount, int receiptDate) {
		this.idProduct = idProduct;
		this.productName = productName;
		this.productImg = productImg;
		this.quantity = quantity;
		this.amount = amount;
		this.receiptDate = receiptDate;
	}
	
	

	public StatisticDto(int idProduct, int quantity, int amount, int receiptDate) {
		super();
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.amount = amount;
		this.receiptDate = receiptDate;
	}



	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(int receiptDate) {
		this.receiptDate = receiptDate;
	}

	
	
	
	
	
}
