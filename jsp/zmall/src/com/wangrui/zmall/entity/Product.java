package com.wangrui.zmall.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable{
	
	private Integer ID;
	private String name;
	private String desc;
	private BigDecimal price;
	private String unit;
	private Date publishDate;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	public Date getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public Product(Integer iD, String name, String desc, BigDecimal price, String unit, Date publishDate) {
		super();
		ID = iD;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.unit = unit;
		this.publishDate = publishDate;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
