package com.magic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.magic.models.Address;
import com.magic.models.Student;
import com.magic.repositories.StudentRepo;
import com.magic.services.impl.StudentServicesImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
	@Mock
	private StudentRepo studentRepository;
	@InjectMocks
	private StudentServicesImpl StudentService;

	@Test
	void testgetStudentById() {
		Address address1 = new Address("Delhi", "U.P", "23001");
		Student s1 = new Student("MAGIC0003", address1, "Kumar", "01/05/1990", "Computer science and Engg");
		when(studentRepository.findById("MAGIC0003")).thenReturn(Optional.of(s1));
		assertEquals(s1.getName(), StudentService.getStudentResource("MAGIC0003").getName());

	}

	@Test
	void testaddStudent() {
		Address address1 = new Address("Delhi", "U.P", "23001");
		Student student = new Student("MAGIC0001", address1, "Kumar", "01/05/1990", "Computer science and Engg");
		StudentService.createStudentResource(student);
		verify(studentRepository).save(student);

	}

	@Test
	void TestupdateStudent() {
		Address address1 = new Address("Delhi", "U.P", "23001");
		Student student = new Student("MAGIC0001", address1, "Kumar", "01/05/1990", "Computer science and Engg");
		when(studentRepository.findById("MAGIC0001")).thenReturn(Optional.of(student));
		StudentService.updateStudentResource("MAGIC0001", address1);
		verify(studentRepository).save(student);

	}

	@Test
	public void testDeleteStudentResource() {
		String enrollmentId = "123456";
		Address address1 = new Address("Delhi", "U.P", "23001");
		when(studentRepository.findById(enrollmentId)).thenReturn(
				Optional.of(new Student("MAGIC0001", address1, "Kumar", "01/05/1990", "Computer science and Engg")));
		StudentService.deleteStudentResource(enrollmentId);
		verify(studentRepository).deleteById(enrollmentId);
	}

}
