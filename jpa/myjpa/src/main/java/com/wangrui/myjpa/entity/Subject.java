package com.wangrui.myjpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator(sequenceName = "seq_subjects", name="seq_subjects")
@Entity
@Table(name = "subjects")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_subjects")
	private Integer ID;
	
	private String subjectID;
	
	@Column(name = "subject_name")
	private String name;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "teach", 
	           joinColumns=@JoinColumn(referencedColumnName = "subject_id"),
	           inverseJoinColumns = @JoinColumn(referencedColumnName = "teacher_id"))
	private List<Teacher> teachers;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Subject(Integer iD, String subjectID, String name, List<Teacher> teachers) {
		super();
		ID = iD;
		this.subjectID = subjectID;
		this.name = name;
		this.teachers = teachers;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Subject [ID=" + ID + ", subjectID=" + subjectID + ", name=" + name + "]";
	}
	
	
	
}
