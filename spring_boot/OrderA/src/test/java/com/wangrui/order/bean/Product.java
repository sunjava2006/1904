package com.wangrui.order.bean;

import java.math.BigDecimal;

public class Product {

	private Integer ID;
	private String productName; 
	private Boolean status;
	private BigDecimal price;
	private String desc;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Product(Integer iD, String productName, Boolean status, BigDecimal price, String desc) {
		super();
		ID = iD;
		this.productName = productName;
		this.status = status;
		this.price = price;
		this.desc = desc;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Product [ID=" + ID + ", productName=" + productName + ", status=" + status + ", price=" + price
				+ ", desc=" + desc + "]";
	}
	
	
	
}
