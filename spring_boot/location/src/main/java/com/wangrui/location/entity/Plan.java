package com.wangrui.location.entity;

import java.io.Serializable;

public class Plan implements Serializable{

	private Integer ID;
	private Classroom classroom;
	private MyClass myclass;
	private Subject subject;
	private Day day;
	private Times times;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public MyClass getMyclass() {
		return myclass;
	}
	public void setMyclass(MyClass myclass) {
		this.myclass = myclass;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Day getDay() {
		return day;
	}
	public void setDay(Day day) {
		this.day = day;
	}
	public Times getTimes() {
		return times;
	}
	public void setTimes(Times times) {
		this.times = times;
	}
	public Plan(Integer iD, Classroom classroom, MyClass myclass, Subject subject, Day day, Times times) {
		super();
		ID = iD;
		this.classroom = classroom;
		this.myclass = myclass;
		this.subject = subject;
		this.day = day;
		this.times = times;
	}
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Plan [ID=" + ID + ", classroom=" + classroom + ", myclass=" + myclass + ", subject=" + subject
				+ ", day=" + day + ", times=" + times + "]";
	}
	
	
}
