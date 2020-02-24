package com.wangrui.news.entity;

import java.io.Serializable;

public class News implements Serializable{

	private Integer id;
	private String title;
	private String content;
	

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
