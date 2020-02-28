package com.wangrui.location.entity;

import java.io.Serializable;

public class Build implements Serializable{

	private Integer ID;
	private String name;
	private double latitude;
	private double longitude;
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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Build(Integer iD, String name, double latitude, double longitude) {
		super();
		ID = iD;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Build() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Build [ID=" + ID + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
}
