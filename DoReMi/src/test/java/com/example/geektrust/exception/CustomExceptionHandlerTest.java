package com.example.geektrust.exception;

import org.junit.jupiter.api.BeforeEach;

class CustomExceptionHandlerTest {

    private CustomExceptionHandler customExceptionHandlerUnderTest;

    @BeforeEach
    void setUp() {
        customExceptionHandlerUnderTest = new CustomExceptionHandler("message");
    }
}
