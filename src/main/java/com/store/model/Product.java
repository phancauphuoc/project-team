package com.store.model;

import java.beans.Transient;
import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author hieun
 *
 */

public class Product {

	private int id;
//	@Column(name="product_name")
	private String productName;
	private String description;
//	@Column(name="unit_price")
	private float unitPrice;
	private int inventory;
//	@JoinColumn(name="category_id")
	private int categoryId;
//	@Column(name="product_img")
	private String productImg;
	private BigDecimal promotion;
	private BigDecimal rate;
	private int status;
	
//Thêm field (nhưng không thêm dô bảng DB)
//	@Transient
	private MultipartFile file;
	
	//---------------------------------------------
	// Sau khi lấy được link sản phẩm. Ví dụ:
    // https://res.cloudinary.com/sport-store/image/upload/v1659931035/cld-sample-5.jpg
    // => Lưu địa chỉ link này vào DB (có nghĩa lưu vào productImg)
	public MultipartFile getFile() { 
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
//----------------------------------------------
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id, String productName, String description, float unitPrice, int inventory, int categoryId,
			String productImg, BigDecimal promotion, BigDecimal rate, int status) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.inventory = inventory;
		this.categoryId = categoryId;
		this.productImg = productImg;
		this.promotion = promotion;
		this.rate = rate;
		this.status = status;
	}
	
	public Product(int id, String productName, String description, float unitPrice, int inventory, int categoryId,
			String productImg, BigDecimal promotion, int status) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.inventory = inventory;
		this.categoryId = categoryId;
		this.productImg = productImg;
		this.promotion = promotion;
		this.status = status;
	}
	
	public Product(String productName, String description, float unitPrice, int inventory, int categoryId,
			String productImg, BigDecimal promotion, BigDecimal rate, int status) {
		super();
		this.productName = productName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.inventory = inventory;
		this.categoryId = categoryId;
		this.productImg = productImg;
		this.promotion = promotion;
		this.rate = rate;
		this.status = status;
	}

	

	public Product(String productName, String description, float unitPrice, int inventory, int categoryId,
			String productImg, BigDecimal promotion, int status) {
		super();
		this.productName = productName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.inventory = inventory;
		this.categoryId = categoryId;
		this.productImg = productImg;
		this.promotion = promotion;
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int category_id) {
		this.categoryId = category_id;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public BigDecimal getPromotion() {
		return promotion;
	}

	public void setPromotion(BigDecimal promotion) {
		this.promotion = promotion;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", unitPrice="
				+ unitPrice + ", inventory=" + inventory + ", categoryId=" + categoryId + ", productImg=" + productImg
				+ ", promotion=" + promotion + ", rate=" + rate + ", status=" + status + "]";
	}
	
	
}