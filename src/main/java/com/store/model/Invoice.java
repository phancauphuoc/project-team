package com.store.model;

import java.sql.Timestamp;

/**
 * @author hieun
 * 14 Aug 2022  11:19:12
 *
 * cloud.com.store.model.Invoice
 */
public class Invoice {
	private int id;
	private int customerId;
	private Timestamp orderDate;
	private Timestamp receiptDate;
	private int state;
	
	public Invoice(int id, int customerId, Timestamp receiptDate) {
		this.id = id;
		this.customerId = customerId;
		this.receiptDate = receiptDate;
	}
	
	public Invoice(int id, int customerId, Timestamp orderDate, Timestamp receiptDate, int state) {
		this.id = id;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.receiptDate = receiptDate;
		this.state = state;
	}


	public Invoice(int customerId, Timestamp orderDate, Timestamp receiptDate, int state) {
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.receiptDate = receiptDate;
		this.state = state;
	}
	
	public Invoice(int id, int customerId,int state) {
		this.id = id;
		this.customerId = customerId;
		this.state = state;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Timestamp getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Timestamp receiptDate) {
		this.receiptDate = receiptDate;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
	
	
}
