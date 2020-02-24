package com.wangrui.location.entity;

import java.io.Serializable;
import java.sql.Date;

public class Times implements Serializable {

	private Integer ID;
	private String timeName;
	private Date startTime;
	private Date endTime;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getTimeName() {
		return timeName;
	}
	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Times(Integer iD, String timeName, Date startTime, Date endTime) {
		super();
		ID = iD;
		this.timeName = timeName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Times() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Times [ID=" + ID + ", timeName=" + timeName + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
