package com.example.demo.entity;


import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameString;
	private String cityString;
	@ManyToMany(targetEntity = Subject.class)
	private Set subjects;
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
	public String getCityString() {
		return cityString;
	}
	public void setCityString(String cityString) {
		this.cityString = cityString;
	}
	public Set getSubjects() {
		return subjects;
	}
	public void setSubjects(Set subjects) {
		this.subjects = subjects;
	}
	public Teacher(int id, String nameString, String cityString, Set subjects) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.cityString = cityString;
		this.subjects = subjects;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
}
