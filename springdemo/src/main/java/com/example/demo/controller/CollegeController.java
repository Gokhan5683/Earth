package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.College;
import com.example.demo.serviceimp.CollegeServiceImp;

@RestController
@RequestMapping("/home")
public class CollegeController {

	CollegeServiceImp collegeServiceImp;

	public CollegeController(CollegeServiceImp collegeServiceImp) {
		super();
		this.collegeServiceImp = collegeServiceImp;
	}
	@GetMapping("/display")
	public ResponseEntity<List<College>> display( College college)
	{
		List<College> l1=collegeServiceImp.GetData();

		return new ResponseEntity<>(l1,HttpStatus.OK);

	}

	@PostMapping("/save")
	public ResponseEntity<College> savdata(@RequestBody College college)
	{
		College c=collegeServiceImp.addData(college);
		return new ResponseEntity<>(c,HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteData(@PathVariable ("id") Integer id)
	{
		collegeServiceImp.delete(id);
		return new ResponseEntity<>("Data deleted",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<College> updateda(@PathVariable ("id") Integer id,@RequestBody College college)
	{
		college.setIdString(id);
		College c1=collegeServiceImp.updateData(college);
		return new ResponseEntity<>(c1,HttpStatus.OK);
	}


	
}