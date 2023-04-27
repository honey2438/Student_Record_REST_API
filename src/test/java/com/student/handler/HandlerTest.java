package com.student.handler;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.magic.handler.ExceptionAndValidationHandler;
import com.magic.handler.InvalidIdException;
import com.magic.handler.StudentNotFoundException;

@ExtendWith(MockitoExtension.class)
public class HandlerTest {

    @Test
    void test_Handlers() {
        ExceptionAndValidationHandler hand = new ExceptionAndValidationHandler();

        hand.handleStudentNotFoundException(new StudentNotFoundException(""));
        hand.InvalidIdException(new InvalidIdException(""));
    }

}
