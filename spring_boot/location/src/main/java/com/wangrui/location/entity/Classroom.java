package com.wangrui.location.entity;

import java.io.Serializable;

public class Classroom implements Serializable{

	private Integer ID;
	private String classroomName;
	private Build build;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	public Build getBuild() {
		return build;
	}
	public void setBuild(Build build) {
		this.build = build;
	}
	public Classroom(Integer iD, String classroomName, Build build) {
		super();
		ID = iD;
		this.classroomName = classroomName;
		this.build = build;
	}
	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Classroom [ID=" + ID + ", classroomName=" + classroomName + ", build=" + build + "]";
	}
	
	
	
}
