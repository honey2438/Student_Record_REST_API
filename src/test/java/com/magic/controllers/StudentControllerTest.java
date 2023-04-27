package com.magic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.magic.models.Address;
import com.magic.models.Student;
import com.magic.services.StudentServices;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {
	@MockBean
	private StudentServices studentService;
	@InjectMocks
	private StudentController studentController;

	@Test
	public void testGetStudent() {
		Address address1 = new Address("Delhi", "U.P", "23001");
		Student student = new Student("MAGIC0003", address1, "Kumar", "01/05/1990", "Computer science and Engg");
		String enrollmentId = student.getEnrollmentId();
		when(studentService.getStudentResource(enrollmentId)).thenReturn(student);
		ResponseEntity<Student> response = studentController.getResource(enrollmentId);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(student, response.getBody());
	}

	@Test
	public void testAddStudent() {
		Address address1 = new Address("Delhi", "U.P", "23001");
		Student student = new Student("MAGIC0003", address1, "Kumar", "01/05/1990", "Computer science and Engg");
		when(studentService.createStudentResource(student)).thenReturn(student);
		ResponseEntity<Student> response = studentController.createResource(student);

		assertEquals(student, response.getBody());
	}

	@Test
	void testDeleteStudent() {
		String enrollmentId = "MAGIC0003";

		ResponseEntity<Student> response = studentController.deleteResource(enrollmentId);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void testUpdateAddress() {

		String enrollmentId = "MAGIC0001";
		Address address1 = new Address("Delhi", "U.P", "23001");
		Student updatedStudent = new Student(enrollmentId, address1, "Kumar", "01/05/1990",
				"Computer science and Engg");

		when(studentService.updateStudentResource(enrollmentId, address1)).thenReturn(updatedStudent);

		ResponseEntity<Student> response = studentController.updateResource(enrollmentId, address1);

		verify(studentService).updateStudentResource(enrollmentId, address1);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
