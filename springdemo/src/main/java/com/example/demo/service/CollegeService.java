package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.College;

public interface CollegeService {
	College addData(College college);
	List<College> GetData();
	College updateData(College college);
	void delete(int id);
}