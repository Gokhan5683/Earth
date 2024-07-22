package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Org {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameString;
	private String cityString;
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
	public Org(int id, String nameString, String cityString) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.cityString = cityString;
	}
	public Org() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
