package com.ssm.wechatshop.entities;

import javax.persistence.Entity;

@Entity
public class School {

	private int id;
	private String school;
	private String building;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	
	@Override
	public String toString() {
		return "School [id=" + id + ", school=" + school + ", building=" + building + "]";
	}
	
}
