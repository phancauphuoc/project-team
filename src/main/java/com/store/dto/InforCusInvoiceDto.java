package com.store.dto;

import java.sql.Date;

/**
 * @author hieun
 * 16 Aug 2022  08:38:30
 *
 * cloud.com.store.dto.InforCusInvoiceDto
 */
public class InforCusInvoiceDto {
	
	private String fullName;
	private String phoneNumber;
	private String address;
	private Date orderDate;
	private Date receiptDate;
	
	public InforCusInvoiceDto(String fullName, String phoneNumber, String address, Date orderDate, Date receiptDate) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.address = address;
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
