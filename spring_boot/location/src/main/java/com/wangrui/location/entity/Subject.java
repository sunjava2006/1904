package com.wangrui.location.entity;

import java.io.Serializable;

public class Subject implements Serializable{

	private Integer ID;
	private String subjectID;
	private String subjectName;
	
	public Subject(Integer iD, String subjectID, String subjectName) {
		super();
		ID = iD;
		this.subjectID = subjectID;
		this.subjectName = subjectName;
	}
	
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
}
