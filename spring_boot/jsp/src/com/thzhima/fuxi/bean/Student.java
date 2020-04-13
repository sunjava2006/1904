package com.thzhima.fuxi.bean;

import java.io.Serializable;

public class Student implements Serializable{

	private Integer ID;
	private Integer studentID ;
	private String studentName;
	private String gender;
	private String passwd;
	private Integer classID;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Integer getClassID() {
		return classID;
	}
	public void setClassID(Integer classID) {
		this.classID = classID;
	}
	public Student(Integer iD, Integer studentID, String studentName, String gender, String passwd, Integer classID) {
		super();
		ID = iD;
		this.studentID = studentID;
		this.studentName = studentName;
		this.gender = gender;
		this.passwd = passwd;
		this.classID = classID;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", studentID=" + studentID + ", studentName=" + studentName + ", gender=" + gender
				+ ", passwd=" + passwd + ", classID=" + classID + "]";
	}
	
	
}
