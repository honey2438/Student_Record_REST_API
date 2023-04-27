package com.student.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.magic.handler.IdAlreadyExistException;

class IdAlreadyExistsExceptionTest {

	@Test
	public void testSetCode() {

		String errorMessage = "This Id already exists";
		IdAlreadyExistException exception = new IdAlreadyExistException(errorMessage);
		assertEquals(errorMessage, exception.getMessage());
	}

}
