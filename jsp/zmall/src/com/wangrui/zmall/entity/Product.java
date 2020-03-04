package com.wangrui.zmall.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable{
	
	private Integer ID;
	private String name;
	private String desc;
	private BigDecimal price;
	private String unit;
	
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
	public Product(Integer iD, String name, String desc, BigDecimal price, String unit) {
		super();
		ID = iD;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.unit = unit;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + ", desc=" + desc + ", price=" + price + ", unit=" + unit + "]";
	}
	
	

}
