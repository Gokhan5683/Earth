package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameString;
	private String city;
	private String deptString;
	@OneToOne
	private Org org;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String nameString, String city, String deptString, Org org) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.city = city;
		this.deptString = deptString;
		this.org = org;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDeptString() {
		return deptString;
	}

	public void setDeptString(String deptString) {
		this.deptString = deptString;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}
	
}
