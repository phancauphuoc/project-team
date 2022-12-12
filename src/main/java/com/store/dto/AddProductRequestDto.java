package com.store.dto;

import java.math.BigDecimal;

/**
 * 
 * @author Hieu
 *
 */

public class AddProductRequestDto {

		private String productName;
		private String description;
		private float unitPrice;
		private int inventory;
		private int categoryId;
		private String productImg;
		private BigDecimal promotion;
		private int status;

		public AddProductRequestDto(String productName, String description, float unitPrice, int inventory,
				int categoryId, String productImg, BigDecimal promotion, int status) {
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

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}
			
	}

