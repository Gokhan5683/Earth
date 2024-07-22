package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idString;
	private String nameString;
	private String cityString;
	private float turnover;
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College(int idString, String nameString, String cityString, float turnover) {
		super();
		this.idString = idString;
		this.nameString = nameString;
		this.cityString = cityString;
		this.turnover = turnover;
	}
	public int getIdString() {
		return idString;
	}
	public void setIdString(int idString) {
		this.idString = idString;
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
	public float getTurnover() {
		return turnover;
	}
	public void setTurnover(float turnover) {
		this.turnover = turnover;
	}
}
