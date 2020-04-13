package com.wangrui.products.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator(sequenceName = "seq_products", name = "seq_products", allocationSize = 1)// 申明序列
@Entity
@Table(name = "t_products")
public class Product implements Serializable{

	@Id // 主键
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_products")// 主键的生成
	@Column(name = "id")
	private Integer ID;
	
	private String productName; // JPA采用名字宽松策略能识别对应的列
	
	private Boolean status;
	
	private BigDecimal price; // 数据库中的同名列
	
	@Column(name = "product_desc")// 指定与数据库中哪一列对应
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
