package com.wangrui.news.entity;

import java.io.Serializable;

public class Picture implements Serializable {

	private Integer newsID;
	private String pictureName;
	
	@Override
	public String toString() {
		return "Picture [newsID=" + newsID + ", pictureName=" + pictureName + "]";
	}
	
	public Integer getNewsID() {
		return newsID;
	}
	public void setNewsID(Integer newsID) {
		this.newsID = newsID;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	
	
}
