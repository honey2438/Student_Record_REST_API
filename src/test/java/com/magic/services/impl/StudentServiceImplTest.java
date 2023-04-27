package com.magic.services.impl;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.magic.handler.IdAlreadyExistException;
import com.magic.handler.InvalidIdException;
import com.magic.handler.StudentNotFoundException;
import com.magic.models.Address;
import com.magic.models.Student;
import com.magic.repositories.StudentRepo;

public class StudentServiceImplTest {

	@Mock
	private StudentRepo studentRepo;

	@InjectMocks
	private StudentServicesImpl studentService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateStudentResource() {

		Address address1 = new Address("Delhi", "U.P", "23001");
		Student student = new Student("MAGIC0001", address1, "Kumar", "01/05/1990", "Computer science and Engg");

		when(studentRepo.findById("123")).thenReturn(Optional.of(student));

	}

	@Test
	void testGetStudentResource() {

		Address address1 = new Address("Delhi", "U.P", "23001");
		Student student = new Student("MAGIC0001", address1, "Kumar", "01/05/1990", "Computer science and Engg");

		when(studentRepo.findById("123")).thenReturn(Optional.of(student));

		Assertions.assertEquals(student, studentService.getStudentResource("123"));

		Assertions.assertThrows(StudentNotFoundException.class, () -> {
			studentService.getStudentResource("456");
		});
	}

	@Test
	void testDeleteStudentResource() {

		Address address1 = new Address("Delhi", "U.P", "23001");
		Student student = new Student("MAGIC0001", address1, "Kumar", "01/05/1990", "Computer science and Engg");

		when(studentRepo.findById("123")).thenReturn(Optional.of(student));

		Assertions.assertThrows(StudentNotFoundException.class, () -> {
			studentService.deleteStudentResource("456");
		});

	}

	@Test
	void testUpdateStudentResource() {

		Address address1 = new Address("Delhi", "U.P", "23001");

		Student student = new Student("MAGIC0001", address1, "Kumar", "01/05/1990", "Computer science and Engg");

		when(studentRepo.findById("123")).thenReturn(Optional.of(student));

		Assertions.assertThrows(StudentNotFoundException.class, () -> {
			studentService.updateStudentResource("456", new Address("Meerut", "up", "22334"));
		});
	}
}
