package com.magic.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.magic.models.Address;
import com.magic.models.Student;
import com.magic.services.StudentServices;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentServices studentServices;
    
	@PostMapping("")
	ResponseEntity<Student> createResource(@Valid @RequestBody Student student) {
		Student student1 = studentServices.createStudentResource(student);
		return ResponseEntity.status(200).body(student1);

	}

	@GetMapping("")
	ResponseEntity<Student> getResource(@RequestParam String enrollmentId) {
		Student student1 = studentServices.getStudentResource(enrollmentId);
		return ResponseEntity.status(200).body(student1);
	}

	@PatchMapping("{enrollmentId}")
	ResponseEntity<Student> updateResource(@PathVariable String enrollmentId,@RequestBody Address address) {
		studentServices.updateStudentResource(enrollmentId, address);
		return ResponseEntity.status(200).build();
	}

	@DeleteMapping("")
	ResponseEntity<Student> deleteResource(@RequestParam String enrollmentId) {
		studentServices.deleteStudentResource(enrollmentId);
		return ResponseEntity.status(200).build();
	}

}
