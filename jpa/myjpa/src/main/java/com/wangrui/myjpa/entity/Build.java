package com.wangrui.myjpa.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ValueGenerationType;

@SequenceGenerator(allocationSize = 1, sequenceName = "seq_builds", name = "seq_builds")
@Entity
@Table(name = "builds")

public class Build {

	@Id
	@GeneratedValue(generator = "seq_builds" , strategy = GenerationType.SEQUENCE)
	private Integer ID;
	private String name;
	private Double latitude;
	private Double longitude;

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

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Build [ID=" + ID + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	public Build(Integer iD, String name, Double latitude, Double longitude) {
		super();
		ID = iD;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Build() {

	}

}
