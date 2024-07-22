package com.example.demo.entity;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameString;
	private String deptString;
	@ManyToMany(targetEntity = Teacher.class)
	private Set teacher;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getDeptString() {
		return deptString;
	}
	public void setDeptString(String deptString) {
		this.deptString = deptString;
	}
	public Set getTeacher() {
		return teacher;
	}
	public void setTeacher(Set teacher) {
		this.teacher = teacher;
	}
	public Subject(int id, String nameString, String deptString, Set teacher) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.deptString = deptString;
		this.teacher = teacher;
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
