package com.magic.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magic.handler.IdAlreadyExistException;
import com.magic.handler.InvalidIdException;
import com.magic.handler.StudentNotFoundException;
import com.magic.models.Address;
import com.magic.models.Student;
import com.magic.repositories.StudentRepo;
import com.magic.services.StudentServices;

@Service
public class StudentServicesImpl implements StudentServices {
	@Autowired
	private StudentRepo studentRepo;
	private final String str="No record found";

	public Student createStudentResource(Student student) {
		if (!student.getEnrollmentId().startsWith("MAGIC")) {
			throw new InvalidIdException("Enrollment id must start with 'MAGIC'");
		}
		else if(studentRepo.findById(student.getEnrollmentId()).orElse(null) != null)throw new IdAlreadyExistException("This Id already exists");
		return studentRepo.save(student);
	}

	public Student getStudentResource(String enrollmentId) {
		if (studentRepo.findById(enrollmentId).orElse(null) == null)
			throw new StudentNotFoundException(str);
		else
			return studentRepo.findById(enrollmentId).orElse(null);
	}

	public Student updateStudentResource(String enrollmentId, Address address) {
		if (studentRepo.findById(enrollmentId).orElse(null) == null)
			throw new StudentNotFoundException(str);
		else {
			Student student = studentRepo.findById(enrollmentId).orElse(null);
			student.setAddress(address);
			return studentRepo.save(student);
		}
	}

	public void deleteStudentResource(String enrollmentId) {
		if (studentRepo.findById(enrollmentId).orElse(null) == null)
			throw new StudentNotFoundException(str);
		else {
			studentRepo.deleteById(enrollmentId);
		}
	}

}
