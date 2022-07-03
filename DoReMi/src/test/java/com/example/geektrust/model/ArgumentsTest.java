package com.example.geektrust.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArgumentsTest {

    private Arguments argumentsUnderTest;

    @BeforeEach
    void setUp() {
        argumentsUnderTest = new Arguments(Operator.START_SUBSCRIPTION, Arrays.asList("10-20-2022"));
    }

    @Test
    void testOperandValidator() {
        // Setup

        // Run the test
        argumentsUnderTest.operandValidator();

        // Verify the results
    }

    @Test
    void testFrom() {
        // Run the test
        final Arguments result = Arguments.from("START_SUBSCRIPTION 10-20-2022");
        assertEquals(Operator.START_SUBSCRIPTION, result.getOperator());
        assertEquals(Arrays.asList("10-20-2022"), result.getOperands());
    }
}
