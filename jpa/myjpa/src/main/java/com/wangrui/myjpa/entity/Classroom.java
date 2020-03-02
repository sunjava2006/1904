package com.wangrui.myjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator( sequenceName = "seq_classrooms", name = "seq_classrooms", allocationSize = 1)

@Entity
@Table(name="classrooms")
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_classrooms")
	private Integer ID;
	
	@Column(name = "classroom_name")
	private String classroomName;
	
	@ManyToOne(targetEntity = Build.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "build_id")
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
		ID = iD;
		this.classroomName = classroomName;
		this.build = build;
	}

	public Classroom() {

	}

	@Override
	public String toString() {
		return "Classroom [ID=" + ID + ", classroomName=" + classroomName + ", build=" + build + "]";
	}
	
	
}
