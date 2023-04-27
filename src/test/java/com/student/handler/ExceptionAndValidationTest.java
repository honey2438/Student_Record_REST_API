package com.student.handler;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.magic.handler.ExceptionAndValidationHandler;
import com.magic.handler.InvalidIdException;

import com.magic.handler.StudentNotFoundException;

public class ExceptionAndValidationTest {

	private ExceptionAndValidationHandler handler;
	private MethodArgumentNotValidException methodArgumentNotValidException;

	@Before(value = "")
	public void setUp() {
		handler = new ExceptionAndValidationHandler();
		methodArgumentNotValidException = mock(MethodArgumentNotValidException.class);
	}

	@Test
	public void handleMethodArgumentNotValid_ReturnsBadRequest() {
		BindingResult bindingResult = mock(BindingResult.class);
		List<ObjectError> errors = new ArrayList<>();
		ObjectError objectError = new ObjectError("testObject", "testError");
		errors.add(objectError);
	}

	@Test
	public void handleStudentNotFoundException_ReturnsNotFound() {
		String errorMessage = "Student not found exception";
		StudentNotFoundException ex = new StudentNotFoundException(errorMessage);
		List<String> errorList = new ArrayList<>();
		errorList.add(errorMessage);

	}

	@Test
	public void handleInvalidIdException_ReturnsBadRequest() {
		String errorMessage = "Invalid ID exception";
		InvalidIdException ex = new InvalidIdException(errorMessage);
		List<String> errorList = new ArrayList<>();
		errorList.add(errorMessage);

	}
}
