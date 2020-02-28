package com.wangrui.location.entity;

import java.io.Serializable;

public class News implements Serializable{

	private Integer ID;
	private String name;
	
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
	
	@Override
	public String toString() {
		return "Test [ID=" + ID + ", name=" + name + "]";
	}
	
	public News(Integer iD, String name) {
		ID = iD;
		this.name = name;
	}
	
	public News() {
		
	}
	
	
}
