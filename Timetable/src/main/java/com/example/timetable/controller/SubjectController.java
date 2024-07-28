package com.example.timetable.controller;

import com.example.timetable.exception.ResourceNotFoundException;
import com.example.timetable.model.Subject;
import com.example.timetable.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class SubjectController {
 
    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
    
    @PostMapping("/subjects")
    public Subject createSubject(@RequestBody Subject subject) {
        //TODO: process POST request
        return subjectRepository.save(subject);
    }
    
    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id){
    	Subject subject=subjectRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Subject not exist with id : "+id));
    	return ResponseEntity.ok(subject);
    }
    
    @PutMapping("/subjects/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subjectDetails){
		Subject subject = subjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Subject not exist with id :" + id));
		subject.setName(subjectDetails.getName());
		subject.setTeacher(subjectDetails.getTeacher());	
		Subject updatedSubject = subjectRepository.save(subject);
		return ResponseEntity.ok(updatedSubject);
	}
	// delete subject rest api
	@DeleteMapping("/subjects/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSubject(@PathVariable Long id){
		Subject subject = subjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Subject not exist with id :" + id));
		
		subjectRepository.delete(subject);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}