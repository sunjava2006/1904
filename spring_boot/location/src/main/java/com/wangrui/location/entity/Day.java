package com.wangrui.location.entity;

import java.io.Serializable;

public class Day implements Serializable{

	private Integer ID;
	private String day;
	
	public Day(Integer iD, String day) {
		super();
		ID = iD;
		this.day = day;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public Day() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Day [ID=" + ID + ", day=" + day + "]";
	}
	
	
}
