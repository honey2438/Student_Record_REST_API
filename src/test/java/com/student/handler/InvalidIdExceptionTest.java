package com.student.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.magic.handler.InvalidIdException;

public class InvalidIdExceptionTest {
	@Test
	public void testSetCode() {

		  String errorMessage = "Enrollment id must start with 'MAGIC'";
		    InvalidIdException exception = new InvalidIdException(errorMessage);
		    assertEquals(errorMessage, exception.getMessage());
	}
}
