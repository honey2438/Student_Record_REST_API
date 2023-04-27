package com.student.handler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.magic.handler.StudentNotFoundException;

class StudentNotFoundExceptionTest {

	@Test
	public void testStudentNotFoundExceptionConstructor() {
	    String errorMessage = "Student not found";
	    StudentNotFoundException exception = new StudentNotFoundException(errorMessage);
	    assertEquals(errorMessage, exception.getMessage());
	}

}
